<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
				<li><a href="<%=request.getContextPath()%>/listClub"
					class="nav-link">clubs</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
					<form action="updateClub" method="post">
            			<h2>Edit club</h2>
            			<input type="hidden" name="clubId" value="<c:out value='${club.clubId}' />" />
            			
            			
            			
            			<fieldset class="form-group">
						<label>Type</label> <input type="text"
						value="<c:out value='${club.clubType}' />" class="form-control"
						name="clubType" required="required">
						</fieldset>
				
						<fieldset class="form-group">
						<label>Capacite</label> <input type="text"
						value="<c:out value='${club.capacite}' />" class="form-control"
						name="capacite" required="required">
						</fieldset>

						<fieldset class="form-group">
						<label>Nombre des personnes</label> <input type="text"
						value="<c:out value='${club.nbPersonne}' />" class="form-control"
						name="nbPersonne" required="required">
					</fieldset>
				
					<fieldset class="form-group">
					<label>TarifId</label> <input type="text"
						value="<c:out value='${club.tarifId}' />" class="form-control"
						name="tarifId" required="required">
					</fieldset>

				

					<button type="submit" class="btn btn-success">Edit</button>
				</form>
				</div>
		</div>
	</div>
</body>
</html>tml>