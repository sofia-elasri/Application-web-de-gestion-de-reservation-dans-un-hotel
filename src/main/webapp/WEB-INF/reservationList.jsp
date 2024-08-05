<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>reservation Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> reservation
					Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listReservation" class="nav-link">reservations</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of reservations</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newReservation" class="btn btn-success">Add
					New reservation</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Booking ID</th>
						<th>chambreId</th>
						<th>salleId</th>
						<th>tableId</th>
						<th>terasseId</th>
						<th>piscineId</th>
						<th>clubId</th>
						<th>chambreType</th>
						<th>salleType</th>
						<th>tableType</th>
						<th>terasseType</th>
						<th>piscineType</th>
						<th>clubType</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="reservation" items="${listreservation}">

						<tr>
							<td><c:out value="${reservation.resId}" /></td>
							<td><c:out value="${reservation.bookId}" /></td>
							<td><c:out value="${reservation.chambreId}" /></td>
							<td><c:out value="${reservation.salleId}" /></td>
							<td><c:out value="${reservation.tableId}" /></td>
							<td><c:out value="${reservation.terasseId}" /></td>
							<td><c:out value="${reservation.piscineId}" /></td>
							<td><c:out value="${reservation.clubId}" /></td>
							<td><c:out value="${reservation.chambreType}" /></td>
							<td><c:out value="${reservation.salleType}" /></td>
							<td><c:out value="${reservation.tableType}" /></td>
							<td><c:out value="${reservation.terasseType}" /></td>
							<td><c:out value="${reservation.piscineType}" /></td>
							<td><c:out value="${reservation.clubType}" /></td>
							<td><a href="editReservation?resId=<c:out value='${reservation.resId}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteReservation?resId=<c:out value='${reservation.resId}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>