<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
 <%@include file="css.jsp" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
</head>
<body>
 <div class="navbar">
  <a href="/"></i> Student's List</a>
</div>
<div class="container">
	<h1>Register</h1><hr>
		<form:form method="post" modelAttribute="Student">
		<form:input type="hidden" path="id" id="id"/>
		
			<div class="box-body">
			
				<div class="col-md-12">
					<label for="name" id="name">Name</label>
					<div class="form-group">
						<form:input path="name" id="name"/>
						<form:errors path="name" class="has-error" />
					</div>
				</div>
				
				<div class="col-md-12">
					<label  for="email" id="email">Email</label>
					<div class="form-group">
						<form:input path="email" id="email"/>
						<form:errors path="email" class="has-error" />
					</div>
				</div>
				
				<div class="col-md-12">
					<label  for="Contact" id="contact">Contact</label>
					<div class="form-group">
						<form:input path="contact" id="contact"/>
						<form:errors path="email" class="has-error" />
					</div>
				</div>
				
				<div class="col-md-12">
					<label  for="birthdate" id="birthdate">Birth Date</label>
					<div class="form-group">
						<form:input type="text" id="datepicker" path="birthDate" autocomplete="off"/>
					</div>
				</div>
    <button type="submit" class="registerbtn">Register</button>
  </div>
</form:form>
 <script>
 $(document).ready(function() {
	 $('#datepicker').datepicker({
		format : 'dd/mm/yyyy'
	 });
 });
  </script>
 </div>

</body>
</html>