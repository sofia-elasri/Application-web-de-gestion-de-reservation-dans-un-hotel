<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<meta charset="UTF-8">
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
				<li><a href="<%=request.getContextPath()%>/listTable"
					class="nav-link">Tables</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				
					<form action="insertTable" method="post">
            			<h2>Add New table</h2>
            			<fieldset class="form-group">
					<label>Type</label> <input type="text"
						value="<c:out value='${table.tableType}' />" class="form-control"
						name="tableType" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Capacite</label> <input type="text"
						value="<c:out value='${table.capacite}' />" class="form-control"
						name="capacite" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Nombre des personnes</label> <input type="text"
						value="<c:out value='${table.nbPersonne}' />" class="form-control"
						name="nbPersonne">
				</fieldset>
				
				<fieldset class="form-group">
					<label>TarifId</label> <input type="text"
						value="<c:out value='${table.tarifId}' />" class="form-control"
						name="tarifId" required="required">
				</fieldset>

				

				<button type="submit" class="btn btn-success">Envoyer</button>
				</form>

				
			</div>
		</div>
	</div>
</body>
</html>