package com.org.gmr.model;

import java.io.Serializable;

public class UserFeedbacks implements Serializable{
	/**
	 * 
	 */
	private int totVotes;
	private String mrchName;
	private int mrchCatg;
	private String mrchAddress;
	private String mrchCity;
	private String mrchState;
	private String mrchZip;
	private String mrchCtry;
	private Double mrchLat;
	private Double mrchLong;
	
	public UserFeedbacks(int totVotes, String mrchName, int mrchCatg, String mrchAddress, String mrchCity, String mrchState, String mrchZip, String mrchCtry, Double mrchLat, Double mrchLong)
	{
		this.totVotes = totVotes;
		this.mrchName = mrchName;
		this.mrchCatg=mrchCatg;
		this.mrchAddress = mrchAddress;
		this.mrchCity = mrchCity;
		this.mrchState = mrchState;
		this.mrchZip = mrchZip;
		this.mrchCtry = mrchCtry;
		this.mrchLat = mrchLat;
		this.mrchLong = mrchLong;
	}

	public int getTotVotes() {
		return totVotes;
	}

	public void setTotVotes(int totVotes) {
		this.totVotes = totVotes;
	}


	public String getMrchName() {
		return mrchName;
	}


	public void setMrchName(String mrchName) {
		this.mrchName = mrchName;
	}
	
	public int getMrchCatg() {
		return mrchCatg;
	}

	public void setMrchCatg(int mrchCatg) {
		this.mrchCatg = mrchCatg;
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

}