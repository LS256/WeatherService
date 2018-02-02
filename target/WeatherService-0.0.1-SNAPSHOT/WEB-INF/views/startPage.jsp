<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" />
	<title>Weather forecast service</title>
	
	<style>
		body { background-color: #efefef; }
		td { text-align: center; }
		.error { color: #ff0000; }
		.errorblock { color: #000; background-color: #ffEEEE; border: 3px solid #ff0000; padding: 8px; margin: 16px; }
		.topBar { background-color: #000000; color: #efefef; height: 30px;}
		.languageTopBar { background-color: #000000; color: #efefef; float: right; min-width: 30px; font-size: 20px; padding: 3px; margin-top: 6px;}		
		a {text-decoration: none; color: #efefef;}
		.loginFrame {margin: auto; border: 1px dashed #000000; width: 40%; padding: 10px; line-height: 2;'}
	</style>
	
</head>

<body>
	<div class="topBar">
		<div class="languageTopBar"><a href="?language=en"><img src="http://openweathermap.org/images/flags/gb.png" /></a></div>
		<div class="languageTopBar"><a href="?language=pl"><img src="http://openweathermap.org/images/flags/pl.png"/></a></div>
		<div style="clear: both"></div>
	</div>

</br></br>
<div class="loginFrame">
	<form:form method="POST" action="weatherForecast" accept-charset="UTF-8">
		<input type="text" name="cityNameInput" value="Lodz"></br>
		<input type="checkbox" name="weatherType" value="shortTerm" checked="checked" /><spring:message code="WebController.startPage.ShortTerm" /></br>
		<input type="checkbox" name="weatherType" value="longTerm" /><spring:message code="WebController.startPage.LongTerm" /></br>
		<input type="submit" value="Search" />
		
	</form:form>
</div>




</body>
</html>