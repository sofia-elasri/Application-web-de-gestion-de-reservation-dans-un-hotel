<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>terasse Management Application</title>
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
				<li><a href="<%=request.getContextPath()%>/listTerasse" class="nav-link">Terasses</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of terasses</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newTerasse" class="btn btn-success">Add
					New terasse</a>
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
				
					<c:forEach var="terasse" items="${listterasse}">

						<tr>
							<td><c:out value="${terasse.terasseId}" /></td>
							<td><c:out value="${terasse.terasseType}" /></td>
							<td><c:out value="${terasse.capacite}" /></td>
							<td><c:out value="${terasse.nbPersonne}" /></td>
							<td><c:out value="${terasse.nvPrix}" /></td>
							<td><a href="editTerasse?terasseId=<c:out value='${terasse.terasseId}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteTerasse?terasseId=<c:out value='${terasse.terasseId}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>