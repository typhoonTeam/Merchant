<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><h1>登记资料</h1>
	<a href="welcome.jsp" >返回首页</a>
	<hr>
	shopId :${registerInfo.shopId}<hr>
	creditCode :${registerInfo.creditCode}<hr>
	idCard :${registerInfo.idCard}<hr>
	corporateName :${registerInfo.corporateName}<hr>
	picture :<img src='${registerInfo.picture}' width='130'><hr>
	phone :${registerInfo.phone}<hr>
	shopName :${registerInfo.shopName}<hr>
	address :${registerInfo.address}<hr>
	comments :${registerInfo.comments}<hr>
	
</body>
</html>