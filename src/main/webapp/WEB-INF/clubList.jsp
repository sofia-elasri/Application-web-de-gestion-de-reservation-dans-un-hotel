<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>club Management Application</title>
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
				<li><a href="<%=request.getContextPath()%>/listClub" class="nav-link">Clubs</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of clubs</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newClub" class="btn btn-success">Add
					New club</a>
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
				
					<c:forEach var="club" items="${listclub}">

						<tr>
							<td><c:out value="${club.clubId}" /></td>
							<td><c:out value="${club.clubType}" /></td>
							<td><c:out value="${club.capacite}" /></td>
							<td><c:out value="${club.nbPersonne}" /></td>
							<td><c:out value="${club.nvPrix}" /></td>
							<td><a href="editClub?clubId=<c:out value='${club.clubId}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteClub?clubId=<c:out value='${club.clubId}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>