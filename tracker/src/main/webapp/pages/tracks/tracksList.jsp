<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html xmlns:th="http://thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Tracks</title>
</head>
<body>
	<jsp:include page="../navigation/navbar.jsp" />

	<div class="tabMain container-fluid">
		<div>
			<h1>Tracks</h1>
		</div>
		<button class=" btnAdd">Add track</button>
		<table class="table">
			<thead>
				<tr>
					<th class="col-lg-1 col-sm-1">ID</th>
					<th class="col-lg-4 col-sm-3">Name</th>
					<th class="col-lg-3 col-sm-2">Duration</th>
					<th class="col-lg-2 col-sm-2">Format</th>
					<th class="col-lg-1 col-sm-2">Edit</th>
					<th class="col-lg-1 col-sm-2">Delete</th>
				</tr>
			</thead>
			<tbody>
				<tr th:each="track:${listTracks}">
					<td class="col-lg-1 col-sm-1" th:text="${track.id}"></td>
					<td class="col-lg-4 col-sm-3" th:text="${track.trackName}"></td>
					<td class="col-lg-3 col-sm-2" th:text="${track.fileFormat}"></td>
					<td class="col-lg-2 col-sm-2" th:text="${track.duration}"></td>
					<td class="col-lg-1 col-sm-2"><button class="btnE"><img src="../resource/edit.png" width="20" height="20"/></button></td>
					<td class="col-lg-1 col-sm-2"><button class="btnD"><img src="../resource/del.png" width="20" height="20"/></button></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>