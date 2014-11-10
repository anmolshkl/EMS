<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ems.bean.ProfileBean,java.text.DateFormat,java.text.SimpleDateFormat" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<style>
	body {
	  background: #0ca3d2;
	  text-align: center; 
	 }
	 table{
	 	border:none;
	 	margin: 0 auto;
	 }
	 td{
	 	width:200px;
	 	font-size: 120%;
	 	text-align: left;
	 }
	 td:nth-child(1) {
	 	text-align:left;
	 	font-weight: bold;
	 	
	 }
	 td:nth-child(2) {
	 	text-align:left;
	 }
</style>
</head>
<body>
	<div id="main">
	<% ProfileBean prof=(ProfileBean) request.getAttribute("empDets");  %>
		<h1>Employee Details</h1>	
         <jsp:useBean id="empDets" class="com.ems.bean.ProfileBean" scope="request" />
         <jsp:useBean id="salDets" class="com.ems.bean.SalaryDetsBean" scope="request" />
         <jsp:useBean id="loginDets" class="com.ems.bean.LoginBean" scope="request" />
         
         <table>
         	<tr><td style="text-align:left;">Employee ID:</td><td><jsp:getProperty name="empDets" property="empId" /></td></tr>
          <tr><td style="text-align:left;">Access Level:</td><td><jsp:getProperty name="loginDets" property="accessLevel" /></td></tr>
			<tr><td style="text-align:left;">First Name:</td><td><jsp:getProperty name="empDets" property="fn" /></td></tr>
			<tr><td style="text-align:left;">Middle Name:</td><td><jsp:getProperty name="empDets" property="mn" /></td></tr>
			<tr><td style="text-align:left;">Last Name:</td><td><jsp:getProperty name="empDets" property="ln" /></td></tr>
			
			<tr><td style="text-align:left;">Address:</td><td><jsp:getProperty name="empDets" property="addr" /></td></tr>
			
			<tr><td style="text-align:left;">Date of birth:</td><td><%DateFormat df = new SimpleDateFormat("dd/MM/yy");   
			String text = df.format(prof.getDob()); 
				out.println(text); %></td></tr>
			
			<tr><td style="text-align:left;">Mobile Number:</td><td><%=prof.getMob() %></td></tr>
			
			<tr><td style="text-align:left;">Department:</td><td><jsp:getProperty name="empDets" property="dept" /></td></tr>
			
			<tr><td style="text-align:left;">Qualification:</td><td><jsp:getProperty name="empDets" property="qualf" /></td></tr>
			<tr><td style="text-align:left;">Designation:</td><td><jsp:getProperty name="empDets" property="desig" /></td></tr>
			<tr><td style="text-align:left;">Salary:</td><td><%=salDets.getSalary() %></td></tr>
			<tr><td style="text-align:left;">Date of Joining:</td><td><%df = new SimpleDateFormat("dd/MM/yy");   
			      	text = df.format(prof.getDoj()); 
					out.println(text); %></td></tr>
			<tr><td style="text-align:left;">Dependence Name:</td><td><jsp:getProperty name="empDets" property="depName" /></td></tr>
			<tr><td style="text-align:left;">Dependence Relation:</td><td><jsp:getProperty name="empDets" property="depRel" /></td></tr>
			<tr><td style="text-align:left;">Contact Number:</td><td><%=prof.getContact() %></td></tr>
			<tr><td style="text-align:left;">Blood Group:</td><td><%=prof.getBloodGroup() %></td></tr>
			<tr><td style="text-align:left;">Email:</td><td><jsp:getProperty name="empDets" property="email" /></td></tr>
			<tr><td style="text-align:left;">PAN Number:</td><td><%=prof.getPanNum() %></td></tr>
			<tr><td style="text-align:left;">Library Number:</td><td><%=prof.getLibNum() %></td></tr>
		</table>
	</div>
</body>
</html>