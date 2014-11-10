package com.ems.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import com.ems.bean.BankBean;
import com.ems.bean.LoginBean;
import com.ems.dao.BankingDAO;

 public class BankViewServlet extends HttpServlet {
	 public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
		 BankingDAO bankDao=null;
		 BankBean bankBean=null;
		 System.out.println("inside bank servlet");
		 bankDao=new BankingDAO();
		 bankBean=bankDao.getBankDetails((LoginBean)(request.getSession().getAttribute("user")),true);
		 request.getSession().setAttribute("bankBean",bankBean);
		 RequestDispatcher view=request.getRequestDispatcher("BankView.jsp");
		 view.forward(request,response);
	 }
}