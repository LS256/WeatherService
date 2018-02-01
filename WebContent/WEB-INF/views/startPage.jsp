<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>

    
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
	</style>
	
</head>

<body>
	<form:form method="POST" action="weatherForecast" accept-charset="UTF-8">
		<input type="text" name="cityNameInput" value="Lodz">
		<input type="submit" value="Search">
	</form:form>


</body>
</html>