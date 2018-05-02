<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="/WEB-INF/tlds/myELFunctions.tld" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ejemplo 3</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
	<h2>Iteradores</h2>
	<h3>c:forEach</h3>
	<form  action="ejemplo3.jsp" method="post">
	    <c:forEach var="i" begin="0" end="7">
	        <c:set var="lista" value="${lista}${fn:toAsciiToChar(i + 65)};"/>
	        <input type="checkbox" id="libro${i}" name="libro" value="Libro ${fn:toAsciiToChar(i + 65)}"/><label for="libro${i}">Libro ${fn:toAsciiToChar(i + 65)}</label><br/>
	    </c:forEach>
	    <br/>
	    <input type="submit" value="Mostrar selecci&oacute;n"/>
	</form>
	<c:set var="libros" value="${paramValues.libro}"/>
	<c:if test="${!empty libros}">
	    <h4>Los libros seleccionados son:</h4>
	    <ol>
	    <c:forEach var="l" items="${libros}" varStatus="data">
	        <li>${l} (${data.first};${data.current};${data.index};${data.last})</li>
	    </c:forEach>
	    </ol>
	</c:if>
	<h1>Lista de valores: ${lista}</h1>
	<h3>c:forTokens</h3>
	<ul>
	<c:forTokens items="${lista}" delims=";" var="i" begin="1" end="5" step="2">
	    <li>${i}</li>
	</c:forTokens>
	</ul>
    <a href="index.jsp" target="_self">Volver al index principal</a>        
</body>
</html>