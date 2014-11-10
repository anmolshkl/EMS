<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.ems.bean.ProfileBean,java.text.DateFormat,java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>My Profile</title>
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
	 	text-align: left;s
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
<% ProfileBean prof=(ProfileBean) session.getAttribute("profile");  %>
	<div id="main">
		<h1>Employee Details</h1>	
         <jsp:useBean id="profile" class="com.ems.bean.ProfileBean" scope="session" />
         <table>
			<tr><td>First Name:</td><td><jsp:getProperty name="profile" property="fn" /></td></tr>
			<tr><td>Middle Name:</td><td><jsp:getProperty name="profile" property="mn" /></td></tr>
			<tr><td>Last Name:</td><td><jsp:getProperty name="profile" property="ln" /></td></tr>
			
			<tr><td>Address:</td><td><jsp:getProperty name="profile" property="addr" /></td></tr>
			
			<tr><td>Date of birth:</td><td><%DateFormat df = new SimpleDateFormat("dd/MM/yy");   
			String text = df.format(prof.getDob()); 
				out.println(text); %></td></tr>
			
			<tr><td>Mobile Number:</td><td><%=profile.getMob() %></td></tr>
			
			<tr><td>Department:</td><td><jsp:getProperty name="profile" property="dept" /></td></tr>
			
			<tr><td>Qualification:</td><td><jsp:getProperty name="profile" property="qualf" /></td></tr>
			<tr><td>Designation:</td><td><jsp:getProperty name="profile" property="desig" /></td></tr>
			<tr><td>Date of Joining:</td><td><%df = new SimpleDateFormat("dd/MM/yy");   
			      	text = df.format(prof.getDoj()); 
					out.println(text); %></td></tr>
			<tr><td>Dependence Name:</td><td><jsp:getProperty name="profile" property="depName" /></td></tr>
			<tr><td>Dependence Relation:</td><td><jsp:getProperty name="profile" property="depRel" /></td></tr>
			<tr><td>Contact Number:</td><td><%=profile.getContact() %></td></tr>
			<tr><td>Blood Group:</td><td><%=profile.getBloodGroup() %></td></tr>
			<tr><td>Email:</td><td><jsp:getProperty name="profile" property="email" /></td></tr>
			<tr><td>PAN Number:</td><td><%=profile.getPanNum() %></td></tr>
			<tr><td>Library Number:</td><td><%=profile.getLibNum() %></td></tr>
		</table>
	</div>
	
</body>
</html>