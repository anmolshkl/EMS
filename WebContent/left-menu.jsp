<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page isELIgnored="false" %>  
<html>
	<head>
   		<meta http-equiv="Content-Type" content="text/html; charset=Cp1252"/>
   		<title>Welcome Employee!</title>
   		<link href="css/Left-Menu/accordionmenu[2].css" rel="stylesheet" type="text/css" />
		<script src="JS/accordionmenu.js" type="text/javascript"></script>
	</head>
<body>
<div id="acdnmenu">
<c:set var="accessLevel" value="${sessionScope.user.accessLevel}" scope="session" />

    <ul>
        <li>My Profile
            <ul>
                <li><a target="right" href="ProfileViewServlet">View Primary Details</a>
                </li>
                <li><a target="right" href="ProfileEditServlet">Edit</a></li>
            </ul>
        </li>
        <li>My Bank Details
            <ul>
                <li><a target="right"  href="BankViewServlet">View</a></li>
                <li><a target="right" href="BankEditServlet">Edit</a></li>
            </ul>
        </li>
        <li><a target="right" href="ReqHistoryServ">View Request History</a></li>
        <li id="li4"><a target ="right" href="ChangePassword.jsp">Change Password</a></li>
        <li id="li6"><a target="right" href="EmpDetsView.html">Get Employee Details</a></li>	 
     	 <c:if test="${accessLevel==2 || accessLevel==4}">
        <li id="li7"><a target="right" href="EmpCreateView.html">Create a new Employee</a></li>
         <li id="li9"><a target="right" href="StopPayView.jsp">Stop Pay</a></li>
        </c:if>
        <c:if test="${accessLevel==2 || accessLevel==3 || accessLevel==4}">
        <li id="li8"><a target="right" href="ViewAppServlet">View Approval History</a></li>
        </c:if>
    </ul>	
</div>

</body>
</html>