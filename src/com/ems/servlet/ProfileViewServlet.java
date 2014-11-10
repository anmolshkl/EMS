package com.ems.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import com.ems.bean.LoginBean;
import com.ems.bean.ProfileBean;
import com.ems.dao.ProfileDAO;

public class ProfileViewServlet extends HttpServlet {
   public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException {
	   ProfileBean profile=null;
	   LoginBean user=null;
	   user=(LoginBean)(request.getSession().getAttribute("user"));
	   ProfileDAO profDAO=new ProfileDAO();
	   profile=profDAO.getUser(user.getEmpId(), true);
	   request.getSession().setAttribute("profile",profile);
	   RequestDispatcher view=request.getRequestDispatcher("ProfileView.jsp");
	   view.forward(request,response);
	   }
}