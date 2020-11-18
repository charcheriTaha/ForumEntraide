<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE  html PUBLIC "-//W3C//DTD HTML 4.01 Traditional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Commentaire List</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css "
	rel="Stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>

	<div class="Container">
		<h2>Commentaire List</h2>
		<table class="table table-striped" border="2">
			<thead>
				<th scope="row">#ID</th>
				<th scope="row">User_ID</th>
				<th scope="row">Contained</th>
				<th scope="row">Time</th>
				<th scope="row">Date</th>
				<th scope="row">Update</th>
				<th scope="row">Delete</th>
			</thead>

			<tbody>
				<c:forEach items="${commentairesList  }" var="commentaire">
					<tr>

						<td>${commentaire.id }</td>
						<td>${commentaire.userid}</td>
						<td>${commentaire.contained}</td>
						<td>${commentaire.time}</td>
						<td>${commentaire.date}</td>

						<td><spring:url
								value="/commentaire/updateCommentaire/${commentaire.id }"
								var="updateURL" /> <a class="btn btn-primary"
							href="${updateURL }" role="button">Update</a></td>

						<td><spring:url
								value="/commentaire//deleteCommentaire/${commentaire.id }"
								var="deleteURL" /> <a class="btn btn-primary"
							href="${deleteURL }" role="button">Delete</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/commentaire/addCommentaire/" var="addURL" />
		<a class="btn btn-primary" href="${addURL }" role="button">Add New
			Commentaire</a>

	</div>

	



	<form action="/commentaire/searching list by User_Id" method="post">
		<table style="with: 50%">
			<tr>
				<td>Searching list by User_Id</td>
				<td><input type="number" name="ui" value="${ui}" /></td>
				<td><input type="submit" value="search" /></td>

			</tr>
		</table>


		<form action="/commentaire/searching list by date" method="post">
			<table style="with: 50%">
				<tr>
					<td>Searching list by date</td>
					<td><input type="date" name="dt" value="${dt}" /></td>
					<td><input type="submit" value="search" /></td>

				</tr>
			</table>
		</form>






		<form action="/commentaire/searching list by contained containing"
			method="post">
			<table style="with: 50%">
				<tr>
					<td>Search by contained containing</td>
					<td><input type="text" name="cc" value="${cc}" /></td>
					<td><input type="submit" value="search" /></td>

				</tr>
			</table>
		</form>
</body>
</html>