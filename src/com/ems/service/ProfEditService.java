package com.ems.service;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import com.ems.bean.ProfileBean;

public class ProfEditService {
	public ProfileBean getProfile(HttpServletRequest request) {
		ProfileBean profile=new ProfileBean();
		
		profile.setEmpId(Integer.parseInt(request.getParameter("empId")));
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
		Date parsed = null;
		java.sql.Date sql =null;
		profile.setFn(request.getParameter("firstname"));
		profile.setMn(request.getParameter("middlename"));
		profile.setLn(request.getParameter("lastname"));
		profile.setAddr(request.getParameter("addr"));
		try {
		parsed=format.parse(request.getParameter("dob"));
		sql=new java.sql.Date(parsed.getTime());
		profile.setDob(sql);
		profile.setMob(Long.parseLong(request.getParameter("mob")));
		profile.setDept(request.getParameter("dept"));
		profile.setQualf(request.getParameter("qualf"));
		profile.setDesig(request.getParameter("desig"));
		
		parsed=format.parse(request.getParameter("dob"));
		sql=new java.sql.Date(parsed.getTime());
		profile.setDob(sql);
		parsed=format.parse(format.format(new Date()));
		profile.setDoc(new java.sql.Date(parsed.getTime()));
		
		
		profile.setDoj(profile.getDoc());
		profile.setDepName(request.getParameter("depName"));
		profile.setDepRel(request.getParameter("depRel"));
		profile.setContact(Long.parseLong(request.getParameter("contact")));
		profile.setBloodGroup(request.getParameter("bloodGroup"));
		profile.setEmail(request.getParameter("email"));
		profile.setPanNum(Integer.parseInt(request.getParameter("panNum")));
		profile.setLibNum(Integer.parseInt(request.getParameter("libNum")));
		profile.setConfStat(false);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return profile;
	   	}

}
