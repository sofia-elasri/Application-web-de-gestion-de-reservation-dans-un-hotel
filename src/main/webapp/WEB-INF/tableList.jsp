<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>table Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listTable" class="nav-link">Tables</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of tables</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newTable" class="btn btn-success">Add
					New table</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Type</th>
						<th>Capacite</th>
						<th>Nombres des personnes</th>
						<th>Tarif</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="table" items="${listtable}">

						<tr>
							<td><c:out value="${table.tableId}" /></td>
							<td><c:out value="${table.tableType}" /></td>
							<td><c:out value="${table.capacite}" /></td>
							<td><c:out value="${table.nbPersonne}" /></td>
							<td><c:out value="${table.nvPrix}" /></td>
							<td><a href="editTable?tableId=<c:out value='${table.tableId}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteTable?tableId=<c:out value='${table.tableId}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>