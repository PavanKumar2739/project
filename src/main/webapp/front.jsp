<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style ="text-align:center">
<h1>Welcome to home page</h1>
<form action="addCustomer"  method="post">
<input type="text" name="firstname" placeholder="First Name"/><br />
<input type="text" name=lastname placeholder="Last Name"/><br />
<input type="text" name="email" placeholder="Email"/><br />
<input type="password" name="password" placeholder="Password"/><br />
<input type="submit" value="Submit"/><br/>
</form>
</body>
</html>