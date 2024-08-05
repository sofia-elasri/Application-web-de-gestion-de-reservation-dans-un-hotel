<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>piscine Management Application</title>
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
				<li><a href="<%=request.getContextPath()%>/listPiscine" class="nav-link">piscines</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of piscines</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newPiscine" class="btn btn-success">Add
					New piscine</a>
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
				
					<c:forEach var="piscine" items="${listpiscine}">

						<tr>
							<td><c:out value="${piscine.piscineId}" /></td>
							<td><c:out value="${piscine.piscineType}" /></td>
							<td><c:out value="${piscine.capacite}" /></td>
							<td><c:out value="${piscine.nbPersonne}" /></td>
							<td><c:out value="${piscine.nvPrix}" /></td>
							<td><a href="editPiscine?piscineId=<c:out value='${piscine.piscineId}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deletePiscine?piscineId=<c:out value='${piscine.piscineId}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>