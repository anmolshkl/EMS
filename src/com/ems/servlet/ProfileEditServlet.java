package com.ems.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.ems.bean.LoginBean;
import com.ems.bean.ProfileBean;

import com.ems.dao.ProfileDAO;



 public class ProfileEditServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   ProfileBean profile=null;
		   LoginBean user=null;
		   
		   ProfileDAO profDao=new ProfileDAO();
		
		   user=(LoginBean)(request.getSession().getAttribute("user"));
		   if(user != null) {
			   profile=profDao.getUser(user.getEmpId(),false);
			   System.out.println("Pending Profile="+profile);
			   if(profile != null) {
				   RequestDispatcher view=request.getRequestDispatcher("Pending.jsp");
				   view.forward(request,response);
			   }
			   else { 
				   profile=profDao.getUser(user.getEmpId(),true);
				   request.getSession().setAttribute("profile",profile);
				   RequestDispatcher view=request.getRequestDispatcher("ProfileEdit.jsp");
				   view.forward(request,response);
			   }
		   }
    }
 }