package com.ems.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.bean.LoginBean;
import com.ems.bean.ProfileBean;
import com.ems.bean.SalaryDetsBean;
import com.ems.dao.LoginDAO;
import com.ems.dao.ProfileDAO;
import com.ems.dao.SalaryDetsDAO;

 public class EmpDetsServlet extends javax.servlet.http.HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProfileBean profile=null;
		LoginBean user=null;
		ProfileDAO profDao=null;
		LoginDAO loginDao=null;
		SalaryDetsDAO salDao=null;
		LoginBean loginBean=null;
		SalaryDetsBean salBean=null;
		
		loginDao=new LoginDAO();
		salDao=new SalaryDetsDAO();
		int empId=Integer.parseInt(request.getParameter("empId"));
		user=new LoginBean();
		profDao=new ProfileDAO();
		user.setEmpId(empId);
		profile=profDao.getUser(empId,true);
		if(profile != null) {
			loginBean=loginDao.getLoginDets(empId);
			salBean=salDao.getSalaryDetails(empId);
			System.out.println("Inside EmDetsSevlet="+salBean.getSalary());
			request.setAttribute("loginDets",loginBean);
			request.setAttribute("salDets",salBean);
			request.setAttribute("empDets",profile);
			RequestDispatcher view=request.getRequestDispatcher("EmpDetsView.jsp");
			view.forward(request,response);
		}
		else {
			RequestDispatcher view=request.getRequestDispatcher("EmpNotFound.html");
			view.forward(request,response);
		}
	}
 }