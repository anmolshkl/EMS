package com.ems.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.ems.bean.StopPayBean;

public class StopPayService {
	public StopPayBean getStopPayBean(HttpServletRequest request){
		StopPayBean bean= null;
		bean = new StopPayBean();
		bean.setEmpId(Integer.parseInt(request.getParameter("blckdId")));
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
		Date parsed = null;
		java.sql.Date sql =null;
		try {
			parsed=format.parse(request.getParameter("fromDate"));
			sql=new java.sql.Date(parsed.getTime());
			bean.setFromDate(sql);
			parsed=format.parse(request.getParameter("toDate"));
			sql=new java.sql.Date(parsed.getTime());
			bean.setToDate(sql);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		bean.setReason(request.getParameter("spReason"));
		return bean;
	}

}
