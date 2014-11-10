<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<style type="text/css">
body {
	text-align:center;
	background: #0ca3d2;
}
.leftcell
{
   float: left;
   text-align: right;
   width: 40%;
}
.rightcell
{
   float: left;
   text-align: left;
   padding-left: 5px; /* give some spacing here to fake cell padding */
   width: 50%;
}
form {
	position: relative;
	top: 50px;

}
input[type="text"] {
  width: 70%;
}
input[type="submit"] {
  position:relative;
  margin:2%;
  left:7%;
}
</style>
</head>
<body>
	Welcome Employee!<br>
	Please enter your details to get started.<br>
	<form onsubmit="return validate()" name="quesForm" id="quesForm" method="post" action="NewUserServlet">
		  <div class="leftcell">Please enter a Security Question:</div> <div class="rightcell"><input type="text" name="secQues" id="secQues" /></div><br><br>
		  <div class="leftcell">Please enter an Answer:</div> <div class="rightcell"><input type="text" name="secAns" id="secAns" /></div>
	      <input type="submit" value="SUBMIT" >
	</form>
	<script>
		function validate() {
			var secQues=document.getElementById("secQues");
			var secAns=document.getElementById("secAns");
			var err="";
			if(secQues.value == "") {
				secQues.style.borderColor='red';
				err+="Please enter a security Question.\n";
			}
			if(secAns.value == "") {
				secAns.style.borderColor='red';
				err+="Please enter an Answer.\n";
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