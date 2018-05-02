<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ejemplo 4</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
	<table>
		<colgroup>
			<col width="20%">
			<col width="40%">
		</colgroup>
	    <thead>
	        <tr>
	            <td colspan="2">Datos Personales</td>
	        </tr>
	    </thead>
	    <tbody>
	        <tr>
	            <th align="right">Apellido:</th>
	            <td>${param.apellido}</td>
	        </tr>
	        <tr>
	            <th align="right">Nombre:</th>
	            <td>${param.nombre}</td>
	        </tr>
	        <tr>
	            <th align="right">Sexo:</th>
	            <td>${(empty param.sexo ? "No Informado" : (param.sexo eq "F" ? "Femenino" : "Masculino"))}</td>
	        </tr>
	    </tbody>
	</table>            
    <br/>
    <a href="ejemplo4.jsp" target="_self">Volver</a>
</body>
</html>