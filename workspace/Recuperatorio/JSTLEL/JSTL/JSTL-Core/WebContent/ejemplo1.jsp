<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ejemplo 1</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
	<h2>Variables</h2>
	<h3>c:out</h3>
	<p><c:out value="¡Hola Mundo!! :)"/></p>
	<p><c:out value="${producto.id}" default="Sin definir"/></p>
	<p>
	    <c:out value="${param.nombre}"> 
	    No informado
	    </c:out>
	</p>
	<p><c:out value="<b>Texto en negrita</b>" default="Sin valor" escapeXml="false"/></p>
	<p><c:out value="<b>Texto en negrita</b>" default="Sin valor" escapeXml="true"/></p>
	<h3>c:set</h3>
	<c:set var="browser" value="${header['User-Agent']}" scope="session" />
	<p><b>Navegador usado</b>: <c:out value="${browser}"/></p>
	<c:set var="sessionid" scope="session">
	  <c:out value="${cookie['JSESSIONID'].value}" default="---"/>
	</c:set>            
	<p><b>Identificador de Sesi&oacute;n</b>: ${sessionid}</p>
	<c:set var="variable" value="Valor 1" scope="page"/>
	<c:set var="variable" value="Valor 2" scope="request"/>
	<p><b>Variable (pageScope)</b>: ${pageScope.variable}</p>
	<p><b>Variable (requestScope)</b>: ${requestScope.variable}</p>
	<c:remove var="variable" scope="page"/>
	<p><b>Variable removida (pageScope)</b></p>
	<p><b>Variable (pageScope)</b>: <c:out value="${pageScope.variable}" default="Ya no existe"/></p>
	<p><b>Variable (requestScope)</b>: ${requestScope.variable}</p>        
	<br/>
    <a href="index.jsp" target="_self">Volver al index principal</a>        
</body>
</html>