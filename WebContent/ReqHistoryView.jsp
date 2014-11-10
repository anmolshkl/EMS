<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.ArrayList,com.ems.bean.WorkflowBean,java.util.Iterator, java.text.DateFormat,java.text.SimpleDateFormat" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
	body {
	text-align:center;
	background: #0ca3d2;
	padding-top: 50px;

	}
	table{
		border: 1px solid black;
		border-collapse:collapse;
		width: 90%;
		margin: 10px auto;
	    box-shadow: 0px 0px 5px 1px #0ff;
		
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<h1>Your Request History</h1>
	<table border="1">
	<tr><td>Workflow Id</td><td>Reason</td><td>Date</td><td>Approver</td><td>Status</td></tr>
		<% ArrayList<WorkflowBean> al=((ArrayList<WorkflowBean>)session.getAttribute("al")); 
		   Iterator<WorkflowBean> itr = al.iterator();
		   WorkflowBean wfBean=null;
		   while(itr.hasNext()) {
			   wfBean=itr.next();
		 %>
		 <tr><td><%= wfBean.getWfId() %></td>
		 <td><%= wfBean.getReason() %></td>
		 <td><% DateFormat df = new SimpleDateFormat("dd/MM/yy");   
				String text = df.format(wfBean.getRDate()); 
				out.println(text); %></td>
		<td><% if(wfBean.getApprover() == 0){ 
					out.println("None");
				} else {
					out.println(wfBean.getApprover());
				} %>
		</td>
		<td><% if(wfBean.isStatus() == true) {
						    out.println("Approved");
						}else 
							out.println("Not Approved"); %>
		</td>
		</tr>
		<% } %> 
		</table>
		
		
		 
		 
	 
	 

</body>
</html>