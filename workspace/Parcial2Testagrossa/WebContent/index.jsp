<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/tld/customs.tld" prefix="ct" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html">
	<meta charset="ISO-8859-1">
	<meta name="description" content="JSP">
	<meta name="author" content="Testagrossa Franco">
	<title>JSP</title>
	<link rel="stylesheet" type="text/css" href="./css/style.css"/>
    <script type="text/javascript" src="./js/jquery.js"></script>
    <script type="text/javascript" src="./js/utils.js"></script>
    <script type="text/javascript" src="./js/main.js"></script>
</head>
<body>
	<h1><b>Preferencias</b></h1>
	
			
	<ct:leerXML nombre="lista" funcion="jParcial.seleccion();"/>
	
	<div id='iresult'></div>		
	<div id='message'></div>
	

</body>
</html>
