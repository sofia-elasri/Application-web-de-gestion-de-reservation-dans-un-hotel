<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<meta charset="UTF-8">
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
			

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listChambre"
					class="nav-link">chambres</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				
					<form action="insertChambre" method="post">
            			<h2>Add New chambre</h2>
            			<fieldset class="form-group">
					<label>Type</label> <input type="text"
						value="<c:out value='${chambre.chambreType}' />" class="form-control"
						name="chambreType" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Capacite</label> <input type="text"
						value="<c:out value='${chambre.capacite}' />" class="form-control"
						name="capacite" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Nombre des personnes</label> <input type="text"
						value="<c:out value='${chambre.nbPersonne}' />" class="form-control"
						name="nbPersonne">
				</fieldset>
				
				<fieldset class="form-group">
					<label>TarifId</label> <input type="text"
						value="<c:out value='${chambre.tarifId}' />" class="form-control"
						name="tarifId" required="required">
				</fieldset>

				

				<button type="submit" class="btn btn-success">Envoyer</button>
				</form>

				
			</div>
		</div>
	</div>
</body>
</html>