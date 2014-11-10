package com.ems.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.ems.dao.SecQuesDAO;

 public class ForgotPassServlet extends HttpServlet  {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId=0;
		SecQuesDAO sqDAO=null;
		String quest=null;
		empId=Integer.parseInt(request.getParameter("empId"));
		if(empId !=0 ) {
			sqDAO=new SecQuesDAO();
			quest=sqDAO.getQuestion(empId);
			if(quest != null) {
				request.setAttribute("quest",quest);
				RequestDispatcher view=request.getRequestDispatcher("ForgotPass.jsp");
				view.forward(request,response);
			}
			else {
				RequestDispatcher view=request.getRequestDispatcher("EmployeeError.html");
				view.forward(request,response);
			}
		}
		else {
			RequestDispatcher view=request.getRequestDispatcher("EmployeeError.jsp");
			view.forward(request,response);
		}
	}
 }
			