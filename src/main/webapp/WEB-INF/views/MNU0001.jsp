<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<c:url value="/resources/css/MNU0001.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/common.css" />"
	rel="stylesheet">

<title>MENU</title>

</head>
<body>

	<div class="sidenav">
		<a href="empform">Employee Insert</a><br> <a href="searchform">Employee
			Search </a>
	</div>

	<div class="topnav">
		<a href="#">Logout</a> <a class="list">Employee ID:<br>Employee
			Name:
		</a> <br>
	</div>

	<form:form method="POST" action="saveTime" modelAttribute="menu"
		class="form-horizontal">
		<div class="main">
			<div class="form-group row">
				<div class="col-md-4">

					<div class="form-group row">
						<label for="employee_name">Employee name :</label>
					</div>

					<div class="form-group row">
						<div class="col-sm-5">
							<form:label path="in_time">IN</form:label>
							<form:input path="in_time" class="form-control form-control-sm"
								id="box" value="08:00" disabled="true" />
						</div>

						<div class="col-sm-5">
							<form:label path="out_time">OUT</form:label>
							<form:input path="out_time" class="form-control form-control-sm"
								id="box" value="17:00" disabled="true" />
						</div>
					</div>
				</div>
				<div class="col-md-5">
					<div class="col-md-11">
						<form:label path="out_time_reason">Reason(<span>*</span>)
					</form:label>
						<br>
						<form:textarea class="form-control" path="out_time_reason"
							rows="3" cols="6" />
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group row">
						<div class="col-sm-4">
							<input type="button" value="Excel"
								class="btn btn-secondary btn-md btnexcel" /> <br> <br>
							<input type="submit" value="Submit"
								class="btn btn-secondary btn-md">
						</div>
						<div class="col-sm-8">
							<br> <input type="button" value="Update"
								class="btn btn-secondary btn-md" />
						</div>
					</div>
				</div>
			</div>
			<table class="table table-bordered table-hover">
				<tr align="center" id="TableHead">
					<th>Date</th>
					<th>Day</th>
					<th>In</th>
					<th>Out</th>
					<th>In Remark</th>
					<th>Out Remark</th>
					<th>Action</th>
				</tr>

				<tr align="center" id="TableBody">
					<td width="11%">2019/08/01</td>
					<td width="6%">Thurs</td>
					<td width="10%">07:45</td>
					<td width="10%">17:00</td>
					<td width="25%"></td>
					<td width="25%"></td>
					<td width="9%"><button type="button"
							class="btn btn-secondary btn-sm btn_size2" data-toggle="modal"
							data-target="#myModal">Edit</button> <br>
						<button type="button" class="btn btn-secondary btn-sm btn_size1">Cancel</button></td>
				</tr>
				<tr align="center" id="TableBody">


				</tr>
				<tr align="center" id="SatSun">

				</tr>
			</table>

		</div>
	</form:form>


	<script src="<c:url value="/webjars/jquery/3.4.1/jquery.min.js" />"></script>
	<script
		src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js" />"></script>

</body>
</html>
