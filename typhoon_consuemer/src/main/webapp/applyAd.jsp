<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=utf-8">
<title>发送推荐</title>
</head>
<body>
    <form action="ApplyServlet" method="post">
    标语 <input type="text" name="slogan" value="${ad.getSlogan()}"/>
     <br>
   状态  <input type="text" name="state" value="${ad.getState()}"/>
    <br>
  时间  <input type="text" name="time" value="${ad.getTime()}"/>
   <br>
    <img src="${ad.getPicture()}" width="130"  height="130"> 
     <br> <input type="hidden" name="picture" value = "${ad.getPicture()}"/>
    <br>
    <input type="submit" value="发送">
    </form>
</body>
</html>