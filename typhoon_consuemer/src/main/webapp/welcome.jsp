<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>欢迎页</title>
<script type="text/javascript">
　
</script>
</head>
<body>
	<h2>
		你的用户ID :${user.getShopId()}
		<hr>
		你的用户名 :${user.getUsername()}
		<button
			onclick="javascript:location.href='ShowRestaurantDetailServlet'">修改店铺信息</button>
		<button onclick="javascript:location.href='ShowRestaurantInfoServlet'">查看登记资料</button>
		<hr>
		店铺审核状态为 :${status}
		<c:if test="${status=='通过' }">
		<button onclick="location.href='ShowFoodsServlet'" type="button">
			进入店铺</button>
		</c:if>
		<c:if test="${status=='驳回' }">
		<button onclick="location.href='CompleteRegisterInfo.jsp'"
			type="button">重新提交审核</button>
			</c:if>
		<hr>
	</h2>
</body>
</html>