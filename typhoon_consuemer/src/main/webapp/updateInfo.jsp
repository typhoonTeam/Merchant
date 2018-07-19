<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>修改资料</title>
</head>
<body>
<form action="ShowRestaurantDetailServlet" method="post">
<div >
    <br>
    <br>
    开业时间  <input name="openTime" type="time" value="${Msg.getOpenTime()}">
    休业时间  <input name="closeTime" type="time" value="${Msg.getCloseTime()}">

    <br>
    <br>
    配送范围  <input name="delivery" type="text" value="${Msg.getDelivery()}">
    配送费用<input name="deliFee" type="text" value="${Msg.getDeli_fee()}">
</div>


    <br>
    图片 ： <img name="img1" src="${Msg.getPicture()}" width="150" height="150">
   <input  name="picture" type="hidden" value="${Msg.getPicture()}"/>
    
   <!--<br>
    密码  <input id="password" type="text" placeholder="${user.getPassword()}">
    <br>  -->
      
    <br>
    <br>
    标语  <input name="slogan" type="text" style="width: 300px;height: 150px" value="${Msg.getSlogan()}">
    备注  <input name="comments" type="text" style="width: 300px;height: 150px" value="${Msg.getComments()} ">
    <br>
    <br>


    <input id="commit" value="完成" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;<a href="welcome.jsp" >返回首页</a>
</form>	

</body>
</html>