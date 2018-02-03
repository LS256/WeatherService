<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" />
	<title>Long term weather forecast</title>
	
	<style>
		body { background-color: #efefef; }
		table { margin: auto; border-collapse: collapse;}
		table, th, td { border: 1px solid #000000; text-align: center; }
		.mainInfo { text-align: center; border: 1px dashed #000000; width: 60%; margin: auto; }
		.topBar { background-color: #000000; color: #efefef;}
		.languageTopBar { background-color: #000000; color: #efefef; float: right; min-width: 30px; font-size: 15px; padding: 3px; margin-top: 0px;}
		a {text-decoration: none; color: #efefef;}
	</style>
	
</head>

<body>
	<div class="topBar">
		<div class="languageTopBar"><a href="weatherForecast">&#x1F50D <spring:message code="WebController.LongTermForecast.SearchDescription" /></a></div>
		<div style="clear: both"></div>	
	</div>


	<div class="mainInfo">
		<h1><spring:message code="WebController.LongTermForecast.Invitation" /> ${cityName}</h1>
		<h1><spring:message code="WebController.LongTermForecast.CountryCode" /> ${countryCode}</h1>
	</div>

	<table border="1">
		<tr>
			<td><spring:message code="WebController.LongTermForecast.TimeStamp" /></td>
			<td><spring:message code="WebController.LongTermForecast.Temperature" /></td>
			<td><spring:message code="WebController.LongTermForecast.Description" /></td>
			<td><spring:message code="WebController.LongTermForecast.Graphic" /></td>
			<td><spring:message code="WebController.LongTermForecast.Rain" /></td>
			<td><spring:message code="WebController.LongTermForecast.WindSpeed" /></td>
			<td><spring:message code="WebController.LongTermForecast.WindDeg" /></td>
		</tr>
		<c:forEach var="element" items="${tempList}">
			<tr>
				<td> ${element.getTimeStamp()}  </td>
				<td> ${element.getTemp()} &#x2103 </td>
				<td> ${element.getTempAtNight()} &#x2103 </td>				
				<td> ${element.getDescription()} </td>
				<td> <img src=${element.getIcon()} ></td>
				<td> ${element.getRain()} </td>
				<td> ${element.getWindSpeed() } [m/s] </td>
				<td> ${element.getWindDeg() } &deg</td>			
			</tr>
		</c:forEach>
	</table>	

</body>
</html>