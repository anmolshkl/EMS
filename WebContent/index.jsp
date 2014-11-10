<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <meta http-equiv="content-type" content="text/html; charset=utf-8">
        <title>Test Page</title>
 		<link rel="stylesheet" type="text/css" href="css/Index/form.css" />
 		<link rel="stylesheet" type="text/css" href="css/Index/style.css" />
    </head>	
    <body>
	  <%String error=null;
	  	Cookie[] cookies=null;
		if(request.getAttribute("error") != null) {
			error=(String)request.getAttribute("error");
		}
	    boolean cookieFound=false;
	  %>
		<%
		cookies=request.getCookies();
		if(cookies != null){
		for(int i=0;i<cookies.length;i++) {
			if(cookies[i].getName().equals("empId")) {
				cookieFound=true;
			}
		}}
		%>
		
    	<div id="main">
    		<div class="container">
		    <div class="login">
		      <h1>Employee Login</h1>
		      <form method="post" onsubmit="return validate()" action="LoginServlet">
		        <%if(error != null){ out.println(error);} 
		         %>
		        <p><input type="text" name="empId" id="empId"></p>
		        <p><input type="password" name="password" id="password"></p>
		        <p class="remember_me">
		          <label>
		            <input type="checkbox" name="remember_me" id="remember_me">
		            Remember me on this computer
		          </label>
		        </p>
		        <p class="submit"><input type="submit" name="commit" value="Login"></p>
		      </form>
		    </div>

		    <div class="login-help">
		      <p>Forgot your password? <a href="EmployeeID.html">Click here to reset it</a>.</p>
		    </div>
		  </div>
    	</div>
    	<div id="footer">
    		<br>
            &#169 2014 EMS<a href="Help.html">Help</a>
    	</div>
    </body>
    <%if(cookieFound){%>
			<script>
				document.getElementsByTagName("form")[0].submit();
			</script>
		<%} %>
<script>
var id = document.getElementById("empId");
var pass= document.getElementById("password");
 function validate(form) {
 	var form= document.getElementsByTagName("form")[0];
 	var err="";
 	var reg =/^\d+$/;
 	if(reg.test(id.value) == false) {
 		err+="Employee ID can only be numeric.\n";
 		id.style.borderColor="red";
 	}
 	if(id.value == "" || id.value == undefined) {
 		err+="Please enter your employee ID. \n";
 		id.style.borderColor="red";
 		}
 		if(pass.value == "" || pass.value == undefined) {
 			err+="Please enter a valid password.\n";
 			pass.style.borderColor="red";
 		}
 		if(err!=""){
	 		alert(err);
	 		return false;
 	}
 	form.submit();
 }
 </script>		

</html>