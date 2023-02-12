<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="webjars/bootstrap/5.2.3/css/bootstrap.css.map" rel="stylesheet">
</head>
<body >
<h1>Welcome to home page</h1>
</body>
<h2>${errorMsg}</h2>
<div class="login-form">
<div class="container-fluid">
<form action="/next" method="post">
 <input type="text" id="userid" class="form-control" placeholder="userid">
 <input type="text" id="password" class="form-control" placeholder="password">
 <input type="submit" value="LogIn" >
</form>
</div>
</div>


</html>