<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ems.bean.BankBean,com.ems.bean.StopPayBean" %>
<%@ page import="com.ems.bean.ProfileBean,java.text.DateFormat,java.text.SimpleDateFormat" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <script src="JS/selectivizr.js" type="text/javascript"></script>

<title>Insert title here</title>
<style type="text/css">
body {
	text-align:center;
	background: #0ca3d2;
}
table{
	position: relative;
	left:30%;
	border: none;
	width: 50%;
	
}
td {
	margin: 10px;
	padding: 2px;
	text-align: left;
}
#main1 {
	position:relative;
	top: 50px;
	border:1px solid black;
	border-radius: 1em;
	height: 100%;
}
td:nth-child(1) {
	text-align: right;
}
td:nth-child(2) {
	text-align: left;
}
</style>
</head>
<body>
	<div id="main1">
	<%ProfileBean profile=(ProfileBean)request.getAttribute("userProfile");
	 BankBean bank=(BankBean)request.getAttribute("userBank");
	 StopPayBean spbean =(StopPayBean)request.getAttribute("spProfile");
	 System.out.println("ViewEmpUpdates:"+spbean);
	 %>
	 
	<%if(bank != null && bank.isConfStat() != true) { %>
	   <form method="post" >
	   	   <jsp:useBean id="userBank" class="com.ems.bean.BankBean" scope="request"></jsp:useBean>
			<table>		
				<tr><td>Bank Name:</td><td><jsp:getProperty name="userBank" property="bankName" /></td></tr>
				<tr><td>Branch Name:</td><td><jsp:getProperty name="userBank" property="branchName" /></td></tr>
				<tr><td>Account number:</td><td><%=(((BankBean)request.getAttribute("userBank")).getAccNum()) %></td></tr>
				<tr><td>IFSC Code:</td><td><%=(((BankBean)request.getAttribute("userBank")).getIfscCode()) %></td></tr>
				<tr><td><input onclick="javascipt:submitForm(this)" type="submit" name="bankApprove" value="Approve"></td>
					<td><input onclick="javascipt:submitForm(this)" type="submit" name="bankReject" value="Reject"></td>
				</tr>
			</table>
			<input type="hidden" name="wfId" value='<%=request.getParameter("wfId")%>' />
			<input type="hidden" name="reason" value='<%=request.getParameter("reason")%>' />
	   </form>
		<% }%>
		
		<%if(profile != null && profile.isConfStat() != true) {  %>
	   <form method="post" onsubmit="submitForm(this.form)">
	   <jsp:useBean id="userProfile" class="com.ems.bean.ProfileBean" scope="request"></jsp:useBean>
	         <table>
				<tr><td>First Name:</td><td><jsp:getProperty name="userProfile" property="fn" /></td></tr>
				<tr><td>Middle Name:</td><td><jsp:getProperty name="userProfile" property="mn" /></td></tr>
				<tr><td>Last Name:</td><td><jsp:getProperty name="userProfile" property="ln" /></td></tr>
				
				<tr><td>Address:</td><td><jsp:getProperty name="userProfile" property="addr" /></td></tr>
				
				<tr><td>Date of birth:</td><td><%DateFormat df = new SimpleDateFormat("dd/MM/yy");   
												 String text = df.format(userProfile.getDob()); 
												 out.println(text); %></td></tr>
				
				<tr><td>Mobile Number:</td><td><%=userProfile.getMob() %></td></tr>
				
				<tr><td>Department:</td><td><jsp:getProperty name="userProfile" property="dept" /></td></tr>
				
				<tr><td>Qualification:</td><td><jsp:getProperty name="userProfile" property="qualf" /></td></tr>
				<tr><td>Designation:</td><td><jsp:getProperty name="userProfile" property="desig" /></td></tr>
				<tr><td>Date of Joining:</td><td><%df = new SimpleDateFormat("dd/MM/yy");   
				      	text = df.format(userProfile.getDoj()); 
						out.println(text); %></td></tr>
				<tr><td>Dependence Name:</td><td><jsp:getProperty name="userProfile" property="depName" /></td></tr>
				<tr><td>Dependence Relation:</td><td><jsp:getProperty name="userProfile" property="depRel" /></td></tr>
				<tr><td>Contact Number:</td><td><%=userProfile.getContact() %></td></tr>
				<tr><td>Blood Group:</td><td><%=userProfile.getBloodGroup() %></td></tr>
				<tr><td>Email:</td><td><jsp:getProperty name="userProfile" property="email" /></td></tr>
				<tr><td>PAN Number:</td><td><%=userProfile.getPanNum() %></td></tr>
				<tr><td>Library Number:</td><td><%=userProfile.getLibNum() %></td></tr>
				<tr><td><input onclick="javascipt:submitForm(this)" type="submit" name="profileApprove" value="Approve"></td>
					<td><input onclick="javascipt:submitForm(this)" type="submit" name="profileReject" value="Reject"></td>
				</tr>
			</table>
			<input type="hidden" name="wfId" value='<%=request.getParameter("wfId")%>' />
			<input type="hidden" name="reason" value='<%=request.getParameter("reason")%>' />
	   </form>
		<% }%>
		<%if(spbean != null && spbean.isConfStat() != true) { %>
	   <form method="post" onsubmit="submitForm(this.form)">
	   	   <jsp:useBean id="spProfile" class="com.ems.bean.StopPayBean" scope="request"></jsp:useBean>
			<table>		
				<tr><td>Employee ID:</td><td><jsp:getProperty name="spProfile" property="empId" /></td></tr>
				<tr><td>From Date:</td><td><%System.out.println(spbean+" "+spbean.getFromDate());
											DateFormat df = new SimpleDateFormat("dd/MM/yy");   
									      	String text = df.format(spbean.getFromDate()); 
									      	System.out.println(spbean);
											out.println(text); %>
				</td></tr>
				<tr><td>To Date:</td><td><%df = new SimpleDateFormat("dd/MM/yy");   
				      						text = df.format(spbean.getToDate()); 
											out.println(text); %>
				</td></tr>
				<tr><td>Reason:</td><td><jsp:getProperty name="spProfile" property="reason" /></td></tr>
				
				<tr><td><input onclick="javascipt:submitForm(this)" type="submit" name="payApprove" value="Approve"></td>
					<td><input onclick="javascipt:submitForm(this)" type="submit" name="payReject" value="Reject"></td>
				</tr>
			</table>
			<input type="hidden" name="wfId" value='<%=request.getParameter("wfId")%>' />
			<input type="hidden" name="reason" value='<%=request.getParameter("reason")%>' />
	   </form>
		<% }%>
		<%if((profile == null || profile.isConfStat() == true) && (bank == null || bank.isConfStat() == true) &&(spbean == null || spbean.isConfStat() == true)) {
		%>
			This Workflow has already been approved by you!<br>
			<a href="ViewAppServlet">click here to Go Back.</a>
		<%} %>
		
		</div>
<script>

	function submitForm(input) {	
		if(input.name == "bankApprove" || input.name == "profileApprove" || input.name == "payApprove") {
			input.form.setAttribute("action","ApproveServlet");
			input.form.submit();
		}
		if(input.name == "bankReject" || input.name == "profileReject" || input.name == "payReject") {
			input.form.setAttribute("action","RejectServlet");
			input.form.submit();
		}
		
	}
</script>
</body>
</html>