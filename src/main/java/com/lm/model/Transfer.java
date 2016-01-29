package com.lm.model;

import java.io.Serializable;

public class Transfer implements Serializable {

	private static final long serialVersionUID = -9117215118341225923L;
	private String flowno;
	private String userId;
	private String acc;
	private String revAcc;
	private String amt;
	private String time;
	
	public String getFlowno() {
		return flowno;
	}
	public void setFlowno(String flowno) {
		this.flowno = flowno;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAcc() {
		return acc;
	}
	public void setAcc(String acc) {
		this.acc = acc;
	}
	public String getRevAcc() {
		return revAcc;
	}
	public void setRevAcc(String revAcc) {
		this.revAcc = revAcc;
	}
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
