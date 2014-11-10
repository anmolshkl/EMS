<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.ems.bean.ProfileBean,java.text.DateFormat,java.text.SimpleDateFormat" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Your Profile Details </title>
<style type="text/css">

body {
	text-align:center;
	background: #0ca3d2;

}
table {
	border:none;
	width:80%;
	height:100%; 
	border-spacing:5px;
	margin-left:auto;
	margin-right:auto;
}
#label {
	text-align:right;
}
#inp {
	text-align:left;
}
td {
		padding:5px;
}
input[type="text"] {
	width:50%;
 	border: 1px solid #000000;

}
textarea {
 	border: 1px solid #000000;

}
textarea:focus,input:focus {
	    border:1px solid #00FF00;
	    box-shadow: 0 0 5px rgba(81, 203, 238, 1);
	    
}

</style>

</head>

<body>
<script>

	function trim(s)
	{
  		return s.replace(/^\s+|\s+$/, '');
	} 
	function validate() {
		var email=document.getElementById("email");
		var contact=document.getElementById("contact");
		var mob=document.getElementById("mob");
		var dob=document.getElementById("dob");
	    var tfld = trim(email.value);
		var error="";
	    var emailFilter = /^[^@]+@[^@.]+\.[^@]*\w\w$/ ;
	    
	    if (!emailFilter.test(tfld)) {              //test email for illegal characters
        	
        	email.style.borderColor = 'red';
        	error+= "Please enter a valid email address.\n";
		}
		if(parseInt(contact.value) != parseInt(contact.value)) {
		
			contact.style.borderColor='red';
			error+="Please enter a valid contact Number.";
		}
		if(parseInt(mob.value)!=parseInt(mob.value) && mob.value!=10) {
		
			mob.style.borderColor='red';
			error+="Please enter a valid Mobile Number.\n";
		}
		if(!/^\d{1,2}\/\d{1,2}\/\d{1,2}$/.test(dob.value)  || dob.value.length!= 8) {
		
        	dob.style.borderColor='red';
			error+="Please enter a valid date in DD/MM/YY format\n";
		}
		if(error != "") {
			alert(error);
			return false;
		}	
		return true;
	}
		
</script>
	<div id="profile"><h1>Edit Your Profile</h1><br>
		<% ProfileBean profile=(ProfileBean)session.getAttribute("profile");
			DateFormat df = new SimpleDateFormat("dd/MM/yy");   
			String text = df.format(profile.getDob()); 
     	%>
		<form onsubmit="return validate()" id="profileForm" method="post" action="ProfileSubmitServlet">	
			<input id="empId" name="empId" type="hidden" value='<%=profile.getEmpId()%>' />
			<input id="reason" name="reason" type="hidden" value='profile update' />
			
			<table >
            <tr><td id="label">First Name:</td> <td id="inp"><input id="fn" type="text" name="firstname"  /></td></tr>
			<tr><td id="label">Middle Name:</td> <td id="inp"><input id="mn" type="text" name="middlename"  /><br></td></tr>
			<tr><td id="label">Last Name:</td> <td id="inp"><input id="ln" type="text" name="lastname" /><br></td></tr>
			<tr><td id="label">Address:</td> <td id="inp"><textarea name="addr" rows="3" cols="40%" id="addr" type="text" ></textarea><br></td></tr>
			<tr><td id="label">Date Of Birth:</td> <td id="inp"><input id="dob" type="text" name="dob" /><br></td></tr>
			<tr><td id="label">Mobile Number:</td><td id="inp"><input id="mob" type="text" name="mob" /><br></td></tr>
			<tr><td id="label">Department:</td><td id="inp"><input id="dept" type="text" name="dept" /><br></td></tr>
		    <tr><td id="label">Qualification:</td><td id="inp"><input id="qualf" type="text" name="qualf" /><br></td></tr>
			<tr><td id="label">Designation:</td><td id="inp"><input id="desig" type="text" name="desig" /><br></td></tr>
			<tr><td id="label">Dependence Name:</td> <td id="inp"><input id="depName" type="text" name="depName" /><br></td></tr>
			<tr><td id="label">Dependence Relation:</td> <td id="inp"><input id="depRel" type="text" name="depRel" /><br></td></tr>
			<tr><td id="label">Contact Number:</td> <td id="inp"><input id="contact" type="text" name="contact" /><br></td></tr>
			<tr><td id="label">Email:</td> <td id="inp"><input id="email" type="text" name="email" /><br></td></tr>
			<tr><td id="label">Blood Group:</td> <td id="inp"><input id="bloodGroup" type="text" name="bloodGroup" /><br></td></tr>
			<tr><td id="label">PAN Number:</td> <td id="inp"><input id="panNum" type="text" name="panNum" /><br></td></tr>
			<tr><td id="label">Library Number:</td> <td id="inp"><input id="libNum" type="text" name="libNum" /><br></td></tr>
            </table>
            <input  type="submit" value="UPDATE" > 
</form>
</div>
<script>
	document.getElementById("fn").value='<%=profile.getFn()%>';
	document.getElementById("mn").value='<%=profile.getMn()%>';
	document.getElementById("ln").value='<%=profile.getLn()%>';
	document.getElementById("addr").value='<%=profile.getAddr()%>';
	document.getElementById("dob").value='<%=text%>';
	document.getElementById("bloodGroup").value='<%=profile.getBloodGroup()%>';
	document.getElementById("mob").value='<%=profile.getMob()%>';
	document.getElementById("dept").value='<%=profile.getDept()%>';
	document.getElementById("qualf").value='<%=profile.getQualf()%>';
	document.getElementById("desig").value='<%=profile.getDesig()%>';
	document.getElementById("depName").value='<%=profile.getDepName()%>';
	document.getElementById("depRel").value='<%=profile.getDepRel()%>';
	document.getElementById("contact").value='<%=profile.getContact()%>';
	document.getElementById("email").value='<%=profile.getEmail()%>';
	document.getElementById("panNum").value='<%=profile.getPanNum()%>';
	document.getElementById("libNum").value='<%=profile.getLibNum()%>';
	
	
		
</script>
</body>
</html>