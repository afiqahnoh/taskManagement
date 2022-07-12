<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Subject Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://kit.fontawesome.com/67a11295d7.js" crossorigin="anonymous"></script>
    <link href="subjectUpdate.css" rel="stylesheet" type="text/css" /> 
</head>
<body>
<div class="bar">
<div class="topnav">
		<a href="ListSubjectController" class="split"style="font-size:35px; ">Subject</a>
		<a href="#"><i class="fa fa-user"style="font-size:40px; "></i></a>
		<a href="#" style="padding-right:450px;font-size:35px; ">Student Task Management</a>
</div></div>
<div class="main">
<h1 style="text-align: center;">Update Subject</h1>
    <form class="inline" action="UpdateSubjectController" method= "post">
        <input type="hidden" name="subject_Id" value="<c:out value="${s.subject_Id}"/>"/>
        <div class="input-icons">
            <i class="fa fa-book-open icon"></i>
            <input class="input-field" type="text" name="subject_Code"value="<c:out value="${s.subject_Code}"/>"/>
            <br><br>
            <i class="fa fa-book-open icon"></i>
            <input class="input-field" type="text"  name="subject_Name"value="<c:out value="${s.subject_Name}"/>"/>
        </div>
        
        
        <input class="updButton" type="submit" value="Update">
    </form>
</div>    
</body>
</html>


