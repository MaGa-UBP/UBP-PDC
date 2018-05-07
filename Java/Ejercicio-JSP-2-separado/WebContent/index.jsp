<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Prode</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<%
		List<List<String>> equipos = new ArrayList<List<String>>();
		if(equipos.size() == 0) {
			equipos.add(Arrays.asList("EQUIPO A", "EQUIPO B"));
			equipos.add(Arrays.asList("EQUIPO C", "EQUIPO D"));
			equipos.add(Arrays.asList("EQUIPO E", "EQUIPO F"));
			equipos.add(Arrays.asList("EQUIPO G", "EQUIPO H"));
			equipos.add(Arrays.asList("EQUIPO I", "EQUIPO J"));
			equipos.add(Arrays.asList("EQUIPO K", "EQUIPO L"));
			equipos.add(Arrays.asList("EQUIPO M", "EQUIPO N"));
			equipos.add(Arrays.asList("EQUIPO O", "EQUIPO P"));
			equipos.add(Arrays.asList("EQUIPO Q", "EQUIPO R"));
			equipos.add(Arrays.asList("EQUIPO S", "EQUIPO T"));
		}
	%>
	<div class="colInline">
		<h1>Prode</h1>
		<form method="POST" id="prodeForm" action="resultado.jsp">
			<table>
				<tr>
					<th>Equipo</th>
					<th>L</th>
					<th>E</th>
					<th>V</th>
					<th>Equipo</th>
				</tr>
				<%
				int i = 0;
				
				for(List<String> match : equipos){
					out.println("<tr class=\"filaPartido\">");
					out.println("<td>"+match.get(0)+"</td>");
					out.println("<td><input type=\"checkbox\" name=\"resultados\" value=\"izq\"></td>");
					out.println("<td><input type=\"checkbox\" name=\"resultados\" value=\"empate\"></td>");
					out.println("<td><input type=\"checkbox\" name=\"resultados\" value=\"der\"></td>");
					out.println("<td>"+match.get(1)+"</td>");
					out.println("</tr>");
					i++;
				}
				%>
			</table>
			<input id="submit" type="submit" class="btnProde" value="Resultados">
			<a href="#" id="reset" class="btnProde hidden">Volver a Jugar</a>
		</form>
	</div>
	<div class="colInline" id="results"></div>
	

	<script src="./js/jquery.min.js"></script>
	<script src="./js/validateForm.js"></script>
</body>
</html>