<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE  html PUBLIC "-//W3C//DTD HTML 4.01 Traditional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css "
	rel="Stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>

	<div class="Container">
		<h2>User List</h2>
		<table class="table table-striped" border="2">
			<thead>
				<th scope="row">#ID</th>
				<th scope="row">First name</th>
				<th scope="row">Last name</th>
				<th scope="row">Email</th>
				<th scope="row">Mobile</th>
				<th scope="row">Address</th>
				<th scope="row">Date</th>
				<th scope="row">Update</th>
				<th scope="row">Delete</th>
			</thead>

			<tbody>
				<c:forEach items="${usersList  }" var="user">
					<tr>

						<td>${user.id }</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.email}</td>
						<td>${user.mobile}</td>
						<td>${user.address}</td>
						<td>${user.date}</td>

						<td><spring:url value="/user/updateUser/${user.id }"
								var="updateURL" /> <a class="btn btn-primary"
							href="${updateURL }" role="button">Update</a></td>

						<td><spring:url value="/user//deleteUser/${user.id }"
								var="deleteURL" /> <a class="btn btn-primary"
							href="${deleteURL }" role="button">Delete</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/user/addUser/" var="addURL" />
		<a class="btn btn-primary" href="${addURL }" role="button">Add New
			User</a>

	</div>

	<form action="/user/searching list by first name" method="post">
		<table style="with: 50%">
			<tr>
				<td>Search by First name</td>
				<td><input type="text" name="fn" value="${fn}" /></td>
				<td><input type="submit" value="search" /></td>

			</tr>
		</table>
	</form>

	<form action="/user/searching list by address containing" method="post">
		<table style="with: 50%">
			<tr>
				<td>Search by address containing</td>
				<td><input type="text" name="ad" value="${ad}" /></td>
				<td><input type="submit" value="search" /></td>

			</tr>
		</table>
	</form>


</body>
</html>