<%@page import="ar.edu.ubp.das.ws.CategoriaBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Programas academicos</title>
	<link rel="stylesheet" type="text/css" href="./css/styles.css"/>
	<script type="text/javascript" src="./js/jquery.js"></script>
	<script type="text/javascript" src="./js/utils.js"></script>
	<script type="text/javascript" src="./js/script.js"></script>
</head>
<body>
	<h3>Categorias de programa academico</h3>
	<div id="main">
		<form id="form" action="javascript:void(null)" method="post" onsubmit="javascript:void(null)">
		 	<table>
		 	<tr><th>Cod. categoria</th><th>Desc categoria</th><th>Accion</th></tr>
			<c:forEach var="cat" items="${requestScope.categorias}">
			
				<tr>
					<td>${cat.codCategoria}</td>
					<td>${cat.descCategoria}</td>
					<td><a href="#" id="${cat.codCategoria}" onclick="jProgAc.borrar(this)">Eliminar</a></td>
				</tr>
			</c:forEach> 
			<tr>
			<td><input type=text placeholder="Ingrese cod. de la categoria" name="cod_categoria" maxlength="10" size="10"/>
			<td><input type=text placeholder="Ingrese desc. de la categoria" name="desc_categoria"/>
			<td><a href="#" onclick="jProgAc.insertar()">Agregar</a></td>
			</tr>
			</table>
			<br/>
			
			
			
		</form>
	</div>
	<div id="error"></div>
</body>
</html>