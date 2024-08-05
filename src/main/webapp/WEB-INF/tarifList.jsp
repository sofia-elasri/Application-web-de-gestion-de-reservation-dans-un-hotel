<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>tarif Management Application</title>
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
				<a href="https://www.xadmin.net" class="navbar-brand"> tarif
					Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listTarif" class="nav-link">tarifs</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of tarifs</h3>
			<hr>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Tarif ID</th>		
						<th>Prix</th>
						<th>Nouveau Prix</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="tarif" items="${listtarif}">

						<tr>
							<td><c:out value="${tarif.tarifId}" /></td>
							<td><c:out value="${tarif.prix}" /></td>
							<td><c:out value="${tarif.nvPrix}" /></td>
							<td><a href="editTarif?tarifId=<c:out value='${tarif.tarifId}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; </td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>