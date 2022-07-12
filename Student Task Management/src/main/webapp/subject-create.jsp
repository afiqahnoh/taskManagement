<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<!--UMIE SYAHIRAH BINTI MD SABRI 2/6/2022-->
	<title>Create Subject Page</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="subjectCreate.css">
	<script src="https://kit.fontawesome.com/67a11295d7.js" crossorigin="anonymous"></script>
</head>

<body>
<div class="bar">
<div class="topnav">
		<a href="ListSubjectController" class="split"style="font-size:35px; ">Subject</a>
		<a href="#"><i class="fa fa-user"style="font-size:40px; "></i></a>
		<a href="#" style="padding-right:450px;font-size:35px; ">Student Task Management</a>
</div></div>
<div class = "title-section">
			<h1>Add Subject</h1>
		</div>
		<div class = "details-section">
			<form class="subject" action="AddSubjectController" method="post" name="myForm" onsubmit="return validateForm()">
				<input type="text" name="subject_Code" class="text-box" id="subject code" placeholder="Subject Code">
				<input type="text" name="subject_Name" id="subject name" class="text-box" placeholder="Subject Name">
			<div class = "button-section">
			<button onclick = "">Add</button>
			</div>
			</form>
		</div>
		
</body>
</html>