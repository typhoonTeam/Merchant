<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>广告列表</title>
</head>
<body>
<h2>广告列表</h2>
	<table border="1">
		<tr>
			<td width="150">ID</td>
			<td width="150">图片</td>
			<td width="150">标语</td>
			<td width="150">状态</td>
			<td width="150">时间</td>
		</tr>
		<c:forEach items="${ads}" var="ad">
			<tr height="200">
				<td width="150"><a href="./ApplyServlet?ad_id=${ad.id}">${ad.getId()}</a></td>
				<td width="150">
				<img src='${ad.getPicture()}' width='130'></td>
				<td width="150">${ad.getSlogan()}</td>
				<td width="150">${ad.getTime()}</td>
				<td width="150">
				</td>
			</tr>
		</c:forEach>
</body>
</html>