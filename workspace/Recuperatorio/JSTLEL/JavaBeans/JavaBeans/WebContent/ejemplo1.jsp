<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Ejemplo 1</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
    <h2>Contador</h2>
    <jsp:useBean id="cont" class="ar.edu.ubp.das.beans.ContadorBean" scope="session"/>
    <jsp:setProperty name="cont" property="contador" value="1"/>
    <h4><b>Contador (JSP)</b>: <jsp:getProperty name="cont" property="contador"/></h4>
    <h4><b>Contador (EL)</b>: ${cont.contador}</h4>
    <a href="ejemplo1.jsp" target="_self">Volver a cargar</a>&nbsp;&nbsp;&nbsp;<a href="index.jsp" target="_self">Volver al index principal</a>
</body>
</html>
