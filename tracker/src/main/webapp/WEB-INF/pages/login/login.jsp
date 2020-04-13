<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div>
		<form id="contactForm" method="POST" action="login" role="form">
			<div class="modal-body">
				<div class="form-group">
					<label for="username">Userame</label> <input type="text"
						id="username" name="username" class="form-control">
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						id="password" name="password" class="form-control">
				</div>
			</div>
			<div class="form-actions modal-footer">
				<button type="submit" id="id" name="id" class="btn btn-primary">Log
					in</button>
			</div>
		</form>
	</div>
</body>
</html>