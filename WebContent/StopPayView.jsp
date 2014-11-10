<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.ems.bean.LoginBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<style type="text/css">
body {
	text-align:center;
	background: #0ca3d2;
	padding-top: 50px;
}
table{
	margin: 0 auto;
	}
#label {
	
	text-align: right;
	width: 200px;
}
#inp {
	text-align: left;
	width: 200px;
}
</style>
</head>
<body>
	<h1>Enter Details</h1>
	<form onsubmit="return validate()" action="StopPayServlet" method="post">
		<table>
		<tr><td>Employee ID:</td>
		<td><input type="text" name="blckdId" id="blckdId" /></td></tr>
		<tr><td>From Date:</td>
		<td><input type="text" name="fromDate" id="fromDate" /></td></tr>
		<tr><td>To Date:</td>
		<td><input type="text" name="toDate" id="toDate" /></td></tr>
		<tr><td>Reason:</td>
		<td><input type="text" name="spReason" id="spReason" /></td></tr>	
		<tr><td></td><td><input type="submit" value="SUBMIT"></td></tr>
		</table>
		<input type="hidden" name="reason" id="reason" value="stop pay" />
		<input type="hidden" name="empId" id="empId" value='<%=((LoginBean)session.getAttribute("user")).getEmpId()%>'></input>
	</form>
	<%if(request.getAttribute("error") != null) { %>
		<script>
			var empId=document.getElementById("blckdId");
			empId.value="Invalid Employee ID";
			empId.style.borderColor='red';
		</script>
	<%} %>
<script>
	var blckdId=document.getElementById("blckdId");
	var fromDate=document.getElementById("fromDate");
	var toDate=document.getElementById("toDate");
	var spReason=document.getElementById("spReason");
	function validate() {
		var err="";
		if(blckdId.value == "" || blckdId.value ==undefined){
		err+= "Please enter valid employee ID \n";
		blckdId.style.borderColor='red';
		}
		if(!/^\d{1,2}\/\d{1,2}\/\d{1,2}$/.test(fromDate.value)  || fromDate.value.length!= 8) {
		
        	fromDate.style.borderColor='red';
			err+="Please enter a valid 'From' date in DD/MM/YY format\n";
		}
		if(!/^\d{1,2}\/\d{1,2}\/\d{1,2}$/.test(toDate.value)  || toDate.value.length!= 8) {
		
        	toDate.style.borderColor='red';
			err+="Please enter a valid 'To'date in DD/MM/YY format\n";
		}
		if(spReason.value == "" || spReason.value == undefined ) {
		err+= "Please enter valid Reason \n";
		spReason.style.borderColor='red';
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