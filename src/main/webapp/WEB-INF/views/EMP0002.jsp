<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<c:url value="/resources/css/EMP0002.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/common.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="<c:url value="/webjars/jquery/3.4.1/jquery.min.js" />"></script>
<script
	src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js" />"></script>
<title>New Employee</title>
<script>
	$(document).ready(function() {
		if ($(this).is(':checked', true)) {
			$(".chkId").prop('checked', true);
		} else {
			$(".chkId").prop('checked', false);
		}

	});

	function year() {
		Calendar
		calendar = Calendar.getInstance();

	}
</script>
</head>
<body>
	<div class="sidenav">
		<a href="empform">Employee Insert</a><br> <a href="searchform">Employee
			Search </a>
	</div>

	<div class="topnav">
		<a href="logout">Logout</a> <a>Employee ID:${auth.employee_id}<br>Employee Name:${auth.employee_name}
		</a> <br>
	</div>


	<div class="empSearch">
		<div class="col-sm-6">
			<form:form method="POST" action="searchEmp"
				modelAttribute="employeeSearch">
				<div class="form-group row">
					<form:label path="employee_name" class="col-sm-5 col-form-label">Employee Name</form:label>
					<div class="col-sm-7">
						<form:input path="employee_name"
							class="form-control form-control-sm" />
					</div>
				</div>



				<div class="form-group row">
					<form:label path="dateOfBirth" class="col-sm-5 col-form-label">Date Of
						Birth</form:label>

					<div class="col-sm-3">
					<%@ page import="java.util.Calendar"%>
						<form:select class="form-control form-control-sm"
							path="dateOfBirth" name="year">
							<option value="0">Year</option>
							<%
							int curr_year = Calendar.getInstance().get(Calendar.YEAR);
								for (int year = 1970; year <= curr_year; year++){
							%>
							<option><%= year %></option>
							
							<%
								}							
							%>
						</form:select>
					</div>
					<div class="col-sm-2">
						<form:select class="form-control form-control-sm"
							path="dateOfBirth">
							<option value="0">Month</option>
							<%							
								for (int month = 1; month <= 12; month++){
							%>
							<option><%= month %></option>
							<%
								}							
							%>
						</form:select>
					</div>
				</div>

				<div class="form-group row">
					<form:label path="age" class="col-sm-5 col-form-label">Age</form:label>
					<div class="col-sm-4">
						<form:input path="age" class="form-control form-control-sm" />
					</div>
				</div>

				<div class="form-group row">
					<form:label path="gender" class="col-sm-5 col-form-label">Gender</form:label>
					<div class="col-sm-7">
						<form:checkbox path="gender" value="male" />
						Male &nbsp;&nbsp;
						<form:checkbox path="gender" value="female" />
						Female &nbsp;&nbsp;
						<form:checkbox path="gender" value="custom" />
						Custom&nbsp;&nbsp;
					</div>
				</div>

				<div class="form-group row" style="position: absolute; left: 202px;">
					<label for="button" class="col-sm-5 col-form-label"> </label>
					<div class="col-sm-7">
						<button type="submit" class="btn btn-secondary btn-sm">Search</button>
					</div>
				</div>
			</form:form>

			<!-- Delete Employee Form -->
			<form:form method="POST" action="deleteEmp"
				modelAttribute="employeeDelete">
				<div class="form-group row">
					<label for="button" class="col-sm-5 col-form-label"> </label>
					<div class="col-sm-7"
						style="position: relative; left: 80px; padding: 0;">
						<button type="button" class="btn btn-secondary btn-sm">Cancel</button>
						<button type="submit" class="btn btn-secondary btn-sm">Delete</button>
						<button type="button" class="btn btn-secondary btn-sm">Excel</button>
					</div>
				</div>

				<!-- EmployeeListTable -->
				<div class="form-group row">
					<div class="col-sm-16">
						<div class="table-wrapper-scroll-y my-custom-scrollbar">
							<table class="table table-bordered table-hover table-striped"
								class="table table-bordered table-striped mb-0">
								<tr style="background-color: #EAFAF1; height: 10px;"
									align="center">
									<th>No</th>
									<th>Check</th>
									<th>Edit</th>
									<th>EmployeeID</th>
									<th>EmployeeName</th>
									<th>DateOfBirth</th>
									<th>Age</th>
									<th>Gender</th>
									<th>Note</th>
									<!--  <th>Delete</th>-->

								</tr>
								<c:forEach var="emplist" items="${ListEmp}"
									varStatus="loopCounter">
									<tr align="center">
										<td width="6%"><c:out value="${loopCounter.count}" /></td>
										<td width="6%"><input type="checkbox" class="chkId"
											value="${emplist.emp_id}" name="emp_id"></td>
										<td><a href="editEmployee?id=${emplist.emp_id}"><u>Edit</u></a></td>
										<td>${emplist.employee_id}</td>
										<td>${emplist.employee_name}</td>
										<td>${emplist.dateOfBirth}</td>
										<td>${emplist.age}</td>
										<td>${emplist.gender}</td>
										<td id="notewidth" align="left">${emplist.note}</td>
										
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</form:form>
			
			
			<!-- Display employee list -->
			<div class="d-flex justify-content-center mb-3">
				<c:if test="${!empty search_list}">
					<table class="table table-sm">
						<c:forEach var="sd" items="${search_list}">
							<tr>
								<td align="center">${sd.employee_id}</td>
								<td align="center">${sd.employee_name}</td>
								<td align="center">${sd.dateOfBirth}</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
				<c:if test="${empty search_list}">
					<h4>Not match data is found!.</h4>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>