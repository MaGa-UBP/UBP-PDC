<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ejemplo 1</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
	<c:catch var="exception">
    	<c:import var="rssFeed" url="https://news.google.com.ar/?output=rss" charEncoding="UTF-8"/>
       	<x:parse var="r" xml="${rssFeed}"/>
       	<h1>
        	<x:out select="$r/rss/channel/title" />
       	</h1>
       	<x:forEach select="$r/rss/channel/item">
      		<x:out select="description" escapeXml="false"/>
       	</x:forEach>
	</c:catch>
	<c:if test="${!empty exception}">
		<p>${exception}</p>
	</c:if>
	<br/>
	<a href="index.jsp" target="_self">Volver al index principal</a>
</body>
</html>