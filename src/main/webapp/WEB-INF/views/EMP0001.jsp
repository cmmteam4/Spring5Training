<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Employee</title>
</head>
<body>

	<div class="container">
		<h2>New Employee</h2>
		<form:form method="POST" action="saveEmp" modelAttribute="employee"
			class="form-horizontal">
			
			<div class="form-group row">
				<form:label path="employee_name" class="col-sm-2 col-form-label">Employee Name</form:label>
				<div class="col-sm-4">
					<form:input path="employee_name" class="form-control" />
				</div>
			</div>

			<div class="form-group row">
				<form:label path="password" class="col-sm-2 col-form-label">Password</form:label>
				<div class="col-sm-4">
					<form:input path="password" class="form-control" />
				</div>
			</div>

			<div class="form-group row">
				<form:label path="dateOfBirth" class="col-sm-2 col-form-label">Date of Birth</form:label>
				<div class="col-sm-4">
					<form:input path="dateOfBirth" class="form-control" />
				</div>
			</div>

			<div class="form-group row">
				<form:label path="age" class="col-sm-2 col-form-label">Age</form:label>
				<div class="col-sm-4">
					<form:input path="age" class="form-control" />
				</div>
			</div>

			<div class="form-group row">
				<form:label path="age" class="col-sm-2 col-form-label">Gender :</form:label>
				<div class="col-sm-4">
					<form:radiobutton path="gender" value="male" />
					Male &nbsp;
					<form:radiobutton path="gender" value="female" />
					Female &nbsp;
					<form:radiobutton path="gender" value="custom" />
					Custom
				</div>
			</div>

			<div class="form-group row">
				<form:label path="note" class="col-sm-2 col-form-label">Notes</form:label>
				<div class="col-sm-4">
					<form:textarea path="note" rows="3" cols="20" class="form-control" />
				</div>
			</div>

			<div class="form-group row">
				<div class="button">
					<input type="submit" value="Save"
						class="btn btn-secondary btn-space"> <input type="button"
						value="Back" class="btn btn-secondary btn-space"> <input
						type="button" value="Clear" class="btn btn-secondary">
				</div>
			</div>
		</form:form>
	</div>
	<script src="<c:url value="/webjars/jquery/3.4.1/jquery.min.js" />"></script>
	<script
		src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js" />"></script>
</body>
</html>