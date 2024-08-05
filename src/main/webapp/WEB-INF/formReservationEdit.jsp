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
				<li><a href="<%=request.getContextPath()%>/listReservation"
					class="nav-link">reservations</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
					<form action="updateReservation" method="post">
            			<h2>Edit reservation</h2>
            			<input type="hidden" name="resId" value="<c:out value='${reservation.resId}' />" />
            			
            			
            			
            			<fieldset class="form-group">
					<label>booking ID</label> <input type="text"
						value="<c:out value='${reservation.bookId}' />" class="form-control"
						name="bookId" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>chambreId</label> <input type="text"
						value="<c:out value='${reservation.chambreId}' />" class="form-control"
						name="chambreId" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>salleId</label> <input type="text"
						value="<c:out value='${reservation.salleId}' />" class="form-control"
						name="salleId">
				</fieldset>
				
				<fieldset class="form-group">
					<label>tableId</label> <input type="text"
						value="<c:out value='${reservation.tableId}' />" class="form-control"
						name="tableId" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>terasseId</label> <input type="text"
						value="<c:out value='${reservation.terasseId}' />" class="form-control"
						name="terasseId" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>piscineId</label> <input type="text"
						value="<c:out value='${reservation.piscineId}' />" class="form-control"
						name="piscineId" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>clubId</label> <input type="text"
						value="<c:out value='${reservation.clubId}' />" class="form-control"
						name="clubId" required="required">
				</fieldset>
				

				<button type="submit" class="btn btn-success">Envoyer</button>
				</form>
				</div>
		</div>
	</div>
</body>
</html>