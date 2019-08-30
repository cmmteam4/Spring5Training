<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<head>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	font-family: "Lato", sans-serif;
}

.sidenav {
	height: 100%;
	width: 250px;
	position: fixed;
	z-index: 1;
	top: 55;
	left: 0;
	background-color: #EAFAF1;
	overflow-x: hidden;
	padding-top: 20px;
}

.sidenav a {
	padding: 6px 8px 6px 16px;
	text-decoration: none;
	font-size: 25px;
	color: #818181;
	display: block;
}

.sidenav a:hover {
	color: blue;
}

.main {
	margin-left: 250px; /* Same as the width of the sidenav */
	font-size: 28px; /* Increased text to enable scrolling */
	padding: 0px 10px;
}

@media screen and (max-height: 450px) {
	.sidenav {
		padding-top: 15px;
	}
	.sidenav a {
		font-size: 18px;
	}
}
</style>
</head>
<div class="sidenav">
	<a href="empform">Employee Insert</a><br>
	<a href="searchform">Employee Search </a>>
</div>


<nav class="navbar navbar-expand-sm bg-light">
	<ul class="navbar-nav">
		<li class="nav-secondary"><a class="nav-link" href="#">Employee
				ID</a></li>
		<li class="nav-secondary"><a class="nav-link" href="#">Employee
				Name</a></li>

	</ul>
</nav>

<div class="main">
	<a href="empform">Add Employee</a>
	<div class="d-flex justify-content-center">
		<div class="col-md-4 col-md-offset-3">

			<div class="form-group has-feedback">
				<label for="employee_name">Employee Name:</label>
			</div>


			<div class="form-group has-feedback">
				<label for="employee_name">In:</label> <input type="text"
					class="form-control">
			</div>
			<div class="form-group has-feedback">
				<label for="employee_name">Out:</label> <input type="text"
					class="form-control">
			</div>
		</div>
	</div>



	<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th scope="col">Date</th>
				<th scope="col">Day</th>
				<th scope="col">In</th>
				<th scope="col">Out</th>
				<th scope="col">In Remark</th>
				<th scope="col">Out Remark</th>
				<th scope="col">Action</th>

			</tr>
		</thead>
		<tbody>
			<tr class="table-light">
				<th scope="row">2019/07/21</th>
				<td>Tue</td>
				<td>8:00</td>
				<td>17:00</td>
				<td></td>
				<td></td>
				<td><button type="button" class="btn btn-secondary">Cancel</button>
					<br>
					<button type="button" class="btn btn-secondary">Edit</button></td>

			</tr>

		</tbody>
	</table>
</div>

<script src="webjars/jquery//jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>