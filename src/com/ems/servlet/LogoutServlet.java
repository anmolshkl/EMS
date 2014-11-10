package com.ems.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		Cookie[] cookies=request.getCookies();
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("empId")) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		response.sendRedirect("index.jsp");
	}
}