	<!DOCTYPE HTML PUBliC "-//W3C//DTD HTML Frameset 4.01//EN">
<%@ page import="com.ems.bean.ProfileBean" %>
<html>
	<head>
   		<meta http-equiv="Content-Type" content="text/html; charset=Cp1252"/>
   		<title>Welcome Employee!</title>
   		<link rel="stylesheet" type="text/css" href="css/Employee/page.css" />
   		<script src="JS/selectivizr.js" type="text/javascript"></script>
	</head>
<body>
	<div id="header"><br><br>
	Employee Management System
	</div>
	
	<div id='cssmenu'>
		<ul>
			<li class='active'><a target="right" href='ProfileViewServlet'><span>Home</span></a></li>
		   <li ><a href='LogoutServlet'><span>Logout</span></a></li>
		   <li><a href='About.html'><span>About</span></a></li>
		   <li class='last'><a href='Contact.html'><span>Contact</span></a></li>

		</ul>
	</div>
    <% ProfileBean profile=(ProfileBean)session.getAttribute("profile"); %>
	<div id="main">
		<iframe id="left" name="left" src="left-menu.jsp"  width="30%"></iframe>
	    <iframe id="right" name="right" src="ProfileView.jsp"  width="65%"></iframe>
	    
	</div>
	<div id="footer">
            &#169 2014 EMS<a href="Help.html">Help</a>
	</div>




</body>
</html>
