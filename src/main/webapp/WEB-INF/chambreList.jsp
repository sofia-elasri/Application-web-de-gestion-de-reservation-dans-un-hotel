<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>chambre Management Application</title>
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
				<a href="https://www.xadmin.net" class="navbar-brand"> chambre
					Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listChambre" class="nav-link">chambres</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of chambres</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newChambre" class="btn btn-success">Add
					New chambre</a>
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
				
					<c:forEach var="chambre" items="${listchambre}">

						<tr>
							<td><c:out value="${chambre.chambreId}" /></td>
							<td><c:out value="${chambre.chambreType}" /></td>
							<td><c:out value="${chambre.capacite}" /></td>
							<td><c:out value="${chambre.nbPersonne}" /></td>
							<td><c:out value="${chambre.nvPrix}" /></td>
							<td><a href="editChambre?chambreId=<c:out value='${chambre.chambreId}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteChambre?chambreId=<c:out value='${chambre.chambreId}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>