package com.org.gmr.model;

import java.util.ArrayList;
import java.util.List;

public class UserFeedbackByLocn {

	private long locnId;
	private String mrchName;
	private int mrchCatg;
	private String mrchAddress;
	private String mrchCity;
	private String mrchState;
	private String mrchZip;
	private String mrchCtry;
	private Double mrchLat;
	private Double mrchLong;
	private List<UserFeedbacks> userFeedbacks;
	
	public UserFeedbackByLocn()
	{
		userFeedbacks = new ArrayList<UserFeedbacks>();
	}

	
	public Long getLocnId() {
		return locnId;
	}

	public void setLocnId(Long locnId) {
		this.locnId = locnId;
	}

	public String getMrchName() {
		return mrchName;
	}

	public void setMrchName(String mrchName) {
		this.mrchName = mrchName;
	}

	public String getMrchAddress() {
		return mrchAddress;
	}

	public void setMrchAddress(String mrchAddress) {
		this.mrchAddress = mrchAddress;
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

	public String getMrchCtry() {
		return mrchCtry;
	}

	public void setMrchCtry(String mrchCtry) {
		this.mrchCtry = mrchCtry;
	}

	public Double getMrchLat() {
		return mrchLat;
	}

	public void setMrchLat(Double mrchLat) {
		this.mrchLat = mrchLat;
	}

	public Double getMrchLong() {
		return mrchLong;
	}

	public void setMrchLong(Double mrchLong) {
		this.mrchLong = mrchLong;
	}

	public List<UserFeedbacks> getUserFeedbacks() {
	
		return userFeedbacks;
	}

	public void setUserFeedbacks(List<UserFeedbacks> userFeedbacks) {
		this.userFeedbacks = userFeedbacks;
	}


	public int getMrchCatg() {
		return mrchCatg;
	}


	public void setMrchCatg(int mrchCatg) {
		this.mrchCatg = mrchCatg;
	}

}
