<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<meta charset="UTF-8">
<title>Client Management Application</title>
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
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Clients</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				
					<form action="insert" method="post">
            			<h2>Add New Client</h2>
            			<fieldset class="form-group">
					<label>Nom</label> <input type="text"
						value="<c:out value='${client.nom}' />" class="form-control"
						name="nom" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Prenom</label> <input type="text"
						value="<c:out value='${client.prenom}' />" class="form-control"
						name="prenom" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${client.email}' />" class="form-control"
						name="email">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Mot de passe</label> <input type="password"
						value="<c:out value='${client.passwd}' />" class="form-control"
						name="passwd" required="required">
				</fieldset>

				

				<button type="submit" class="btn btn-success">Envoyer</button>
				</form>

				
			</div>
		</div>
	</div>
</body>
</html>