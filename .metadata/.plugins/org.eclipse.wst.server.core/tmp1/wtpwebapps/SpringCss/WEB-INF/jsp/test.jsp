<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="/resources/css/test.css"> -->
<script type="text/javascript" src="<c:url value="/resources/js/test.js"/>"></script>
<spring:url value="/resources/css/test.css" var="testCss"></spring:url>
<link href="${testCss}" rel="stylesheet">
</head>
<body>
	<button onclick="fun()">Click</button>
</body>
</html>