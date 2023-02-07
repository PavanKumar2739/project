<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style ="text-align:center">
<h1>Success page</h1>
<c:forEach var="i" items="${data}">
     <h4>First Name : ${i.firstname}</h4>
      <h4>Last Name : ${i.lastname}</h4>
       <h4>Email : ${i.email}</h4>
       <hr /><br />
</c:forEach>
</body>
</html>