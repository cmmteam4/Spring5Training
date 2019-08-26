<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Employee</title>
</head>
<body>
	<div align="center">
		<h2>New Employee</h2>
		<form:form action="save" method="post" modelAttribute="employee">
			<table border="0" cellpadding="5">
				<tr>
					<td>Employee Name:</td>
					<td><form:input path="employee_name" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input path="password" type="password" /></td>
				</tr>
				<tr>
					<td>Date of Birth:</td>
					<td><form:input path="date_of_birth" /></td>
				</tr>
				<tr>
					<td>Age:</td>
					<td><form:input path="age" /></td>
				</tr>
				<tr>
					<td>Gender :</td>
					<td><form:radiobutton path="gender" value="male" />Male 
					    <form:radiobutton path="gender" value="female" />Female
					    <form:radiobutton path="gender" value="custom" />Custom</td>
				</tr>
				<tr>
					<td>Notes:</td>
					<td><form:textarea path="note" rows="3" cols="20" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
					<td colspan="2"><input type="back" value="Back"></td>
					<td colspan="2"><input type="clear" value="Clear"></td>

				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>