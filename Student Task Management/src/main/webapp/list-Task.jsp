<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://kit.fontawesome.com/67a11295d7.js" crossorigin="anonymous"></script>
<link href="listTaskStyle.css" rel="stylesheet" type="text/css" >
<title>List Task</title>
</head>
<body>

  <a href="create-Task.jsp" class="split">Add Task</a><br><br>
  
  <table>
  	
  	<tr class="title">
    	<th>TASK NAME</th>
   		<th>DUE DATE</th> 
    	<th>DONE</th>
    	
    	<th colspan="2">Action</th>
  	</tr>
  	<c:forEach items="${tasks}" var="t" varStatus="tasks">
  	<tr>
			<td><c:out value="${t.task_Name}"/></td>
			<td><c:out value="${t.due_Date}"/></td>
			<td><c:out value="${t.task_State}"/></td>
        	
        	<td><a href="UpdateTask?task_ID=<c:out value="${t.task_ID}"/>"><button class="btn"><i class="fa fa-edit"></i></button></a></td>
			<td><a id="<c:out value="${t.task_ID}"/>" onclick ="confirmation(this.id)"><button class="btn"><i class="fa fa-trash"></i></button></a></td>
        	
	</tr>
	</c:forEach>
  
  </table>
  <script>
  function confirmation(task_ID){
	console.log(task_ID);
	var r = confirm("Are you sure want to delete?");
	if (r ==true){
		location.href ='DeleteTask?task_ID=' +task_ID;
		alert("Successfully deleted");
	}else{
		return false;
	}
}
  </script>

</body>
</html>