<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Genres</title>
</head>
<body>
	<jsp:include page="../navigation/navbar.jsp" />
	<div class="tabMain container-fluid">
		<div>
			<h1>Genres</h1>
		</div>
		<div class="row">
			<div class="col-12">
				<button class=" btnAdd">Add genre</button>
				<table class="table">
					<thead>
						<tr>
							<th class="col-lg-10 col-sm-8">Name</th>
							<th class="col-lg-1 col-sm-2">Edit</th>
							<th class="col-lg-1 col-sm-2">Delete</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="col-lg-10 col-sm-8"></td>
							<td class="col-lg-1 col-sm-2"><button class="btnE"><img src="../resource/edit.png" width="20" height="20"/></button></td>
							<td class="col-lg-1 col-sm-2"><button class="btnD"><img src="../resource/del.png" width="20" height="20"/></button></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>