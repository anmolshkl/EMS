<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "com.ems.bean.BankBean" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
	body {
	  background: #0ca3d2;
	  
	 }
	 table{
	 	border:none;
	 	margin-left:auto;
		margin-right:auto;
	 }
</style>
<title>Edit your Bank Details</title>
</head>
<body>
	<div id="bank">
		<h1 align="center">Please enter your Details</h1><br>
		<% 
		   BankBean bank=(BankBean)session.getAttribute("bankBean"); 
     	%>
     	
		<form onsubmit="return validate()" id="BankForm" method="post" action="BankSubmitServlet">	
		<input type="hidden" name="empId" value='<%=bank.getEmpId() %>' id="empId" />
		 <input type="hidden" name="reason" value="bank update" id="reason" />
		<table>
			<tr><td>Bank Name:</td><td><input id="bn" type="text" name="bankname" 
							value="<%=bank.getBankName()%>" /></td><tr>
			<tr><td>Branch Name:</td><td><input id="brn" type="text" name="branchname" 
							value="<%=bank.getBranchName()%>"/></td></tr>
			 <tr><td>Account Number:</td><td><input id="an" type="text" name="accnum" 
						     value="<%=bank.getAccNum()%>"/></td></tr>
			<tr><td>IFSC code:</td><td><input id="code" type="text" name="code" 
							value="<%=bank.getIfscCode()%>"/></td></tr>
							
			<tr><td></td><td style="text-align:center;"><input type="submit" value="UPDATE" > </td></tr>
			</table>
</form>
</div>
<script>
    function validate() {
    	var accNum=document.getElementById("an");
    	if(parseInt(accNum.value) != parseInt(accNum.value)) {
    	 	alert("Please enter a valid Account Number\n");
    	 	accNum.style.borderColor='red';
    	 	return false;
     	}
     	return true;
     }
</script>

</body>
</html>