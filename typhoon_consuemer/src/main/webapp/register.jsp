<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<h2>Merchant Register!</h2>
	<form action="UserRegisterServlet" method="post">
		<hr>
		username:<input type="text" name="username">
		<hr>
		password:<input type="password" name="password" />
		<hr>
		<input type="submit" value="注册" /><a href="login.jsp">去登陆</a>
		<hr>
	</form>
</body>
</html>
