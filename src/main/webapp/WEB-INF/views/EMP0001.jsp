<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/EMP0001.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/common.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>  
<title>New Employee</title>
<script>
	//function and design for password in Edit form 
	document.getElementById("editlink").style.cursor = "pointer";
	function enable() {
		document.getElementById('dark').style.backgroundColor = "white";
		document.getElementById('dark').style.pointerEvents = "auto";
	}

	//Calculate Age and DateOfBirth Pattern
	 function ageCount() {
		var date1 = new Date();
		var DOB = document.getElementById("DOB").value;
		var date2 = new Date(DOB);
		//Regex to validate date format (yyyy/mm/dd)  
		var pattern = /^\d{4}\/\d{1,2}\/\d{1,2}$/; /* /^\d{1,2}\/\d{1,2}\/\d{4}$/ */
		if (pattern.test(DOB)) {
			//getting current year
			var currentYear = date1.getFullYear();
			//alert(" CurrentYear " + date1.getFullYear());
			//getting dob year           
			var dobYear = date2.getFullYear();
			//calculating age         
			var age = currentYear - dobYear;
			document.getElementById("ageCalc").value = age;
			doucment.getElementById("ageCalc").focus();
			return true;
		} else {
			alert("Please insert 'yyyy/mm/dd(1999/01/01)' format!");
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
		<a href="logout">Logout</a> <a> Employee ID: ${auth.employee_id}<br>Employee
			Name: ${auth.employee_name}
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
							id="light" />
					</div>
				</div>
				<%
					} else {
				%>

				<div class="form-group row">
					<form:label path="password" class="col-sm-4 col-form-label">Password (<span>*</span>)</form:label>
					<div class="col-sm-4">
						<form:input showPassword="true" path="password"
							class="form-control form-control-sm" id="dark"/>
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
							class="form-control form-control-sm" placeholder="yyyy/mm/dd"
							onblur="ageCount()" id="DOB" />
					</div>
				</div>

				<div class="form-group row">
					<form:label path="age" class="col-sm-4 col-form-label">Age </form:label>
					<div class="col-sm-4">
					<form:input path="age" class="form-control form-control-sm"
					id="ageCalc" readOnly="true" />
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

						<button type="button" class="btn btn-secondary btn-sm"  onclick="javascript:history.go(-1)">Back</button>
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


