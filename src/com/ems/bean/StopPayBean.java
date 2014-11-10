package com.ems.bean;

public class StopPayBean {
	private int empId;
	private java.sql.Date fromDate;
	private java.sql.Date toDate;
	private String reason;
	private int wfId;
	private boolean confStat;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public java.sql.Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(java.sql.Date fromDate) {
		this.fromDate = fromDate;
	}
	public java.sql.Date getToDate() {
		return toDate;
	}
	public void setToDate(java.sql.Date toDate) {
		this.toDate = toDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getWfId() {
		return wfId;
	}
	public void setWfId(int wfId) {
		this.wfId = wfId;
	}
	public boolean isConfStat() {
		return confStat;
	}
	public void setConfStat(boolean confStat) {
		this.confStat = confStat;
	}
}
	