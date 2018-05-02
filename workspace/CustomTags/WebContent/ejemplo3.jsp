<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/tld/customs.tld" prefix="ct" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Ejemplo 3</title>
	<link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
	<h3>Agenda</h3>
	<h4>Mostrar en formato tabla</h4>
	<table>
	    <colgroup>
	        <col width="250px">
	        <col width="50px">
	        <col width="50px">
	        <col width="250px">
	    </colgroup>
	    <thead>
	        <tr>
	            <th align="left">Tarea</th>
	            <th>Fecha</th>
	            <th>Prioridad</th>
	            <th align="left">Responsable</th>
	        </tr>
	    </thead>
	    <tbody>
	        <ct:agenda>
	            <tr>
	                <td><%= tarea %></td>
	                <td align="center"><nobr><%= fecha %></nobr></td>
	                <td><%= prioridad %></td>
	                <td><%= responsable %></td>
	            </tr>                    
	        </ct:agenda>
	    </tbody>
	</table>        
	<h4>Mostrar en formato lista</h4>
    <ol>
	    <ct:agenda>
	        <li>
	            <%= fecha + ". " + tarea + " (" + prioridad +") " + (responsable.equals("") ? "" : " - " + responsable) %>
	        </li>                    
	    </ct:agenda>
	</ol>
	<br/>
	<a href="./index.html">Volver al index principal</a>
</body>
</html>