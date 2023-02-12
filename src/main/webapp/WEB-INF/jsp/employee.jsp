<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>

<form action="/api/employee" method="post">
  <fieldset>
    <legend>Employee Details:</legend>
    <label for="EmpName">Employee Name:</label><br>
    <input type="text" id="EmpName" name="name" placeholder="Pavan Kunar"><br>
     <label for="EmpEmail">Employee Email:</label><br>
    <input type="text" id="EmpEmail" name="email" placeholder="pavankunar@gmail.com"><br>
    <label for="EmpLoc">Employee Location:</label><br>
    <input type="text" id="EmpLoc" name="empBaseLocation" placeholder="Bangalore"><br>
    <label for="EmpCode">Employee Project Code:</label><br>
    <input type=number id="EmpCode" name="empProjCode" placeholder=101><br><br>
    <input type="submit" value="Submit">
  </fieldset>
</form>
</body>
</html>