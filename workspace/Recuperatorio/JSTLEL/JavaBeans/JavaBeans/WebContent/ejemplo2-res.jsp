<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Ejemplo 2</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
	<jsp:useBean id="per" class="ar.edu.ubp.das.beans.PersonaBean" scope="request">
	    <jsp:setProperty name="per" property="apellido" param="ape"/>
	    <jsp:setProperty name="per" property="nombre" param="nom"/>
	</jsp:useBean>
	<h2>Par&aacute;metros Recibidos</h2>
	<h3>Directivas JSP</h3>
	<p><b>Apellido</b>: <jsp:getProperty name="per" property="apellido"/></p>
	<p><b>Nombre</b>: <jsp:getProperty name="per" property="nombre"/></p>
	<p><b>Nombre Completo</b>: <jsp:getProperty name="per" property="nombreCompleto" /></p>
	<h3>Scriptlets</h3>
	<p><b>Apellido</b>: <%= per.getApellido() %></p>
	<p><b>Nombre</b>: <%= per.getNombre() %></p>
	<p><b>Nombre Completo</b>: <%= per.getNombreCompleto() %></p>
	<h3>EL</h3>
	<p><b>Apellido</b>: ${per.apellido}</p>
	<p><b>Nombre</b>: ${per.nombre}</p>
	<p><b>Nombre Completo</b>: ${per.nombreCompleto}</p>
    <a href="ejemplo2.jsp" target="_self">Volver</a>
</body>
</html>