package com.org.gmr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.org.gmr.model.*;

@Transactional
public class UserFeedbackDaoImpl {

	@PersistenceContext
	private EntityManager em;

	public void save(UserFeedback usrFeedback) {
		em.persist(usrFeedback);
		// person.getTranId();
	}
	
	public List<Object[]> getFeedbackAggregated(long locnId) {
		
		String hql = "select count(p.accountId), p.mrchName, p.mrchCatg, p.mrchAddr, p.mrchCity, p.mrchState, p.mrchZip, p.mrchCtry, p.mrchLat, p.mrchLong from UserFeedback p "
				+ " where p.locnId = " + locnId + " group by p.mrchName, p.mrchCatg, p.mrchAddr, p.mrchCity, p.mrchState, p.mrchZip, p.mrchCtry, p.mrchLat, p.mrchLong";
		
		return em.createQuery(hql).getResultList();
	}
	
	public void delFeedbackByUser(long userid, long locnId) {
		 em.createQuery("DELETE FROM UserFeedback where accountId=" + userid + " and locnId=" + locnId).executeUpdate();
		}
}
