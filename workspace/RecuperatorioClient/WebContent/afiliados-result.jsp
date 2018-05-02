<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<script type="text/javascript" src="./js/jquery.js"></script>
	<script type="text/javascript" src="./js/utils.js"></script>
	<script type="text/javascript" src="./js/lista.js" charset="UTF-8"></script>
	<table>
	<thead>
		<td>nombre</td>
		<td>apellido</td>
		<td>cod_tipo_documento</td>
		<td>nro_documento</td>
		<td>nro_afiliado</td>
		<td>baja</td>
	</thead>
		<c:forEach var="f" items="${requestScope.afiliados}" varStatus="s">
		<tr>
				<td>${f.nombre}</td>
				<td>${f.apellido}</td>
				<td>${f.cod_tipo_documento}</td>
				<td>${f.nro_documento}</td>
				<td>${f.nro_afiliado}</td>
				<td><input type="checkbox" ${f.baja == "S" ? "checked" : ""}></td>
				
		</tr>
	
	</c:forEach>
	</table>
	

