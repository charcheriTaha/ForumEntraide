<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Traditional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Commentaire Form</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
	<h1>Adding a New Commentaire</h1>
	<form action="/commentaire/saveCommentaire" modelAttribute="commentaireForm" method="post">
		<table>
			<tr>
				<td>User Id</td>
				<td><input type="number" name="userid" /></td>
			</tr>
			
			<tr>
				<td>contenue</td>
				<td><input type="text" name="contained" /></td>
			</tr>
			<tr>
				<td>time</td>
				<td><input type="time" name="time" /></td>
			</tr>
			<tr>
				<td>date</td>
				<td><input type="date" name="date" /></td>
			</tr>
			
		</table>
		<input type="submit" value="Submit" />
	</form>

</body>
</html>