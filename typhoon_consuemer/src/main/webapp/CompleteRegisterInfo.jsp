<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<h2>Merchant CompleteRegisterInfo!</h2>

	<form action="CompleteRegisterInfoServlet" method="post" enctype="multipart/form-data">
		<hr>
		工商号:<input type="text" name="creditCode" value="${reg.creditCode}">
		<hr>
		身份证:<input type="text" name="idCard" value="${reg.idCard}" />
		<hr>
		电话:<input type="text" name="phone" value="${reg.phone}">
		<hr>
		法人名:<input type="text" name="corporateName" value="${reg.corporateName}">
		<hr>
		店铺：<input type="text" name="shopName" value="${reg.shopName}">
		<hr>
		地址:<input type="text" name="address" value="${reg.address}">
		<hr>
		备注:<input type="text" name="comments" value="${reg.comments}">
		<hr>
		<img src='${reg.picture}' width='130'>
		身份证图片:<input type="file" name="picture" value="${reg.picture}">
		<hr>
		<input type="submit" value="提交店铺信息" />	
		<hr>
	</form>
</body>
</html>
