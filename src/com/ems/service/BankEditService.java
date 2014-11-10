package com.ems.service;

import javax.servlet.http.HttpServletRequest;

import com.ems.bean.BankBean;
import com.ems.bean.LoginBean;


public class BankEditService {
    public BankBean getBank(HttpServletRequest request) {
    	BankBean bank=new BankBean();
    	bank.setEmpId(((LoginBean)request.getSession().getAttribute("user")).getEmpId());
    	bank.setAccNum(Integer.parseInt(request.getParameter("accnum")));
    	bank.setBankName(request.getParameter("bankname"));
    	bank.setBranchName(request.getParameter("branchname"));
    	bank.setIfscCode(request.getParameter("code"));
    	bank.setConfStat(false);
    	return bank;
    }
}
