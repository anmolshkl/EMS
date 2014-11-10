<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<title>Insert title here</title>
</head>
<body>
	<h1>Change Your Password</h1>
  <form onsubmit=" return validate()" id="changePass" name="changePass" action="PasswordServlet" method="post">
  <table>
	<tr><td>Enter your old Password:</td><td><input type="password" id="oldPass" name="oldPass"/></td><tr>
	<tr><td>Enter your new Password:</td><td><input type="password" id="newPass" name="newPass"/></td><tr>
	<tr><td>Confirm your new password:</td><td><input type="password" id="confPass" name="confPass"/></td><tr>
	</table>
    <input type="submit" value="SUBMIT" />
    
  </form>
<script>
var input=document.getElementsByTagName("input");
for(i=0;inp=input[i];i++) {
	inp.addEventListener("blur",function(){
									if(this.value == ""){
										this.style.borderColor="red";
									}else {
										this.style.borderColor="black";
									}
								});
}
    function validate() {
    	var oldPass=document.getElementById("oldPass");
    	var newPass=document.getElementById("newPass");
    	var confPass=document.getElementById("confPass");
    	var error="";
    	if(oldPass.value == "") {
    		error+="Old password field should not be empty\n";
    		oldPass.style.borderColor='red';
    	}
    	if(newPass.value == "") {
    		error+="New password field should not be empty\n";
    		newPass.style.borderColor='red';
    	}
    	if(confPass.value == "") {
    		error+="Confirmation password field should not be empty\n";
    		confPass.style.borderColor='red';
    	}
    	if(newPass.value != confPass.value) {
    		error+="New password doesnt matches confirmation password\n";
    	    newPass.style.borderColor='red';
    		confPass.style.borderColor='red';
    	}
    	if(error!="") {
    		alert(error);
    		return false;
    	}
    	return true;
 }
</script>
</body>
</html>