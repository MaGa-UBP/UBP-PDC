<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.LinkedList,ar.edu.ubp.pdc.beans.CarreraBean"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" />
	<meta charset=ISO-8859-1 />
	<title>Listado de Alumnos</title>            
	<link type="text/css" rel="stylesheet" href="./css/style.css" />
	<script type="text/javascript" src="./js/jquery.js"></script>
	<script type="text/javascript" src="./js/utils.js"></script>
	<script type="text/javascript" src="./js/alumnos.js"></script>
</head>
<body>
<h3>Alumnos por carrera</h3>
<%
@SuppressWarnings("unchecked")
LinkedList<CarreraBean> carreras = (LinkedList<CarreraBean>)request.getAttribute("carreras");
%>
    <div id="message"></div>
	<form id="form" action="index.jsp" method="post">
		<table>
			<colgroup>
				<col width="50px"/>
				<col width="470px"/>
			</colgroup>	
			<tbody>
			<tr>
				<th align="right">Carrera:</th>
			<td>
				<select name="nro_carrera" onchange="jAlumnos.getAlumnos()">
				<% 
	            for(CarreraBean carrera : carreras) {
					out.println("<option value=\"" + carrera.getNroCarrera() + "\">" + carrera.getCarrera() + "</option>");
	            }	
				%>
				</select>
			</td>
			</tbody>
		</table>
	</form>
	<div id="result"></div>
	<script type="text/javascript">
	jAlumnos.getAlumnos()
	</script>
</body>
</html>