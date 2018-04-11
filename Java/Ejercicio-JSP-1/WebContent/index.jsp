<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ar.edu.ubp.pdc.classes.Juego" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Piedra, Papel o Tijera</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">

</head>
<body>
	
	Loista desplegable --> en submit --> Mando el valor al metodo del objeto java (Juego) y Agrego el valor seleccionado en un input hidden;
	
	Juego.getJuego().jugar(requestGetParameter("opcion"));
	Juego.getJuego().getResultad();-->Devuelve resultado;
	<h3>Te invito a jugar... :)</h3>
	<form id="jugadaForm" method="POST">
		<label>Seleccione una opci&oacute;n:</label>
		<select>
		  <option name="opcion" value="-1"></option>
		  <option name="opcion" value="piedra">Piedra</option>
		  <option name="opcion" value="papel">Papel</option>
		  <option name="opcion" value="tijera">Tijera</option>
		</select>
		<input id="submit" type="submit" name="submit" value="Jugar" class="btnJugar">
	</form>
<!-- 	<h3>Resultados</h3>
	<table class="resultados">
		<tr class="header">
			<th>Usuario</th>
			<th>Computadora</th>
			<th>Resultado</th>
		</tr>
		<tr class="gano">
			<td>Prueba</td>
			<td>Prueba</td>
			<td>Prueba</td>
		</tr>
		<tr class="perdio">
			<td>Prueba</td>
			<td>Prueba</td>
			<td>Prueba</td>
		</tr>
		<tr class="empato">
			<td>Prueba</td>
			<td>Prueba</td>
			<td>Prueba</td>
		</tr>
	</table>
	<div class="mensaje">
		<p>Perdiste :(</p>
		<a href="./" class="btnJugar">Volver a jugar</a>
	</div> -->
	
	<script src="./js/jquery.min.js"></script>
	<script src="./js/validateForm.js"></script>
</body>
</html>