<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" />
	<title>Weather forecast service</title>
	
	<style>
		body { background-color: #efefef; }
		table { margin: auto; border-collapse: collapse;}
		table, th, td { border: 1px solid #000000; text-align: center; }
		.mainInfo { text-align: center; border: 1px dashed #000000; width: 60%; margin: auto; }
		
	</style>
	
</head>

<body>
	<div class="mainInfo">
		<h1>Weather forecast for ${cityName}</h1>
		<h1>Country code ${countryCode}</h1>
	</div>

	<table border="1">
		<tr>
			<td>TimeStamp</td>
			<td>Temperatura</td>
			<td>Description</td>
			<td>Graphic</td>
			<td>WindSpeed</td>
			<td>WindDeg</td>
		</tr>
		<c:forEach var="element" items="${tempList}">
			<tr>
				<td> ${element.getTimeStamp()}  </td>
				<td> ${element.getTemp()} &#x2103 </td>
				<td> ${element.getDescription()} </td>
				<td> <img src=${element.getIcon()} ></td>
				<td> ${element.getWindSpeed() } [m/s] </td>
				<td> ${element.getWindDeg() } &deg</td>			
			</tr>
		</c:forEach>
	</table>	

</body>
</html>