<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ejemplo 3</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
	<h2>Internacionalizaci&oacute;n</h2>
	<fmt:setLocale value="en_US" />
	<fmt:setBundle basename="ar.edu.ubp.das.properties.misMensajes" var="etq" />
	<h4>
	    <fmt:message key="saludo" bundle="${etq}">
	        <fmt:param value="Mariela" />
	        <fmt:param value="Pastarini" />
	    </fmt:message>
	    <fmt:message key="mensaje" bundle="${etq}" />
	</h4>
	<fmt:setLocale value="es_AR" />
	<fmt:bundle basename="ar.edu.ubp.das.properties.misMensajes">
	    <h4>
	        <fmt:message key="saludo">
	            <fmt:param value="Mariela" />
		        <fmt:param value="Pastarini" />
	        </fmt:message>
	        <fmt:message key="mensaje" />
	    </h4>
	</fmt:bundle>
	<fmt:setLocale value="de_DE" />
	<fmt:bundle basename="ar.edu.ubp.das.properties.misMensajes">
	    <h4>
	        <fmt:message key="saludo">
	            <fmt:param value="Mariela" />
	        </fmt:message>
	        <fmt:message key="mensaje" />
	    </h4>
	</fmt:bundle>
	<br/>
    <a href="index.jsp" target="_self">Volver al index principal</a>
</body>
</html>