package com.ems.servlet;

import java.io.IOException;

import javax.servlet.http.*;
import javax.servlet.*;

import com.ems.bean.LoginBean;
import com.ems.bean.ProfileBean;
import com.ems.dao.LoginDAO;
import com.ems.dao.ProfileDAO;
import com.ems.service.LoginService;
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException {
		LoginDAO loginDao=null;
		LoginBean user=null;
		ProfileBean profile=null;
		String error=null;
		String rememberMe=null;
		String password=null;
		int empId=0;
		boolean cookieFound=false;
		ProfileDAO profDAO=new ProfileDAO();
		if(!request.getParameter("empId").equals("")) {
			empId=Integer.parseInt(request.getParameter("empId"));
		}
		password=request.getParameter("password");
		rememberMe=request.getParameter("remember_me");
		HttpSession session=request.getSession();
		Cookie[] cookies=request.getCookies();
		Cookie cookie=null;
		for(int i=0;i<cookies.length;i++) {
			if(cookies[i].getName().equals("empId")) {
				cookieFound=true;
				cookie=cookies[i];
				break;
			}
		}
		if((0 != empId && null != password)) {
			LoginService service=new LoginService();
			user=service.checkIfValidUser(empId, password);
			if(user.getAccessLevel() != null) {
				//user's credentials are right
				if(rememberMe != null && rememberMe.equals("on")) {
					Cookie c = new Cookie("empId",empId+"");
					c.setMaxAge(5* 24 * 60 * 60); //Valid till 5 days
					response.addCookie(c);
				}
				profile=profDAO.getUser(empId,true);
				request.getSession().setAttribute("profile",profile);
				request.getSession().setAttribute("user",user);
				if(user.getSecQues().equals("none")) { //We have a new user
					RequestDispatcher view=request.getRequestDispatcher("NewUser.jsp");
					view.forward(request,response);
				}
				else {
					//User is already registered
					RequestDispatcher view=request.getRequestDispatcher("Employee.jsp");
					view.forward(request,response);	
			
				}
			}
			else {
				error="Please enter a valid Password/email";
				request.setAttribute("error",error);
				RequestDispatcher view=request.getRequestDispatcher("index.jsp");
				view.forward(request,response);	
			}
		}else if(cookieFound) {
				loginDao=new LoginDAO();
				empId=Integer.parseInt(cookie.getValue());
				profile=profDAO.getUser(empId,true);
				user=loginDao.getLoginDets(empId);
				request.getSession().setAttribute("profile",profile);
				request.getSession().setAttribute("user",user);
				RequestDispatcher view=request.getRequestDispatcher("Employee.jsp");
				view.forward(request,response);	
		}
		else{
			error="Please enter a valid Password/email";
			request.setAttribute("error",error);
			RequestDispatcher view=request.getRequestDispatcher("index.jsp");
			view.forward(request,response);	
		}
		
	}
}