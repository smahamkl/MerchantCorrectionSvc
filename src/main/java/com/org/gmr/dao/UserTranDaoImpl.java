package com.org.gmr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.org.gmr.model.*;

@Transactional
public class UserTranDaoImpl {
	@PersistenceContext
	private EntityManager em;

	public void save(UserTran ut) {
		em.persist(ut);
		// person.getTranId();
	}

	public List<UserTran> getByUser(long userid) {
		return em.createQuery("SELECT p FROM UserTran p WHERE p.accountId=" + userid + " and p.userFlag = 'N'", UserTran.class).getResultList();
	}
	
	public List<UserFeedback> getFeedbackByUser(long userid) {
		return em.createQuery("SELECT p FROM UserFeedback p WHERE p.accountId=" + userid, UserFeedback.class).getResultList();
	}
	
	public List<UserTran> getByUserTran(long userid, long tranid) {
		return em.createQuery("SELECT p FROM UserTran p WHERE p.accountId=" + userid + " and p.tranId=" + tranid + " and p.userFlag='N'", UserTran.class).getResultList();
	}
	
	public List<Object[]> getByUserLocn() {
		return em.createQuery("SELECT distinct p.locnId, p.mrchName, p.mrchCatg, p.mrchAddr, p.mrchCity, p.mrchState, p.mrchZip, p.mrchCtry, p.mrchLat, p.mrchLong FROM UserTran p").getResultList();
	}
	
	public void delAllTran() {
	 em.createQuery("DELETE FROM UserTran").executeUpdate();
	}
	
	public void delTranByUser(long userid, long tranid) {
		 em.createQuery("DELETE FROM UserTran where accountId=" + userid + " and tranId=" + tranid).executeUpdate();
		}
	
	public void updateUserTran(UserTran ut) {
		em.merge(ut);
	}

}
