<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ejemplo 4</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
	<h2>Construcci&oacute;n de URL</h2>
	<c:url var="url" value="ejemplo4-res.jsp">
	    <c:param name="apellido">PASTARINI</c:param>
	    <c:param name="nombre">MARIELA</c:param>
	    <c:param name="sexo">F</c:param>
	</c:url>            
	<a href="${url}" target="_self">Ir a p&aacute;gina de ejemplo</a>
	<br/>
	<%--Al descomentar redireccionará a la página informada--%>
	<%--<c:redirect url="http://mi.ubp.edu.ar"/>--%>
	<br/>
	<a href="index.jsp" target="_self">Volver al index principal</a>        
</body>
</html>