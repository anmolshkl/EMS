package com.ems.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import com.ems.bean.BankBean;
import com.ems.bean.LoginBean;
import com.ems.bean.WorkflowBean;
import com.ems.dao.BankingDAO;
import com.ems.dao.WorkflowDAO;
import com.ems.service.WorkflowService;

 public class BankEditServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
	  BankBean bankBean=null;
	  LoginBean user=null;
	  user=(LoginBean)(request.getSession().getAttribute("user"));
	  System.out.println("Inside BankEditServlet user="+user);
	  BankingDAO bankDao=new BankingDAO();
	  bankBean=bankDao.getBankDetails(user,false);
	  System.out.println("Pending bank profile="+bankBean);
	  
	  if(bankBean != null) {
		   RequestDispatcher view=request.getRequestDispatcher("Pending.jsp");
		   view.forward(request,response);
	   }
	  else {
		  bankBean=bankDao.getBankDetails(user,true);
		  request.getSession().setAttribute("bankBean",bankBean);
		  RequestDispatcher view=request.getRequestDispatcher("BankEditView.jsp");
		  view.forward(request,response);
	  }
   }
 }