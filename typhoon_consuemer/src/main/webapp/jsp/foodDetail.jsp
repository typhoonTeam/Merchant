<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>foodDetail</title>
</head>
<body>

<a href="ShowFoodsServlet">回到管理页面</a>

<h3>菜品详情&修改</h3>
<form action="UpdatefoodServlet" enctype="multipart/form-data"
		method="post"><input type="hidden" name="id" value="${food.id}"> 
		<hr>
		菜品名:<input type="text" name="foodName" value="${food.foodName}">
		<hr>
		价格:<input type="text" name="price" value="${food.price}">
		<hr>
		原图片:<img src='${food.picture}' width='130'>上傳新圖:<input type="file" name="picture" value="${food.picture}">
		<hr>
		信息:<input type="text" name="info" value="${food.info}">
		<hr>
		状态:<input type="text" name="status" value="${food.status}">
		<hr>
		<input type="submit" value="提交修改" />
 	<input type="reset" value="复原" />
	</form>

</body>
</html>