<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Ejemplo 2</title>
        <link rel="stylesheet" type="text/css" href="./css/style.css"/>
    </head>
    <body>
		<h3>Cereales</h3>
		<c:catch var="exception">
       		<c:import var="cereales" url="/WEB-INF/cereales.xml"/>
			<x:parse var="cer" xml="${cereales}" />
	       	<ol>
	           <x:forEach var="c" select="$cer/cereales/cereal">
	               <li><x:out select="$c" escapeXml="false" /></li>
	           </x:forEach>
	       	</ol>
	       	<h3>Productos faltantes</h3>
	       	<c:import var="stock" url="/WEB-INF/stock.xml"/>
	       	<x:parse var="st" xml="${stock}"/>
	       	<table class="tabla">
	           	<thead>
	            	<tr>
	                    <td align="right">Id.</td>
	                    <td>Nombre</td>
	                </tr>
	           	</thead>
	           	<tbody>
	           	<x:forEach var="s" select="$st/productos/producto">
	            	<x:if select="$s/cant = 0">
	                	<tr>
	                    	<td align="right"><x:out select="$s/id" escapeXml="false" /></td>
	                       	<td><x:out select="$s/nom" escapeXml="false" /></td>
	                   	</tr>
	               	</x:if>
	           	</x:forEach>
	           	</tbody>
	       	</table>
	   	</c:catch>
		<c:if test="${!empty exception}">
			<p>${exception}</p>
	   	</c:if>
       	<br/>       
       	<a href="index.jsp" target="_self">Volver al index principal</a>
    </body>
</html>
