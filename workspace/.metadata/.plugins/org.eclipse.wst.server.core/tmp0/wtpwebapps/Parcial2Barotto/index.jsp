<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="./js/jquery.js"></script>
<script src="./js/utils.js"></script>
<script src="./js/script.js"></script>
<link rel="stylesheet" type="text/css" href="./css/main.css"/>
<title>Buzon de sugerencias</title>
</head>
<body>
<h2>Nueva sugerencia</h2>
<div id="div-main">
<form action="javascript:void(null)">
<label>¿Desea identificarse?</label>
<input type="radio" id="rb-id-s" name="rb-id" value="S" checked/> <label for="rb-id-s">Si</label>
<input type="radio" id="rb-id-n" name="rb-id" value="N"/><label for="rb-id-n">No</label>
<br/><br/>
<div id ="div-email">
<label for="txt-email" >E-mail</label>
<br/>
<input type ="text" id="txt-email" name="txt-email" value="<%
		try{
			out.println(request.getCookies()[1].getValue());
		}catch(Exception e){out.println("");}%>"/>
<br/>									
</div>
<label for="sel-serv">Servicio</label>
<br/>
<select id="sel-serv" name="sel-serv">
<option value="" selected disabled>Seleccione un servicio</option> 
<option value="NP">Carreras a distancia</option>
<option value="PR">Carreras presenciales</option>
<option value="ISG">Infraestructura y servicios generales</option>
<option value="OT">Otros</option>
</select>
<div id="div-temas"></div>
<br/><br/>
<textarea id="txta-sugg" name="txta-sugg" rows="10" cols="50"></textarea>
<br/>
<button id="but-save">Guardar</button>
<input type="reset" value="Cancelar">
</form>
</div>
<div id="div-message"></div>
<div id="div-error"></div>


</body>
</html>