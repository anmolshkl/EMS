package com.ems.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.bean.StopPayBean;
import com.ems.bean.WorkflowBean;
import com.ems.dao.LoginDAO;
import com.ems.dao.StopPayDAO;
import com.ems.dao.WorkflowDAO;
import com.ems.service.StopPayService;
import com.ems.service.WorkflowService;


 public class StopPayServlet extends javax.servlet.http.HttpServlet  {
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WorkflowBean wfbean= null;
		WorkflowService wfservice=null;
		WorkflowDAO wfdao=null;
		StopPayBean spbean=null;
		StopPayDAO spdao=null;
		StopPayService spService=null;
		LoginDAO loginDao=null;
		String error=null;
		int wfId;
		
		loginDao=new LoginDAO();
		spService=new StopPayService();
		wfservice = new WorkflowService();
		wfdao= new WorkflowDAO();
		wfbean= wfservice.getWfbean(request);
		spdao= new StopPayDAO();
		spbean = spService.getStopPayBean(request);
		if(loginDao.checkEmployeeId(spbean.getEmpId()) == false) {
			error="Invalid Employee ID";
			request.setAttribute("error", error);
			RequestDispatcher view=request.getRequestDispatcher("StopPayView.jsp");
			view.forward(request,response);
		}
		else {
		wfbean.setStatus(false);
		wfdao.setWorkflow(wfbean);
		wfId=wfdao.getWfId(wfbean);
		spbean.setWfId(wfId);
		spbean.setConfStat(false);
		spdao.setDetails(spbean);
		RequestDispatcher view=request.getRequestDispatcher("ViewAppServlet");
		view.forward(request,response);
		}
	 }
 }
		