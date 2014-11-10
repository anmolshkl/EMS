package com.ems.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.ems.bean.WorkflowBean;

public class WorkflowService {
	public WorkflowBean getWfbean(HttpServletRequest request) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
		Date parsed = null;
		java.sql.Date sql =null;
		WorkflowBean wfbean= new WorkflowBean();
		wfbean.setReqId((Integer.parseInt(request.getParameter("empId"))));
		wfbean.setStatus(false);
		wfbean.setReason(request.getParameter("reason"));
		try {
			parsed=format.parse(format.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wfbean.setRDate(new java.sql.Date(parsed.getTime()));
		return wfbean;
	}
}
