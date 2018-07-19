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
		credit_code:<input type="text" name="creditCode">
		<hr>
		id_card:<input type="text" name="idCard" />
		<hr>
		phone:<input type="text" name="phone">
		<hr>
		法人名:<input type="text" name="corporateName">
		<hr>
		shop_name:<input type="text" name="shopName">
		<hr>
		address:<input type="text" name="address">
		<hr>
		comments:<input type="text" name="comments">
		<hr>
		picture:<input type="file" name="picture">
		<hr>
		<input type="submit" value="提交店铺信息" />
		<hr>
	</form>
</body>
</html>
