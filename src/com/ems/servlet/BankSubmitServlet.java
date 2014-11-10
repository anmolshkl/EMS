package com.ems.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import com.ems.bean.BankBean;
import com.ems.bean.WorkflowBean;
import com.ems.dao.BankingDAO;
import com.ems.dao.WorkflowDAO;
import com.ems.service.BankEditService;
import com.ems.service.WorkflowService;
 public class BankSubmitServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		BankBean bank=null;
 		WorkflowBean wfbean=null;
 		WorkflowService wfService=null;
 		WorkflowDAO wfDao=null;
 		int wfId=-1;
 		
 		wfDao=new WorkflowDAO();
 		wfService=new WorkflowService();
 		BankingDAO bankDao=new BankingDAO();
 		BankEditService service=new BankEditService();
 		
 		wfbean=wfService.getWfbean(request);
 		wfDao.setWorkflow(wfbean);
 		wfId=wfDao.getWfId(wfbean);
 		bank=service.getBank(request);
 		bank.setWfId(wfId);
 		bankDao.setBankDetails(bank);
 		RequestDispatcher view = request.getRequestDispatcher("UpdateSuccess.html");
	    view.forward(request,response);
	}   	  	    
}
