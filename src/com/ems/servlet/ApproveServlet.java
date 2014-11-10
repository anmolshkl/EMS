package com.ems.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.BankingDAO;
import com.ems.dao.ProfileDAO;
import com.ems.dao.StopPayDAO;
import com.ems.dao.WorkflowDAO;
import com.ems.bean.LoginBean;
public class ApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WorkflowDAO wfDao=null;
		BankingDAO bankDao=null;
		ProfileDAO profDao=null;
		StopPayDAO spDao=null;
		
		int wfId=Integer.parseInt(request.getParameter("wfId"));
		String reason=request.getParameter("reason");
		int empId=((LoginBean)request.getSession().getAttribute("user")).getEmpId();
		wfDao=new WorkflowDAO();
		if(reason.equals("bank update")){
			bankDao=new BankingDAO();
			wfDao.updateWorkflow(wfId,true,empId);
			bankDao.updateBank(wfId,true);
			
		}
		if(reason.equals("profile update")){
			profDao=new ProfileDAO();
			wfDao.updateWorkflow(wfId,true,empId);
			profDao.updateProfile(wfId,true);
			
		}
		if(reason.equals("stop pay")){
			spDao=new StopPayDAO();
			wfDao.updateWorkflow(wfId, true, empId);
			spDao.updateDetails(wfId, true);
		}
		response.sendRedirect("AppHistoryView.jsp");
	}

}
