<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE  html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<title>Updating Commentaire Form</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylsheet"/>
<script src="../../webjars/bootstrp/4.0.0/css/bootstrap.min.css"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
   <h1>Updating the commentaire: ${commentaireForm.contained} ${commentaireForm.category}</h1>
     <form action="/commentaire/saveCommentaire" modelAttribute="commentaireForm" method="post">
       <table style="with: 50%">
         <input type="hidden" name="id" value=${commentaireForm.id}>
         <tr>
           <td>user id</td>
           <td><input type="number" name="userid" value="${commentaireForm.userid}" /></td>
         </tr>
         
         
         <tr>
         <td>contenue</td>
          <td><input type="text" name="contained" value="${commentaireForm.contained}" /></td>
         </tr>
          <tr>
          <td>time</td>
          <td><input type="time" name="time" value="${commentaireForm.time}" /></td>
         </tr>
         <tr>
          <td>date</td>
          <td><input type="date" name="date" value="${commentaireForm.date}" /></td>
         </tr>
         
        <tr>
        
      </table>
      <input type="submit" value="Submit" />
    </form>
</body>
