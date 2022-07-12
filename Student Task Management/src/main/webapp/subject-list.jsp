<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
	<title>List of Subject Page</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="subjectList.css">
	<script src="https://kit.fontawesome.com/67a11295d7.js" crossorigin="anonymous"></script>
</head>

<body>

<div class="bar">
<div class="topnav">
		<a href="ListSubjectController" class="split"style="font-size:35px; ">Subject</a>
		<a href="#"><i class="fa fa-user"style="font-size:40px; "></i></a>
		<a href="#" style="padding-right:450px;font-size:35px; ">Student Task Management</a>
</div></div>
<div class="content">
	<div class = "title-section"><h1>Subject</h1></div>

	<table style="width:50%">
  	<tr>
  		<th>No</th>
    	<th>Subject Code</th>
    	<th>Subject Name</th>
    	<th colspan="2">Action</th>
  	</tr>
	<c:forEach items="${subjects}" var="s" varStatus="subjects">
	<tr>
		<td><c:out value="${s.subject_Id}"/></td>
		<td><c:out value="${s.subject_Code}"/></td>
		<td><c:out value="${s.subject_Name}"/></td>
		<td><a href="UpdateSubjectController?subject_Id=<c:out value="${s.subject_Id}"/>"><button class="btn"><i class="fa fa-edit"></i></button></a></td>
		<td><a id="<c:out value="${s.subject_Code}"/>" onclick ="confirmation(this.id)"><button class="btn"><i class="fa fa-trash"></i></button></a></td>
	</tr>
	</c:forEach>
	</table>

	<div class = "button-section">
		<a href="subject-create.jsp"><button>Add Subject</button></a>
	</div>
</div>	
<script>
function confirmation(subject_Code){
	console.log(subject_Code);
	var r = confirm("Are you sure want to delete?");
	if (r ==true){
		location.href ='DeleteSubjectController?subject_Code=' +subject_Code;
		alert("Subject successfully deleted");
	}else{
		return false;
	}
}
</script>	
</body>
</html>