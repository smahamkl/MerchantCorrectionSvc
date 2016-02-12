package com.org.gmr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.org.gmr.dao.*;
import com.org.gmr.model.*;
import com.org.gmr.test.WebSoapTest;

@RestController
public class UserRestController {

	// -------------------Retrieve All UserTransactions----------------------

	@RequestMapping(value = "/usertran/{usrid}", method = RequestMethod.GET)
	public ResponseEntity<List<UserTran>> listAllUsers(@PathVariable("usrid") long id) {
		// List<UserTran> userTran = userTranService.findAllUserTran(id);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		UserTranDaoImpl userDao = (UserTranDaoImpl) context.getBean("userTranDao");
		List<UserTran> userTran = userDao.getByUser(id);
		if (userTran.isEmpty()) {
			// return new ResponseEntity<List<UserTran>>(HttpStatus.NO_CONTENT);
			return null;

		}
		return new ResponseEntity<List<UserTran>>(userTran, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/userfeedback", method = RequestMethod.GET)
	public ResponseEntity<List<UserFeedbackByLocn>> getUserFeedback() {
		// List<UserTran> userTran = userTranService.findAllUserTran(id);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		UserTranDaoImpl userDao = (UserTranDaoImpl) context.getBean("userTranDao");
		UserFeedbackDaoImpl userFeedbackDao = (UserFeedbackDaoImpl) context.getBean("userFeedbackDao");
		
		
		//List<Object[]> feedbackList= userFeedbackDao.getFeedbackAggregated();
		
		List<Object[]> locnDetailsList = userDao.getByUserLocn();
		
		if (locnDetailsList.isEmpty()) {
			return new ResponseEntity<List<UserFeedbackByLocn>>(HttpStatus.NO_CONTENT);

		}
		
		List<UserFeedbackByLocn> ufdblocn = new ArrayList<UserFeedbackByLocn>();
		
		
		for (Object[] aRow : locnDetailsList) {
			UserFeedbackByLocn uf=new UserFeedbackByLocn();
			
			List<Object[]> feedBacksListAgg=userFeedbackDao.getFeedbackAggregated(Long.parseLong(aRow[0].toString()));
			List<UserFeedbacks> l = uf.getUserFeedbacks();
			
			for (Object[] fdbckRow : feedBacksListAgg) {
				
				l.add(new UserFeedbacks(Integer.parseInt(fdbckRow[0].toString()), fdbckRow[1].toString(), ((Number)fdbckRow[2]).intValue(), fdbckRow[3].toString(),fdbckRow[4].toString(),fdbckRow[5].toString(), 
						fdbckRow[6].toString(), fdbckRow[7].toString(), Double.parseDouble(fdbckRow[8].toString()),  Double.parseDouble(fdbckRow[9].toString())));
				
			}
					
			uf.setUserFeedbacks(l);
			
			uf.setLocnId(Long.parseLong(aRow[0].toString()));
			uf.setMrchName(aRow[1].toString());
			uf.setMrchCatg(Integer.parseInt(aRow[2].toString()));
			uf.setMrchAddress(aRow[3].toString());
			uf.setMrchCity(aRow[4].toString());
			uf.setMrchState(aRow[5].toString());
			uf.setMrchZip(aRow[6].toString());
			uf.setMrchCtry(aRow[7].toString());
			uf.setMrchLat(Double.parseDouble(aRow[8].toString()));
			uf.setMrchLong(Double.parseDouble(aRow[9].toString()));

			ufdblocn.add(uf);

		}
		
		return new ResponseEntity<List<UserFeedbackByLocn>>(ufdblocn, HttpStatus.OK);
	}

	// -------------------Retrieve Single UserTran-----------------------------------------

	@RequestMapping(value = "/usertran/{usrid}/{tranid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserTran>> getUsertran(@PathVariable("usrid") long id,
			@PathVariable("tranid") long tranid) {
		// UserTran user = userTranService.findByUserTran(id, tranid);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		UserTranDaoImpl userDao = (UserTranDaoImpl) context.getBean("userTranDao");

		List<UserTran> userTran = userDao.getByUserTran(id, tranid);
		if (userTran.isEmpty()) {
			return new ResponseEntity<List<UserTran>>(HttpStatus.NO_CONTENT);

		}
		//return new ResponseEntity<UserTran>((UserTran)WebSoapTest.getAuthStampingRequest(), HttpStatus.OK);
		return new ResponseEntity<List<UserTran>>(userTran, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{userid}/{tranid}", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<UserTran>> updateUser(@RequestBody UserTran usertran) throws Exception {
		//System.out.println("Updating User " + id);

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		UserTranDaoImpl userDao = (UserTranDaoImpl) context.getBean("userTranDao");
		UserFeedbackDaoImpl userFeedbackDao = (UserFeedbackDaoImpl) context.getBean("userFeedbackDao");
		
		userFeedbackDao.delFeedbackByUser(usertran.getAccountId(), usertran.getLocnId());
		userFeedbackDao.save(new UserFeedback(usertran.getAccountId(), usertran.getLocnId(), usertran.getMrchName(), usertran.getMrchCatg(), usertran.getMrchAddr(), usertran.getMrchCity(), usertran.getMrchState(), 
				usertran.getMrchState(), usertran.getMrchZip(),
				usertran.getMrchLat(), usertran.getMrchLong()));
		
		UserTran existingTran = userDao.getByUserTran(usertran.getAccountId(), usertran.getTranId()).get(0);
		existingTran.setUserFlag(usertran.getUserFlag());
		userDao.updateUserTran(existingTran);

		//UserTran currentUser = userDao.getByUserTran(usertran.getAccountId(), usertran.getTranId()).get(0);
		 if (usertran==null) { return new
		 ResponseEntity<List<UserTran>>(HttpStatus.NOT_FOUND);
		 }
		 
		return new ResponseEntity<List<UserTran>>(userDao.getByUser(usertran.getAccountId()), HttpStatus.OK);
	}
	

	// -------------------Create a
	// User--------------------------------------------------------

	/*
	 * @RequestMapping(value = "/user/", method = RequestMethod.POST) public
	 * ResponseEntity<Void> createUser(@RequestBody UserTran user,
	 * UriComponentsBuilder ucBuilder) { System.out.println("Creating User " +
	 * user.getName());
	 * 
	 * if (userService.isUserExist(user)) { System.out.println(
	 * "A User with name " + user.getName() + " already exist"); return new
	 * ResponseEntity<Void>(HttpStatus.CONFLICT); }
	 * 
	 * userService.saveUser(user);
	 * 
	 * HttpHeaders headers = new HttpHeaders();
	 * headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.
	 * getId()).toUri()); return new ResponseEntity<Void>(headers,
	 * HttpStatus.CREATED); }
	 */

	// ------------------- Delete a User
	// --------------------------------------------------------

	/*
	 * @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	 * public ResponseEntity<UserTran> deleteUser(@PathVariable("id") long id) {
	 * System.out.println("Fetching & Deleting User with id " + id);
	 * 
	 * UserTran user = userService.findById(id); if (user == null) {
	 * System.out.println("Unable to delete. User with id " + id + " not found"
	 * ); return new ResponseEntity<UserTran>(HttpStatus.NOT_FOUND); }
	 * 
	 * userService.deleteUserById(id); return new
	 * ResponseEntity<UserTran>(HttpStatus.NO_CONTENT); }
	 * 
	 * 
	 * //------------------- Delete All Users
	 * --------------------------------------------------------
	 * 
	 * @RequestMapping(value = "/user/", method = RequestMethod.DELETE) public
	 * ResponseEntity<UserTran> deleteAllUsers() { System.out.println(
	 * "Deleting All Users");
	 * 
	 * userService.deleteAllUsers(); return new
	 * ResponseEntity<UserTran>(HttpStatus.NO_CONTENT); }
	 */
	
	public static void main(String[] args)
	{
		new UserRestController().getUserFeedback();
	}
}
