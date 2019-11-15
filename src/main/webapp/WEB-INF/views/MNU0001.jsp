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
		<a href="logout">Logout</a> <a class="list">Employee
			ID:${auth.employee_id}<br>Employee Name:${auth.employee_name}
		</a> <br>
	</div>



	<div class="main">
		<form:form method="POST" action="saveTime" modelAttribute="menu"
			class="form-horizontal">
			<div class="form-group row">
				<div class="col-md-4">

					<div class="form-group row">
						<label for="employee_name">Employee name
							:${auth.employee_name}</label>
					</div>




					<div class="form-group row">
						<div class="col-sm-5">
							<form:label path="in_time">IN</form:label>
							<form:input path="in_time" class="form-control form-control-sm"
								id="box" readOnly="true" />
						</div>

						<div class="col-sm-5">
							<form:label path="out_time">OUT</form:label>
							<form:input path="out_time" class="form-control form-control-sm"
								value="HH:" id="box" readOnly="true" />
						</div>
					</div>
				</div>
				<div class="col-md-5">
					<div class="col-md-11">
						<form:label path="in_time_reason">Reason(<span>*</span>)
					</form:label>
						<br>
						<form:textarea class="form-control" path="in_time_reason" rows="3"
							cols="6" />
					</div>
				</div>


				<div class="col-md-3">
					<div class="form-group row">
						<div class="col-sm-4">
							<button type="button" class="btn btn-secondary btn-md btnexcel">Excel</button>
							<br> <br>
							<button type="submit" class="btn btn-secondary btn-md">Submit</button>

						</div>
						<div class="col-sm-8">
							<br>
							<button type="button" class="btn btn-secondary btn-md">Update</button>
						</div>
					</div>
				</div>
			</div>
		
	</form:form>


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


			<c:forEach var="attlist" items="${ListAttend}">
				<tr align="center" id="TableBody">
					<td width="11%">${attlist.date}</td>
					<td width="10%">${attlist.day}</td>
					<td width="10%">${attlist.in_time}</td>
					<td width="10%"></td>
					<td width="25%">${attlist.in_time_reason}</td>
					<td width="25%"></td>
					<td width="9%">
					
					
						
							<a href="editAttendance?id=${attlist.att_id}" data-toggle="modal"
								data-target="#myModal"
								class="btn btn-secondary btn-sm btn_size2">Edit</a>

							<div class="modal fade" id="myModal">
								<div class="modal-dialog">

									<div class="col-sm-10">
										<div class="modal-content">

											<div class="modal-body">
											<%-- 	<form:form method="GET" action="POP" modelAttribute="editatt"
													class="form-horizontal"> --%>
													<div class="form-row">
														<div class="form-group col-md-3">
															<label for="in-time">In</label> 
														<%-- 	<form:input path="in_time"  /> --%>
															<input type="text"
														class="form-control" id="intime">
														</div>
														<div class="form-group col-md-3">
															<label for="out-time">Out</label>
														<input type="text"
														class="form-control" id="outtime">
														</div>
													</div>

													<div class="form-row">
														<div class="form-group col-md-6">
															<label for="message-text" class="col-form-label">In
																Reason(<span>*</span>)
															</label>
															<%-- <form:textarea class="form-control" path="in_time_reason"  id="message-text" rows="3"
																cols="15"/> --%>
														<textarea class="form-control" id="message-text" rows="3"
																cols="15"></textarea> 
														</div>
														<div class="form-group col-md-6">
															<label for="message-text" class="col-form-label">Out
																Reason(<span>*</span>)</span>
															</label>
															<textarea class="form-control" id="message-text" rows="3"
																cols="15" value="${attlist.in_time_reason}"></textarea>
														</div>
													</div>
												<%-- </form:form> --%>
											</div>



											<div class="form-group col-md-6">
												<button type="submit" class="btn btn-secondary btnOk">OK</button>


												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">Cancel</button>
											</div>
										</div>
									</div>
								</div>
							</div>



						<br>

						<button type="button" class="btn btn-secondary btn-sm btn_size1">Cancel</button>
					</td>
				</tr>


			</c:forEach>
			


			<tr align="center" id="TableBody">
			</tr>

			<tr align="center" id="SatSun">
			</tr>


		</table>
	
	</div>


	<script src="<c:url value="/webjars/jquery/3.4.1/jquery.min.js" />"></script>
	<script
		src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js" />"></script>

</body>
</html>
