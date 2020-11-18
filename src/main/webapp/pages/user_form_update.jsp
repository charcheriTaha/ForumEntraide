<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE  html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<title>Updating User Form</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylsheet"/>
<script src="../../webjars/bootstrp/4.0.0/css/bootstrap.min.css"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
   <h1>Updating the user: ${userForm.firstName} ${userForm.lastName}</h1>
     <form action="/user/saveUser" modelAttribute="userForm" method="post">
       <table style="with: 50%">
         <input type="hidden" name="id" value=${userForm.id}>
        
         <tr>
         <td>firstName</td>
           <td><input type="text" name="firstName" value="${userForm.firstName}" /></td>
         </tr>
         
         <tr>
         <td>lastName</td>
           <td><input type="text" name="lastName" value="${userForm.lastName}" /></td>
         </tr>
         
         <tr>
         <td>E-mail</td>
          <td><input type="text" name="email" value="${userForm.email}" /></td>
         </tr>
          <tr>
          <td>Mobile</td>
          <td><input type="text" name="mobile" value="${userForm.mobile}" /></td>
         </tr>
         <tr>
          <td>Address</td>
          <td><input type="text" name="address" value="${userForm.address}" /></td>
         </tr>
         <tr>
          <td>date</td>
          <td><input type="date" name="date" value="${userForm.date}" /></td>
         </tr>
         
        <tr>
        
      </table>
      <input type="submit" value="Submit" />
    </form>
</body>