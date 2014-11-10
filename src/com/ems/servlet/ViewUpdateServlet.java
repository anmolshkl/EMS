package com.ems.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.bean.BankBean;
import com.ems.bean.LoginBean;
import com.ems.bean.ProfileBean;
import com.ems.bean.StopPayBean;
import com.ems.dao.BankingDAO;
import com.ems.dao.ProfileDAO;
import com.ems.dao.StopPayDAO;

public class ViewUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reason=null;
		BankingDAO bankDao=null;
		ProfileDAO profDao=null;
		StopPayDAO spdao=null;
		StopPayBean spbean= null;
		BankBean bank=null;
		ProfileBean profile=null;
		int wfId=0;
		wfId=Integer.parseInt(request.getParameter("wfId"));
		reason=request.getParameter("reason");
		if(reason.equals("bank update")) {
			bankDao=new BankingDAO();
			bank=bankDao.getBankDetails(wfId);
			request.setAttribute("userBank",bank);

		}
		if(reason.equals("profile update")) {
			profDao=new ProfileDAO();
			profile=profDao.getUser(wfId);
			request.setAttribute("userProfile",profile);
		}
		if(reason.equals("stop pay")) {
			System.out.println("ViewUpdateServlet:inside Stop pay");
			spdao = new StopPayDAO();
			spbean= spdao.getDetsByWfId(wfId);
			System.out.println(wfId);
			request.setAttribute("spProfile",spbean);
			
		}
		RequestDispatcher view3=request.getRequestDispatcher("ViewEmpUpdates.jsp");
		view3.forward(request, response);
	}
}
