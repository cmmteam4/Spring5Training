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
<link href="<c:url value="/resources/css/EMP0001.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/common.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>New Employee</title>
<script>
	//function and design for password in Edit form 
	document.getElementById("editlink").style.cursor = "pointer";
	function enable() {
		document.getElementById('password').style.backgroundColor = "white";
		document.getElementById('password').style.pointerEvents = "auto";
	}
	
	//Calculate Age and DateOfBirth Pattern
	function ageCount() {
		var date1 = new Date();
		var DOB = document.getElementById("DOB").value;
		var date2 = new Date(DOB);
		var pattern = /^\d{4}\/\d{1,2}\/\d{1,2}$/;				/* /^\d{1,2}\/\d{1,2}\/\d{4}$/ */
		 //Regex to validate date format (yyyy/mm/dd)       
		if (pattern.test(DOB)) {
			var y1 = date1.getFullYear();
			//getting current year            
			var y2 = date2.getFullYear();
			//getting dob year            
			var age = y1 - y2;
			//calculating age                       
			document.getElementById("ageId").value = age;
			doucment.getElementById("ageId").focus();
			return true;
		} else {
			alert("Invalid date format. Please Input in (yyyy/mm/dd) format!");
			return false;
		}
	}
</script>

</head>
<body>

	<div class="sidenav">
		<a href="empform">Employee Insert</a><br> <a href="searchform">Employee
			Search </a>
	</div>

	<div class="topnav">
		<a href="#">Logout</a> <a> Employee ID:<br>Employee Name:
		</a> <br>
	</div>

	<div class="d-flex justify-content-center empInsert">
		<div class="col-sm-4">
			<form:form method="POST" action="saveEmp" modelAttribute="employee">
				<form:hidden path="emp_id" />
				<div class="form-group row">
					<form:label path="employee_name" class="col-sm-4 col-form-label">Employee Name</form:label>
					<div class="col-sm-8">
						<form:input path="employee_name"
							class="form-control form-control-sm" />
					</div>
				</div>


				<%
					String pass = request.getParameter("id");
						if (pass == null) {
				%>
				<div class="form-group row">
					<form:label path="password" class="col-sm-4 col-form-label">Password (<span>*</span>)</form:label>
					<div class="col-sm-4">
						<form:input path="password" class="form-control form-control-sm"
							id="disablepassword" />
					</div>
				</div>
				<%
					} else {
				%>

				<div class="form-group row">
					<form:label path="password" class="col-sm-4 col-form-label">Password (<span>*</span>)</form:label>
					<div class="col-sm-4">
						<form:input showPassword="true" path="password"
							class="form-control form-control-sm" id="password" />
					</div>
					<div class="col-sm-2">
						<a id="editlink" onclick="enable()"><u>Edit</u></a>
					</div>
				</div>

				<%
					}
				%>
				<div class="form-group row">
					<form:label path="dateOfBirth" class="col-sm-4 col-form-label">Date Of Birth </form:label>
					<div class="col-sm-4">
						<form:input path="dateOfBirth"
							class="form-control form-control-sm" placeholder="yyyy/mm/dd" />
					</div>
				</div>

				<div class="form-group row">
					<form:label path="age" class="col-sm-4 col-form-label">Age </form:label>
					<div class="col-sm-4">
						<form:input path="age" class="form-control form-control-sm"
							id="box" disabled="true" />
					</div>
				</div>

				<div class="form-group row">
					<form:label path="gender" class="col-sm-4 col-form-label">Gender</form:label>
					<div class="col-sm-8">
						<form:radiobutton path="gender" value="male" />
						Male &nbsp;&nbsp;
						<form:radiobutton path="gender" value="female" />
						Female &nbsp;&nbsp;
						<form:radiobutton path="gender" value="custom" />
						Custom
					</div>
				</div>

				<div class="form-group row">
					<form:label path="note" class="col-sm-4 col-form-label">Note</form:label>
					<div class="col-sm-8">
						<form:textarea path="note" class="form-control form-control-sm"
							rows="5" cols="36" />
					</div>
				</div>

				<div class="form-group row">
					<label for="button" class="col-sm-4 col-form-label"> </label>
					<div class="col-sm-6">
						<button type="submit" class="btn btn-secondary btn-sm">Save</button>
						
						<button type="button" class="btn btn-secondary btn-sm">Back</button>
						<%
							String password1 = request.getParameter("id");
								if (password1 == null) {
						%>
						<button type="reset" class="btn btn-secondary btn-sm">Clear</button>

					</div>
				</div>
				<%
					}
				%>
			</form:form>
		</div>
	</div>



	<script src="<c:url value="/webjars/jquery/3.4.1/jquery.min.js" />"></script>
	<script
		src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js" />"></script>
</body>

</html>


