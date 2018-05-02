<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true" import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title>Ejemplo 7</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
	<div id="error">
		<h3>Error</h3>
		<p><%= exception.toString() %></p>
		<a href="./index.html">Volver al index principal</a>
	</div>	
</body>
</html>