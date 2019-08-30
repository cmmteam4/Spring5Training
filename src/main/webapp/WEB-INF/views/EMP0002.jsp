<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Employee</title>
</head>
<body>
	<div align="center">
		<h2>Search Employee</h2>
		<form:form method="POST" action="searchEmployee"
			modelAttribute="employeeSearch">
			<table>

				<tr>
					<td><form:label path="employee_name">Employee Name</form:label></td>
					<td><form:input path="employee_name" /></td>
				</tr>

				<tr>
					<td><form:label path="dateOfBirth">Date of Birth</form:label></td>
					<td><form:select path="dateOfBirth">
							<form:option value="NONE" label="--- Year ---" />
							<form:options items="${yearList}" />
						</form:select></td>
					<td><form:select path="dateOfBirth">
							<form:option value="NONE" label="--- Date---" />
							<form:options items="${dayList}" />
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="age">Age</form:label></td>
					<td><form:input path="age" /></td>
				</tr>
				<tr>
					<td><form:label path="gender">Gender</form:label></td>
					<td><form:checkbox path="gender" value="male" />Male<form:checkbox
							path="gender" value="female" />Female<form:checkbox
							path="gender" value="custom" />Custom</td>
				</tr>

				<tr>
					<td><input type="button" value="Search"> <input
						type="button" value="Cancle"> <input type="button"
						value="Delete"> <input type="button" value="Excel">
						<input type="button" value="Report"></td>
				</tr>
			</table>
		</form:form>		
	</div>
</body>
</html>