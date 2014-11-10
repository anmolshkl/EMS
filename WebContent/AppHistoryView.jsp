<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList,com.ems.bean.LoginBean,com.ems.bean.WorkflowBean,java.util.Iterator, java.text.DateFormat,java.text.SimpleDateFormat" %>
    
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
	padding-top: 50px;
	

}
table{
	border: 1px solid black;
	border-collapse:collapse;
	width: 90%;
	margin: 10px auto;
    box-shadow: 0px 0px 5px 1px #0ff;
	
}
tr{
	border: 1px solid black;
	}
tr:nth-child(even) {
	background: #2ECCFA;

}
tr:hover {
	cursor:pointer;
	background: #ADFF2F;
}
</style>
</head>
<body>
		<h1>Approval History:</h1>
		<table>
			<tr><th>Workflow Id</th><th>Requested By</th><th>Reason</th><th>Date</th><th>Approver</th><th>Status</th></tr>
			<% ArrayList<WorkflowBean> arrlist=((ArrayList<WorkflowBean>)session.getAttribute("arrlist")); 
			   Iterator<WorkflowBean> itr = arrlist.iterator();
			   String accessLevel=((LoginBean)session.getAttribute("user")).getAccessLevel();
			   WorkflowBean wfBean=null;
			   while(itr.hasNext()) {
				   wfBean=itr.next();
				  if(accessLevel.equals("2") && wfBean.getReason().equals("profile update") || accessLevel.equals("3") && (wfBean.getReason().equals("bank update")|| wfBean.getReason().equals("stop pay")) || accessLevel.equals("4")) {   
			 %>
		
			 <tr><td><%= wfBean.getWfId() %></td>
				 <td><%= wfBean.getReqId() %></td>		 
				 <td><%= wfBean.getReason() %></td>
				 <td><% DateFormat df = new SimpleDateFormat("dd/MM/yy");   
						String text = df.format(wfBean.getRDate()); 
						out.println(text); %></td>
				<td><% if(wfBean.getApprover() == 0){ 
					out.println("None");
					}else out.println(wfBean.getApprover()); %>
				</td>
				<td><% if(wfBean.isStatus() == true) {
						    out.println("Approved");
						}else 
							out.println("Not Approved"); %>
				</td>
			</tr>
			<% }} %> 	
		</table>
			
<script type="text/javascript">
	var table= document.getElementsByTagName("table")[0];
	
	for(var i=1,row; row=table.rows[i]; i++) {
    	row.onclick = createform;        	
	}
	function createform(e)
	{
    	e = e || window.event;//IE
    	var arr=[];
    	for(j=0;col=this.cells[j];j++) {
    		arr[j]=col.innerText;
    	}
    	var f = document.createElement("form");
		f.setAttribute('method',"post");
		f.setAttribute('action',"ViewUpdateServlet");

		//create input element
		var wfId = document.createElement("input");
		wfId.type = "hidden";
		wfId.name = "wfId";
		wfId.id = "wfId";
		wfId.value= arr[0];
		
		var reqId = document.createElement("input");
		reqId.type = "hidden";
		reqId.name = "reqId";
		reqId.id = "reqId";
		reqId.value= arr[1];
		
		var reason = document.createElement("input");
		reason.type = "hidden";
		reason.name = "reason";
		reason.id = "reason";
		reason.value= arr[2];
		
		var date = document.createElement("input");
		date.type = "hidden";
		date.name = "date";
		date.id = "date";
		date.value= arr[3];
		
		var approver = document.createElement("input");
		approver.type = "hidden";
		approver.name = "approver";
		approver.id = "approver";
		approver.value= arr[4];
		
		var status = document.createElement("input");
		status.type = "hidden";
		status.name = "status";
		status.id = "status";
		status.value= arr[5];
		
		f.appendChild(wfId);
		f.appendChild(reqId);
		f.appendChild(reason);
		f.appendChild(date);
		f.appendChild(status);
		f.appendChild(approver);
		
		document.getElementsByTagName('body')[0].appendChild(f); //pure javascript
		//submit the form
		f.submit();

	}
	
</script>		
</body>
</html>