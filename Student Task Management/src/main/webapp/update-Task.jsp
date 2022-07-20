<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Task</title>
<script src="https://kit.fontawesome.com/67a11295d7.js" crossorigin="anonymous"></script>
<link href="addTaskStyle.css" rel="stylesheet" type="text/css" >
</head>
<body>
<div class="center">
<h1 class="title">Update Task</h1>
<form action="UpdateTaskController" method="post" >

<div class="input-icons">
            <i class="fa fa-book icon"></i>
            <input class="input-field" type="text" name="task_Name" value="<c:out value="${t.task_Name}"/>">
            <i class="fa fa-calendar icon"></i>
            <input class="input-field" type="date" name="due_Date"  value="<c:out value="${t.due_Date}"/>">
             <select id="task_State" name="task_State">
       		 <option value="<c:out value="${t.task_State}"/>"><c:out value="${t.task_State}"/></option>
         	<option value="Done">Done</option>
			<option value="Not done">Not done</option>
        	</select>
             <input type="hidden" name="task_ID" value="<c:out value="${t.task_ID}"/>"/>
  <br>
            <br><br>
            <button type="submit" class="btn">Update</button>
  </div>

</form>


</body>
</html>