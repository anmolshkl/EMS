package com.ems.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.bean.LoginBean;
import com.ems.dao.BankingDAO;
import com.ems.dao.ProfileDAO;
import com.ems.dao.StopPayDAO;
import com.ems.dao.WorkflowDAO;

public class RejectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WorkflowDAO wfDao=null;
		BankingDAO bankDao=null;
		ProfileDAO profDao=null;
		StopPayDAO spDao=null;
		
		int wfId=Integer.parseInt(request.getParameter("wfId"));
		int empId=((LoginBean)request.getSession().getAttribute("user")).getEmpId();
		String reason=request.getParameter("reason");
		wfDao=new WorkflowDAO();
		if(reason.equals("bank update")){
			bankDao=new BankingDAO();
			wfDao.updateWorkflow(wfId,false,empId);
			bankDao.updateBank(wfId,false);
			
		}
		if(reason.equals("profile update")){
			profDao=new ProfileDAO();
			wfDao.updateWorkflow(wfId,false,empId);
			profDao.updateProfile(wfId,false);
			
		}
		if(reason.equals("stop pay")){
			spDao=new StopPayDAO();
			wfDao.updateWorkflow(wfId, false, empId);
			spDao.updateDetails(wfId, false);
		}
		response.sendRedirect("AppHistoryView.jsp");
	}
}