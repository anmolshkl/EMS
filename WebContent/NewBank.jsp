<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ems.bean.LoginBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	body {
	  background: #0ca3d2;
	  text-align:center;
	 }
	 table{
	 	border:none;
	 	margin: 0 auto;
	 }
</style>
</head>
<body>
<div id="bank">
		<h1>Please enter your Details</h1><br>
		
		<form onsubmit="return validate()" id="BankForm" method="post" action="NewBankServlet">	
			<input type="hidden" name="empId"  id="empId" value='<%=((LoginBean)session.getAttribute("user")).getEmpId() %>' />
			 <input type="hidden" name="reason" value="bank update" id="reason" />
			<table>
				<tr><td>Bank Name:</td><td><input id="bn" type="text" name="bankname"  /></td><tr>
				<tr><td>Branch Name:</td><td><input id="brn" type="text" name="branchname"/></td></tr>
				<tr><td>Account Number:</td><td><input id="an" type="text" name="accnum"/></td></tr>
				<tr><td>IFSC code:</td><td><input id="code" type="text" name="code"/></td></tr>
				<tr><td><input type="submit" value="UPDATE" > </td><td></td></tr>
			</table>
		</form>
</div>
<script>
    function validate() {
    	var bankName=document.getElementById("bankname");
    	var branchName=document.getElementById("branchname");
    	var accNum=document.getElementById("accnum");
    	var code=document.getElementById("code");
    	err="";
    	if(parseInt(accNum.value) != parseInt(accNum.value)) {
    	 	err+="Please enter a valid Account Number.\n";
    	 	accNum.style.borderColor='red';
     	}
    	if(bankName.value == "") {
    	 	err+="Please enter a Bank Name.\n";
    	 	bankName.style.borderColor='red';
     	}
    	if(branchName.value == "") {
    	 	err+="Please enter a Branch Name.\n";
    	 	bankName.style.borderColor='red';
     	}
    	if(code.value == "") {
    	 	err+="Please enter a Code Name.\n";
    	 	bankName.style.borderColor='red';
     	}
    	if(err != "") {
    		alert(err);
    		return false;
    	}
    	return true;
     }
</script>
</body>
</html>