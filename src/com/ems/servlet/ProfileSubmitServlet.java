package com.ems.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.ems.bean.ProfileBean;

import com.ems.bean.WorkflowBean;
import com.ems.dao.ProfileDAO;

import com.ems.dao.WorkflowDAO;
import com.ems.service.ProfEditService;

import com.ems.service.WorkflowService;

public class ProfileSubmitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {
			ProfileBean profile=null;
			ProfileDAO profileDao=null;
			WorkflowBean wfbean=null;
			WorkflowService wfService=null;
			WorkflowDAO wfDao=null;
			int wfId=-1;
			
			profileDao=new ProfileDAO();
			ProfEditService service=new ProfEditService();
			wfService=new WorkflowService();
			wfDao=new WorkflowDAO();
			profile=service.getProfile(request);
			wfbean=wfService.getWfbean(request);
			profile.setEmpId(Integer.parseInt(request.getParameter("empId")));
			
			wfDao.setWorkflow(wfbean);
			wfId=wfDao.getWfId(wfbean);
			profile.setWfId(wfId);
			profileDao.setUser(profile);
		   
		    
		    RequestDispatcher view = request.getRequestDispatcher("UpdateSuccess.html");
		    view.forward(request,response);
		}
	}