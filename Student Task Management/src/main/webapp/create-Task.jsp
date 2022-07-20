<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Task</title>
<script src="https://kit.fontawesome.com/67a11295d7.js" crossorigin="anonymous"></script>
<link href="addTaskStyle.css" rel="stylesheet" type="text/css" >
</head>
<body>
  <a href="ListTaskController" class="split" >List task</a>
<div class="center">
<h1 class="title">Add Task</h1>
	<form action="AddTask" method="post" class="inline">
        <div class="input-icons">
            <i class="fa fa-book icon"></i>
            <input class="input-field" type="text" placeholder="Task Name" name="task_Name">
            <i class="fa fa-calendar icon"></i>
            <input class="input-field" type="date" name="due_Date" >
            <select name="task_State" id="task_State">
            <option value="Not done">Not done</option>
            <option value="In progress">In progress</option>
            </select>
            <br><br>
            <button type="submit" class="btn">Add</button>
        </div>
  </form>
</div>

</body>
</html>