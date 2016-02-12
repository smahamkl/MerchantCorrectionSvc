package com.org.gmr.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="USERFEEDBACK")
public class UserFeedback implements Serializable
{
	@Id
	private long accountId;
	@Id
	private long locnId;
	private int mrchCatg;
	private String mrchName;
	private String mrchAddr;
	private String mrchCity;
	private String mrchState;
	private String mrchZip;
	private String mrchCtry;
	private double mrchLat;
	private double mrchLong;
	
	public UserFeedback() {
	}

	public UserFeedback(long userId, long locnid, String mrchName, int mrchCatg, String tranAddr1, 
			String tranCity, String tranSt, String tranPstlCd, String tranCtry, double mrchLat,
			double mrchLong) {
		this.accountId = userId;
		this.locnId = locnid;
		this.mrchCatg = mrchCatg;
		this.mrchName = mrchName;
		this.mrchAddr = tranAddr1;
		this.mrchCity = tranCity;
		this.mrchState = tranSt;
		this.mrchZip = tranPstlCd;
		this.mrchCtry=tranCtry;
		this.mrchLat=mrchLat;
		this.mrchLong=mrchLong;

	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getMrchName() {
		return mrchName;
	}

	public void setMrchName(String mrchName) {
		this.mrchName = mrchName;
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

	public long getLocnId() {
		return locnId;
	}

	public void setLocnId(long locnId) {
		this.locnId = locnId;
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
	public int getMrchCatg() {
		return mrchCatg;
	}

	public void setMrchCatg(int mrchCatg) {
		this.mrchCatg = mrchCatg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountId ^ (accountId >>> 32));
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
		UserFeedback other = (UserFeedback) obj;
		if (accountId != other.accountId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[{id:" + accountId + ", merchantName:'" + mrchName +
	            ", location:{mlid:" + locnId + ", merchant_name:'" + mrchName + "', street:'" + mrchAddr + "',city:'" + mrchCity + "',state:'" 
				+ mrchState + "',zip:'" + mrchZip + "',lat:'" + mrchLat + "', long:'" + mrchLong + "'}]";
	}

}
