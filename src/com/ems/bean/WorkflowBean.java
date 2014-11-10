package com.ems.bean;

public class WorkflowBean {
	private int wfId;
	private int reqId;

	private boolean status;
	private int approver;
	private java.sql.Date rDate;
	private String reason;
	public int getWfId() {
		return wfId;
	}
	public void setWfId(int wfId) {
		this.wfId = wfId;
	}
	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getApprover() {
		return approver;
	}
	public void setApprover(int approver) {
		this.approver = approver;
	}
	public java.sql.Date getRDate() {
		return rDate;
	}
	public void setRDate(java.sql.Date date) {
		rDate = date;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
	
}
