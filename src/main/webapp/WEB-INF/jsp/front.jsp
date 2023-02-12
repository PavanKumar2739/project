<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style ="text-align:center" >
<h1>Welcome to home page</h1>
</body>
<form action="/projectDetails" method="post">
  <fieldset>
    <legend>Project Details:</legend>
    <label for="fname">Project Code:</label><br>
    <input type="text" id="fname" name="projCode" value="101"><br>
    <label for="lname">Project Name:</label><br>
    <input type="text" id="lname" name="projName" value="Find the bugs for UtilsFile"><br><br>
    <input type="submit" value="Submit">
  </fieldset>
</form>

</html>