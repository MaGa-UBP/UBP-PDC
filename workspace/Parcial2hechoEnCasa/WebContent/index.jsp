<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link type="text/css" rel="stylesheet" href="./css/style.css" />
   	<script type="text/javascript" src="./js/jquery.js"></script>
   	<script type="text/javascript" src="./js/utils.js"></script>
   	<script type="text/javascript" src="./js/JSugerencias.js"></script>
<title>Parcial 2 - Sugerencias</title>
</head>
<body>
<div id="aux"></div>
<div id="response"></div>
<form id="form" action="javascript:void(null)" method="post">
	<h3>Nueva Sugerencia</h3>
	<label>Desea identificarse?</label>
	<input type="radio" name="identifica" value="Si" id="iidentificaS" checked="checked" /><label for="iidentificaS">Si</label>
	<input type="radio" name="identifica" value="No" id="iidentificaN" /><label for="iidentificaN">No</label>
	<br/><br/>

	<div id="divemail">
	<%
	String mail = "";
	Cookie cookies[] = request.getCookies();
	if(cookies !=null){
	for(int i = 0; i < cookies.length; i++) {
		if(cookies[i].getName().equals("mail")) {
			mail = cookies[i].getValue();
			break;
		}
	}}
	%>	
	
		<label>E-mail</label><br/>
		<input type="text" name="email" id="iemail" size="40" value="<%= mail %>"/>
	</div>
	<br/>
	<label>Servicio</label><br/>
	<select id="iservicio" name="servicio" onchange="jSugerencias.buscarTemas(this)">
		<option value="" disabled selected>Seleccione un servicio</option>
		<option value="NP">Carreras a distancia</option>
		<option value="PR">Carreras presenciales</option>
		<option value="ISG">Infraestructura y servicios generales</option>
		<option value="OT">Otros</option>
	</select>
	<br/><br/>
	<div id="divtemas"></div>
	<br/>
	<textarea cols="80" rows="10" id="isugerencias" name="sugerencias"></textarea>
	<br/><br/>
	<input type="button" id="guardar" value="Guardar" onclick="jSugerencias.guardar()">
	<input type="button" id="cancelar" value="Cancelar" onclick="jSugerencias.cancelar()">
</form>
</body>
</html>