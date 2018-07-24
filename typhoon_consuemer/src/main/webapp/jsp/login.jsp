<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

</head>
<body>
	<h2>Merchant Login!</h2>
	<form action="UserLoginServlet" method="post">
		<hr>
		用户名:<input type="text" name="username">
		<hr>
		密码:<input type="password" name="password">
		<hr>
		<input type="submit" value="登陆" />
		<a href="register.jsp">去注册</a>
	</form>
</body>
</html>
