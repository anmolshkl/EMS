package com.ems.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.bean.LoginBean;
import com.ems.dao.LoginDAO;

public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginBean bean=null;
		String secQues=null;
		String secAns=null;
		LoginDAO loginDao=null;
				
		secQues=request.getParameter("secQues");
		secAns=request.getParameter("secAns");

		bean=(LoginBean)request.getSession().getAttribute("user");
		bean.setSecQues(secQues);
		loginDao=new LoginDAO();
		if(secQues != null && secAns!= null) {
			loginDao.updateLoginDets(bean, secAns);
			RequestDispatcher view=request.getRequestDispatcher("NewBank.jsp");
			view.forward(request, response);
		}
	
	}

}
