<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset your Password</title>
<style>
	body {
	  background: #0ca3d2;
	  text-align: center;
	 }
	 form{
	 border: 1px solid white;
	 border-radius: 5px;
	 width:80%;
	 margin-left:auto;
	 margin-right:auto;
	 margin-top: 15%;
	 }
	 table {
	 	border:none;
	 	padding: 2px;
	 	margin: 5px auto;
	 }
	 td{
	 		text-align: right;
	 	}
</style>
</head>
<body>
   <form action="ResetPassServlet" method="post" >
   	 <input type="hidden" name="empId" value='<%= request.getParameter("empId")%>' />
	 <table>
		<tr ><td>Security Question:</td><td style="border-bottom: 1px solid black;text-align:center;"><%=request.getAttribute("quest") %></td></tr>
		<tr><td>Enter your answer:</td><td><input type="text" id="answer" name="answer"/></td></tr>
		<tr><td>Enter your new Password:</td><td><input type="password" id="newPass" name="newPass"/></td></tr>
		<tr><td>Confirm your new password:</td><td><input type="password" id="confPass" name="confPass"/></td></tr>
		<tr><td></td><td style="text-align:center;"><input type="submit" value="SUBMIT"></td></tr>
	 </table>
	</form>
</body>
</html>