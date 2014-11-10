package com.ems.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.PasswordDAO;
import com.ems.dao.SecQuesDAO;

 public class ResetPassServlet extends javax.servlet.http.HttpServlet  {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String answ=null;
        String newPass=null;
        String confPass=null;
        boolean result=false;
        PasswordDAO passDao=null;
        int empId=Integer.parseInt(request.getParameter("empId"));
        answ=request.getParameter("answer");
        newPass=request.getParameter("newPass");
        confPass=request.getParameter("confPass");
        System.out.println("answ="+answ);
        System.out.println("newPass="+newPass);
        System.out.println("confPass="+confPass);
        System.out.println("empId="+empId);
        if( newPass.equals(confPass) && newPass != null && answ != null) {
	        SecQuesDAO sqDao=new SecQuesDAO();
	        result=sqDao.checkAnswer(empId,answ);
	        System.out.println(result);
	        if(result !=false) {
	        	passDao=new PasswordDAO();
	        	passDao.updatePassword(empId, newPass);
	        	RequestDispatcher view=request.getRequestDispatcher("Success.jsp");
	        	view.forward(request,response);
	        }
	        else {
	        	RequestDispatcher view=request.getRequestDispatcher("Failure.jsp");
	        	view.forward(request,response);
	        }
        }
        else
        {
        	RequestDispatcher view=request.getRequestDispatcher("Failure.jsp");
        	view.forward(request,response);
        }
   }
}