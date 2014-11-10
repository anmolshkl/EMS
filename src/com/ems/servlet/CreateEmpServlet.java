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
import com.ems.service.ProfEditService;

 public class CreateEmpServlet extends javax.servlet.http.HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ProfEditService service=null;
		 ProfileDAO profDao=null;
		 SalaryDetsDAO sdDao=null;
		 LoginDAO loginDao=null;
		 SalaryDetsBean salBean= null;
		 LoginBean loginBean=null;
		 ProfileBean bean=null;
		 
		 sdDao=new SalaryDetsDAO();
		 loginDao=new LoginDAO();
		 salBean= new SalaryDetsBean();
		 loginBean=new LoginBean();
	     service=new ProfEditService();
		 profDao=new ProfileDAO();
		 bean= new ProfileBean();
		 
		 salBean.setDesig(request.getParameter("desig"));
		 salBean.setEmpId(Integer.parseInt(request.getParameter("empId")));
		 salBean.setSalary(Integer.parseInt(request.getParameter("sal")));
		 System.out.println(request.getParameter("sal")+"=sal");
		 loginBean.setAccessLevel(request.getParameter("accessLevel"));
		 System.out.println("accessLevel="+request.getParameter("accessLevel"));
		 loginBean.setEmpId(Integer.parseInt(request.getParameter("empId")));
		 loginDao.setLoginDets(loginBean);
		 sdDao.setSalaryDetails(salBean);
		 bean= service.getProfile(request);
		 bean.setConfStat(true);
		 profDao.setUser(bean);
		 RequestDispatcher view=request.getRequestDispatcher("EmpCreatedMsg.html");
		  view.forward(request,response);
		 
		 
		 
		 
		 
	}   	  	    
}