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
			<div>
				<h1>Page Receptionist : </h1> 
			</div>

			
		</nav>
	</header>
	<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listTable" class="nav-link">Consulter les reservations</a></li>
				<li><a href="<%=request.getContextPath()%>/listTerasse" class="nav-link">Consulter les reservations</a></li>
				<li><a href="<%=request.getContextPath()%>/listClub" class="nav-link">Consulter les reservations</a></li>
				<li><a href="<%=request.getContextPath()%>/listPiscine" class="nav-link">Consulter les reservations</a></li>

	</ul>

</body>
</html>