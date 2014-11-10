<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.ems.bean.BankBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
	body {
	  background: #0ca3d2;
	  text-align: center;
	 }
	 table{
	 	border:none;
	 	margin: 0 auto;
	 }
	 td:nth-child(1) {
	 	text-align:left;
	 }
	 td:nth-child(2) {
	 	text-align:left;
	 }
	 </style>
<title>Insert title here</title>
</head>
<body>
<h1>BANK DETAILS</h1>
<table>
	   <jsp:useBean id="bankBean" class="com.ems.bean.BankBean" scope="session" />
	
		<tr><td>Bank Name:</td><td><jsp:getProperty name="bankBean" property="bankName" /></td></tr>
		
		<tr><td>Branch Name:</td><td><jsp:getProperty name="bankBean" property="branchName" /></td></tr>
		
		<tr><td>Account number:</td><td><%=(((BankBean)session.getAttribute("bankBean")).getAccNum()) %></td></tr>
		<tr><td>IFSC Code:</td><td><%=(((BankBean)session.getAttribute("bankBean")).getIfscCode()) %></td></tr>
		
	</table>
		</body>
</html>