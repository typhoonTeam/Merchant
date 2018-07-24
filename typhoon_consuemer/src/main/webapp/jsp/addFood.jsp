<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>foodDetail</title>
</head>
<body>

	<a href="javascript:history.back(-1)">返回</a>

	<h2>Add food !</h2>

	<form action="AddfoodServlet" enctype="multipart/form-data"
		method="post">
		<hr>
		菜品名:<input type="text" name="foodName">
		<hr>
		价格:<input type="text" name="price">
		<hr>
		图片:<input type="file" name="picture">
		<hr>
		信息:<input type="text" name="info">
		<hr>
		状态:<input type="text" name="status">
		<hr>
		<input type="submit" value="添加" />

	</form>

</body>
</html>