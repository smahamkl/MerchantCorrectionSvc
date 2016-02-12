package com.org.gmr.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.org.gmr.dao.UserFeedbackDaoImpl;
import com.org.gmr.dao.UserTranDaoImpl;
import com.org.gmr.model.UserFeedback;
import com.org.gmr.model.UserFeedbackByLocn;
import com.org.gmr.model.UserTran;

/**
 * App class with main method to test our DAO
 * 
 * @author DevCrumb.com
 */
public class App {

	public static void main(String[] args) throws Exception {

		DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserTranDaoImpl dao = (UserTranDaoImpl) context.getBean("userTranDao");
		UserFeedbackDaoImpl daoFeedback = (UserFeedbackDaoImpl) context.getBean("userFeedbackDao");
		
       
/*		dao.save( new UserTran(10001, 1, 102, "WAL-MART", 1, "2015-12-01", 100.15, "301 RANCH DR", "MILPITAS",
				"CA", "95035", "US", 37.431211,-121.922909, "N"));
		dao.save(new UserTran(10002, 1, 104, "STARBUCKS", 2, "2015-12-02", 10.15, "1066 FOSTER CITY BLVD", "FOSTER CITY",
				"CA", "94404", "US", 37.5535732, -122.3271371, "N"));
		dao.save(new UserTran(10005, 1, 105, "TARGET", 3, "2015-12-03", 20.15, "2220 BRIDGEPOINTE PKWY", "SAN MATEO",
				"CA", "94404", "US", 37.5585988,-122.3532462, "N"));
		dao.save(new UserTran(10012, 1, 101, "SFO PARKING DD", 4, "2015-12-01", 5.00, "", "SAN FRANCISCO",
				"CA", "94128", "US", 37.6289601, -122.3985038, "N"));
		dao.save(new UserTran(10013, 1, 103, "FOREVER21", 5, "2015-12-02", 40.15, "450A GREAT MALL DR", "MILPITAS",
				"CA", "95035", "US", 37.4172793,-121.8972869, "N"));
		dao.save(new UserTran(10003, 1, 107, "L BRANDS", 7, "2015-12-02", 50.15, "1136 STONERIDGE MALL RD", "PLEASANTON",
				"CA", "94588", "US", 37.6951521,-121.9306924, "N"));
		
		dao.save(new UserTran(10014, 2, 104, "STARBUCKS", 2,  "2015-12-03", 10.15, "1066 FOSTER CITY BLVD", "FOSTER CITY",
				"CA", "94404", "US", 37.5535732, -122.3271371, "N"));
		dao.save(new UserTran(10015, 2, 106, "THE SPORTS AUTHORITY", 6, "2015-12-04", 100.15, "1200 GREAT MALL DR", "MILPITAS",
				"CA", "95035", "US", 37.4165888,-121.9034262, "N"));
		dao.save(new UserTran(10016, 2, 108, "SAFEWAY", 3, "2015-12-04", 30.15, "921 E HILLSDALE BLVD", "FOSTER CITY",
				"CA", "94404", "US", 37.5345192,-122.3798301, "N"));*/
		
		
		//dao.updateUserTran(new UserTran(10001, 1, 101, "HomeDepot_NEWLYUPDATED", "2015-11-01", 100.15, "4903 GreatAmerica Mall Dr", "Milpitas",
		//		"CA", "95035", "US", 37.415534, -121.903354, "N"));
				
/*		daoFeedback.save(new UserFeedback(1, 102, "WALMART", 1, "301 RANCH DR", "Milpitas","CA", "95035", "US", 37.431211,-121.922909));
		daoFeedback.save(new UserFeedback(2, 102, "WALMART", 1, "301 RANCH DR", "Milpitas","CA", "95035", "US", 37.431211,-121.922909));
		daoFeedback.save(new UserFeedback(3, 102, "WALMART", 1, "301 RANCH DR", "Milpitas","CA", "95035", "US", 37.431211,-121.922909));
		
		daoFeedback.save(new UserFeedback(1, 104, "STARBUCKS", 2, "1000 METRO CENTER BLVD", "FOSTER CITY","CA", "94404", "US", 37.5608254,-122.2763095));
		daoFeedback.save(new UserFeedback(2, 104, "STARBUCKS", 2, "1000 METRO CENTER BLVD", "FOSTER CITY","CA", "94404", "US", 37.5608254,-122.2763095));
		daoFeedback.save(new UserFeedback(3, 104, "STARBUCKS", 2, "1000 METRO CENTER BLVD", "FOSTER CITY","CA", "94404", "US", 37.5608254,-122.2763095));
		daoFeedback.save(new UserFeedback(4, 104, "STARBUCKS", 2, "1066 FOSTER CITY BLVD", "FOSTER CITY","CA", "94404", "US", 37.553474,-122.2595093));
		
		daoFeedback.save(new UserFeedback(1, 108, "SAFEWAY", 3, "921 E HILLSDALE BLVD", "FOSTER CITY","CA", "94404", "US", 37.5345192,-122.3798301));
		daoFeedback.save(new UserFeedback(2, 108, "SAFEWAY", 3, "921 E HILLSDALE BLVD", "FOSTER CITY","CA", "94404", "US", 37.5345192,-122.3798301));
		daoFeedback.save(new UserFeedback(3, 108, "WESTERNUNION", 10, "921 E HILLSDALE BLVD", "FOSTER CITY","CA", "94404", "US", 37.5345192,-122.3798301));
		daoFeedback.save(new UserFeedback(4, 108, "WESTERNUNION", 10, "921 E HILLSDALE BLVD", "FOSTER CITY","CA", "94404", "US", 37.5345192,-122.3798301));
		
		daoFeedback.save(new UserFeedback(1, 101, "SFO PARKING", 4, "806 S Airport Blvd", "SAN FRANCISCO", "CA", "94128", "US", 37.6367501,-122.4027229));
		daoFeedback.save(new UserFeedback(2, 101, "SFO PARKING", 4, "806 S Airport Blvd", "SAN FRANCISCO", "CA", "94128", "US", 37.6367501,-122.4027229));
		daoFeedback.save(new UserFeedback(3, 101, "SFO PARKING", 4, "806 S Airport Blvd", "SAN FRANCISCO", "CA", "94128", "US", 37.6367501,-122.4027229));
		daoFeedback.save(new UserFeedback(4, 101, "SFO PARKING", 4, "806 S Airport Blvd", "SAN FRANCISCO", "CA", "94128", "US", 37.6367501,-122.4027229));
		daoFeedback.save(new UserFeedback(5, 101, "SFO PARKING", 4, "806 S Airport Blvd", "SAN FRANCISCO", "CA", "94128", "US", 37.6367501,-122.4027229));*/
		
		
		List<Object[]> persons = daoFeedback.getFeedbackAggregated(108);
		for (Object person[] : persons) {
			System.out.println(person[0] + ":" + person[1] + ":" + person[2] + ":" + person[3]);
		}
		/*
		persons = dao.getByUser(2);
		for (UserTran person : persons) {
			System.out.println(person);
		}
		
		List<UserFeedback> personFeedback = dao.getFeedbackByUser(2);
		for (UserFeedback personfb : personFeedback) {
			System.out.println(personfb);
		}*/
		
		
		context.close();
	}
}