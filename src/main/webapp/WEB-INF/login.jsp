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
				<li><h1>Login</h1></li>
			</ul>
			<br><br><br>
			
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
					<form action="<%=request.getContextPath()%>/login" method="post">
            			
            			<fieldset class="form-group">
						<label>Login</label> <input type="text"
						value="<c:out value='${user.login}' />" class="form-control"
						name="login" required="required">
						</fieldset>
				
						
				
					<fieldset class="form-group">
					<label>Mot de passe</label> <input type="password"
						value="<c:out value='${user.passwd}' />" class="form-control"
						name="passwd" required="required">
					</fieldset>
					<span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>

					<button type="submit" class="btn btn-success">login</button>
				</form>
				</div>
		</div>
	</div>
</body>
</html>