<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商家管理页面</title>
</head>
<body>

	<a href="welcome.jsp">去欢迎页</a> &nbsp;&nbsp;&nbsp;
	<a href="./AdsListServlet">申请推荐</a> &nbsp;&nbsp;&nbsp;
	<a href="addFood.jsp">添加菜品</a>&nbsp;&nbsp;&nbsp;
	<a href="./UserExitServlet">退出</a>&nbsp;&nbsp;&nbsp;
	<h2>菜品列表</h2>
	<table border="1">
		<tr>
			<td width="150">菜名</td>
			<td width="150">图片</td>
			<td width="150">价格</td>
			<td width="150">操作</td>
		</tr>
		<c:forEach items="${foods}" var="food">
			<tr height="200">
				<td width="150">${food.getFoodName()}</td>
				<td width="150"><img src='${food.picture}' width='130'></td>
				<td width="150">${food.getPrice()}</td>
				<td width="150"><a
					href="./FoodDetailServlet?food_id=${food.id}" class="a_post">详细信息&修改</a><a
					href="./DeleteFoodServlet?food_id=${food.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>