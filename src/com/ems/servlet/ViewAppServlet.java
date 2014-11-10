package com.ems.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.bean.LoginBean;
import com.ems.bean.WorkflowBean;
import com.ems.dao.WorkflowDAO;

 public class ViewAppServlet extends javax.servlet.http.HttpServlet {
   
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 WorkflowDAO wfdao=null;
		 ArrayList<WorkflowBean> arrlist=null;
		 wfdao=new WorkflowDAO();
		 arrlist= wfdao.getAllWorkflow();
		 request.getSession().setAttribute("arrlist",arrlist);
		 RequestDispatcher view = request.getRequestDispatcher("AppHistoryView.jsp");
		 view.forward(request,response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 WorkflowDAO wfdao=null;
		 ArrayList<WorkflowBean> arrlist=null;
		 wfdao=new WorkflowDAO();
		 arrlist= wfdao.getAllWorkflow();
		 request.getSession().setAttribute("arrlist",arrlist);
		 RequestDispatcher view = request.getRequestDispatcher("AppHistoryView.jsp");
		 view.forward(request,response);
	}
}