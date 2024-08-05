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
				<li><a href="<%=request.getContextPath()%>/listTarif"
					class="nav-link">Tarifs</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
					<form action="updateTarif" method="post">
            			<h2>Edit tarif</h2>
            			<input type="hidden" name="tarifId" value="<c:out value='${tarif.tarifId}' />" />
            			
            			
            			
            			<fieldset class="form-group">
						<label>Prix</label> <input type="text"
						value="<c:out value='${tarif.prix}' />" class="form-control"
						name="prix" required="required">
						</fieldset>
				
						<fieldset class="form-group">
						<label>Nouveau prix</label> <input type="text"
						value="<c:out value='${tarif.nvPrix}' />" class="form-control"
						name="nvPrix" required="required">
						</fieldset>


				

					<button type="submit" class="btn btn-success">Edit Tarif</button>
				</form>
				</div>
		</div>
	</div>
</body>
</html>