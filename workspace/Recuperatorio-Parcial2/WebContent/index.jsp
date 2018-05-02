<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/tld/customs.tld" prefix="ct" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recuperatorio Parcial 2</title>
   	<link type="text/css" rel="stylesheet" href="./css/style.css" />
   	<script type="text/javascript" src="./js/jquery.js"></script>
   	<script type="text/javascript" src="./js/utils.js"></script>
   	<script type="text/javascript" src="./js/main.js"></script>
</head>
<body>

<form id="form" action="javascript:void(null)" method="post">
	<label>Procesos:</label><br/>
	<ct:procesos nombre="proceso" funcion="jRecu.buscar(this)"/><br/>

	<div id="divtareas"></div>
	<div id="error"></div>

	<div id="divbotones">
	<br/>
		<input type="button" name="guardar" value="Guardar" onclick="jRecu.guardar()"/>
		<input type="button" name="cancelar" value="Cancelar" onclick="jRecu.cancelar()"/>
	</div>
</form>
</body>
</html>