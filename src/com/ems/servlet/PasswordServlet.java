package com.ems.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import com.ems.bean.LoginBean;
import com.ems.dao.PasswordDAO;

 public class PasswordServlet extends HttpServlet {
	 public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
		 String oldPass=null;
		 String newPass=null;
		 String confPass=null;
		 PasswordDAO passDao=null;
		 boolean status=false;
		 int empId=0;
		 oldPass=request.getParameter("oldPass");
		 newPass=request.getParameter("newPass");
		 confPass=request.getParameter("confPass");
		 empId=((LoginBean)request.getSession().getAttribute("user")).getEmpId();
		 System.out.println(oldPass);
		 System.out.println(newPass);
		 System.out.println("empId="+empId);
		 if(newPass.equals(confPass) && empId!=0 && newPass!="" && oldPass!="") {
			 passDao=new PasswordDAO();
			 status=passDao.updatePassword(empId, newPass,oldPass);
			 if(status) {
				 RequestDispatcher view=request.getRequestDispatcher("Success.jsp");
				 view.forward(request,response);
			 }
			 else {
				 RequestDispatcher view=request.getRequestDispatcher("Failure.jsp");
				 view.forward(request,response);
			 }
		 }
		 else {
			 RequestDispatcher view=request.getRequestDispatcher("Failure.jsp");
			 view.forward(request,response);
		 }
	 }
 }