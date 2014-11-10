package com.ems.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.bean.LoginBean;
import com.ems.bean.WorkflowBean;
import com.ems.dao.WorkflowDAO;
import com.ems.bean.LoginBean;

 public class ReqHistoryServ extends javax.servlet.http.HttpServlet  {
	 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		 WorkflowDAO wfdao=null;
		 ArrayList<WorkflowBean> al=null;
		 wfdao=new WorkflowDAO();
		 al= wfdao.getWorkflow(((LoginBean)(request.getSession().getAttribute("user"))).getEmpId());
		 request.getSession().setAttribute("al",al);
		 RequestDispatcher view = request.getRequestDispatcher("ReqHistoryView.jsp");
		    view.forward(request,response);
	 }
	 
 }
  