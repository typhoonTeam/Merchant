<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>欢迎页</title>
</head>
<body>
	<h2>
		你的用户ID :${user.getShopId()}
		<hr>
		你的用户名 :${user.getUsername()}<button onclick="javascript:location.href='ShowRestaurantDetailServlet'">修改店铺信息</button><button onclick="javascript:location.href='ShowRestaurantInfoServlet'">查看登记资料</button>
		<hr>
		店铺审核状态为 :${checkStatus}<button onclick="location.href='ShowFoodsServlet'" type="button"> 进入店铺</button>
		<hr>
	</h2>
</body>
</html>