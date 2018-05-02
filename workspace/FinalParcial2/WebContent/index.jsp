<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="/WEB-INF/tld/customs.tld" prefix="ct" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Final Parcial 2</title>
		<meta name="author" content="Cenzano">
		<link rel="stylesheet" type="text/css" href="./css/style.css"/>
	    <script type="text/javascript" src="./js/jquery.js"></script>
	    <script type="text/javascript" src="./js/utils.js"></script>
	    <script type="text/javascript" src="./js/main.js"></script>
	</head>
<body>

	<h1>Preferencias</h1>
	
	<ct:parserXml name="tipo" func = "jPreferencias.read()" />
	
	<div id="resultados"></div>
	<div id="message"></div>
	
	

</body>
</html>