package com.org.gmr.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERTRAN")
public class UserTran implements Serializable {
	@Id
	private long tranId;
	@Id
	private long accountId;
	private long locnId;
	private String mrchName;
	private String tranDt;
	private double tranAmt;
	private int mrchCatg;
	private String mrchAddr;
	private String mrchCity;
	private String mrchState;
	private String mrchZip;
	private String mrchCtry;
	private double mrchLat;
	private double mrchLong;
	private String userFlag;

	//

	public UserTran() {
	}

	public UserTran(long tranId, long userId, long locnid, String mrchName, int mrchCatg, String tranDt, double tranAmt,
			String tranAddr1, String tranCity, String tranSt, String tranPstlCd, String tranCtry, double mrchLat,
			double mrchLong, String userFlag) {
		this.tranId = tranId;
		this.accountId = userId;
		this.locnId = locnid;
		this.mrchName = mrchName;
		this.tranDt = tranDt;
		this.tranAmt = tranAmt;
		this.mrchCatg = mrchCatg;
		this.mrchAddr = tranAddr1;
		this.mrchCity = tranCity;
		this.mrchState = tranSt;
		this.mrchZip = tranPstlCd;
		this.setMrchCtry(tranCtry);
		this.setMrchLat(mrchLat);
		this.setMrchLong(mrchLong);
		this.setUserFlag(userFlag);

	}

	public long getTranId() {
		return tranId;
	}

	public void setTranId(long tranId) {
		this.tranId = tranId;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	
	public long getLocnId() {
		return locnId;
	}

	public void setLocnId(long locnId) {
		this.locnId = locnId;
	}

	public String getMrchName() {
		return mrchName;
	}

	public void setMrchName(String mrchName) {
		this.mrchName = mrchName;
	}

	public String getTranDt() {
		return tranDt;
	}

	public void setTranDt(String tranDt) {
		this.tranDt = tranDt;
		//
	}

	public double getTranAmt() {
		return tranAmt;
	}

	public void setTranAmt(double tranAmt) {
		this.tranAmt = tranAmt;
	}

	public int getMrchCatg() {
		return mrchCatg;
	}

	public void setMrchCatg(int mrchCatg) {
		this.mrchCatg = mrchCatg;
	}

	public double getMrchLat() {
		return mrchLat;
	}

	public void setMrchLat(double mrchLat) {
		this.mrchLat = mrchLat;
	}

	public double getMrchLong() {
		return mrchLong;
	}

	public void setMrchLong(double mrchLong) {
		this.mrchLong = mrchLong;
	}

	public String getMrchCtry() {
		return mrchCtry;
	}

	public void setMrchCtry(String mrchCtry) {
		this.mrchCtry = mrchCtry;
	}

	public String getMrchAddr() {
		return mrchAddr;
	}

	public void setMrchAddr(String mrchAddr) {
		this.mrchAddr = mrchAddr;
	}

	public String getMrchCity() {
		return mrchCity;
	}

	public void setMrchCity(String mrchCity) {
		this.mrchCity = mrchCity;
	}

	public String getMrchState() {
		return mrchState;
	}

	public void setMrchState(String mrchState) {
		this.mrchState = mrchState;
	}

	public String getMrchZip() {
		return mrchZip;
	}

	public void setMrchZip(String mrchZip) {
		this.mrchZip = mrchZip;
	}

	public String getUserFlag() {
		return userFlag;
	}

	public void setUserFlag(String userFlag) {
		this.userFlag = userFlag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (tranId ^ (tranId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserTran other = (UserTran) obj;
		if (tranId != other.tranId || accountId != other.accountId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[{id:" + accountId + ", name:'" + mrchName + "', amount:" +  tranAmt + ", txn_date:'" + tranDt + "', account_id:" + tranId + ", mrchCatg:" + mrchCatg +
	            ", location:{mlid:" + locnId + ", merchant_name:'" + mrchName + "', street:'" + mrchAddr + "',city:'" + mrchCity + "',state:'" 
				+ mrchState + "',zip:'" + mrchZip + "',lat:'" + mrchLat + "', long:'" + mrchLong + "'}]";
	}
}
