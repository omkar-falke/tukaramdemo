<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
 <%@include file="css.jsp" %>
</head>
	<body>
	 <div class="navbar">
 		 <a href="/registration"> Student Registration</a>
	</div>
	<div >
		<table  id="example" class="table table-bordered">
		<tr>
			<th>id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Contact</th>
			<th>Birth Date</th>
			<th></th>
			<th></th>
		</tr>
		 <c:forEach items="${studentList}" var="student">
			<tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.email}</td>
				<td>${student.contact}</td>
				<td><fmt:formatDate pattern="dd-MM-yyyy" value="${student.birthDate}" /></td>
				
				<td> <a href="edit/${student.id}"><button type="button" class="btn btn-success">Edit</button></a></td>
				<td> <a href="delete/${student.id}"><button type="button" class="btn btn-danger">Delete</button></a></td>
			</tr>
		</c:forEach>
		</table>
		</div>
<script>
$(document).ready(function() {
    $('#student').DataTable();
} );
</script>
	</body>
</html>
