package com.ems.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.bean.BankBean;
import com.ems.bean.WorkflowBean;
import com.ems.dao.BankingDAO;
import com.ems.dao.WorkflowDAO;
import com.ems.service.BankEditService;
import com.ems.service.WorkflowService;

public class NewBankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BankEditService service=null;
		BankBean bean=null;
		BankingDAO bankDao=null;
		WorkflowBean wfbean=null;
 		WorkflowService wfService=null;
 		WorkflowDAO wfDao=null;
 		int wfId=-1;
 		
		wfDao=new WorkflowDAO();
		wfService=new WorkflowService();
		wfbean=new WorkflowBean();
 		service=new BankEditService();
		bean=new BankBean();
		bankDao=new BankingDAO();
		
		wfbean=wfService.getWfbean(request);
		wfDao.setWorkflow(wfbean);
		wfId=wfDao.getWfId(wfbean);
		bean=service.getBank(request);
		bankDao.setBankDetails(bean);
		response.sendRedirect("Employee.jsp");
	}

}
