<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
	<link href="<c:url value="/resources/css/LOG0001.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/common.css" />" rel="stylesheet">
<title>Login</title>

<body>
	<div class="d-flex justify-content-center loginbox">
		<div class="col-sm-4">
		<h2 align="center">Login</h2><br>
			<form:form method="POST" action="login" modelAttribute="emplogin"
				class="form-horizontal">

				<div class="form-group row">
					<form:label path="employee_id" class="col-sm-4 col-form-label">Employee ID (<span>*</span>)</form:label>
					<div class="col-sm-6">
						<form:input path="employee_id"
							class="form-control form-control-sm" />
					</div>
				</div>
				<div class="form-group row">
					<form:label path="Password" class="col-sm-4 col-form-label">Password (<span>*</span>)</form:label>
					<div class="col-sm-6">
						<form:input path="password" class="form-control form-control-sm" type="password"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="button" class="col-sm-4 col-form-label"> </label>
					<div class="col-sm-6" >
						<button type="submit" class="btn btn-secondary btn-sm" id="buttonColor" >Login</button>
						<button type="button" class="btn btn-secondary btn-sm" id="buttonColor">Cancel</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>

	
	<script src="webjars/jquery//jquery.min.js"></script>
	<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>