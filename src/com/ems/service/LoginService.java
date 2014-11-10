package com.ems.service;

import com.ems.bean.LoginBean;
import com.ems.dao.LoginDAO;

public class LoginService {

	public LoginBean checkIfValidUser(int userName, String password) {
		LoginDAO loginDao=new LoginDAO();
		LoginBean user=new LoginBean();
		String accessLevel=null;
		try{
			accessLevel=loginDao.checkIfValidUser(userName,password);
	        if(accessLevel!=null) {
	        	user=loginDao.getLoginDets(userName);
	        }
	        else
	        {
	        	user.setAccessLevel(null);
	        }
		}
		catch(Exception e){

		}	
		return user;
	}
}
