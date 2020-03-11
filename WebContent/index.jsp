<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Testing PKI</title>
</head>
<body>
	<h1>Hello JSP and Servlet!</h1>
	<h2>Click here to go <a href = "HelloWorld"> My Servlet</a></h2>
	<form action="HelloWorld" method="post">
    	Enter your name: <input type="text" name="yourName" size="20">
   	 	<input type="submit" value="Call Servlet" />
	</form>
</body>
</html>