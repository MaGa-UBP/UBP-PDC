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
		<form method="POST" id="prodeForm" action="index.jsp">
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
					String checkedL="", checkedE="", checkedR=""; 
					if(request.getParameter("resultado-"+i) != null){
						String res = request.getParameter("resultado-"+i);
						if(res.equals("izq")){
							checkedL="checked=\"checked\"";
						}else if(res.equals("empate")){
							checkedE="checked=\"checked\"";
						}else if(res.equals("der")){
							checkedR="checked=\"checked\"";
						}
					}
					out.println("<td><input type=\"checkbox\" name=\"resultado-"+i+"\" value=\"izq\" "+checkedL+"></td>");
					out.println("<td><input type=\"checkbox\" name=\"resultado-"+i+"\" value=\"empate\" "+checkedE+"></td>");
					out.println("<td><input type=\"checkbox\" name=\"resultado-"+i+"\" value=\"der\" "+checkedR+"></td>");
					out.println("<td>"+match.get(1)+"</td>");
					out.println("</tr>");
					i++;
				}
				%>
			</table>
			<%
			if(request.getParameter("resultado-0") == null){
				out.println("<input id=\"submit\" type=\"submit\" class=\"btnProde\" value=\"Resultados\">");
			}else{
				out.println("<a href=\"#\" id=\"reset\" class=\"btnProde\">Volver a Jugar</a>");
			}
			 %>
		</form>
	</div>

	 	<%
	 		Random random = new Random();
			if(request.getParameter("resultado-0") != null){
				out.println("<div class=\"colInline\">");
				out.println("<h1>Resultados</h1>");
				out.println("<table>");
				out.println("<tr><th>Equipo</th><th>L</th><th>V</th><th>Equipo</th></tr>");

				List<List<Integer>> resultados = new ArrayList<List<Integer>>();
				i=0;
				int cantCorrectos = 0, cantIncorrectos = 0;
				for(List<String> match : equipos){
					Integer l = random.nextInt(6);
					Integer v = random.nextInt(6);
					
					String scores="";
					if(l>v){
						scores="izq";
					}else if(l<v){
						scores="der";
					}else{
						scores="empate";
					}
					String classRes = "";
					
					if(scores.equals(request.getParameter("resultado-"+i))){
						classRes = "success";
						cantCorrectos++;
					}else{
						classRes = "error";
						cantIncorrectos++;
					}
					out.println("<tr class=\""+ classRes +" filaPartido\">");
					out.println("<td>"+match.get(0)+"</td>");
					out.println("<td>"+l+"</td>");
					out.println("<td>"+v+"</td>");
					out.println("<td>"+match.get(1)+"</td>");
					out.println("</tr>");
					resultados.add(Arrays.asList(l, v));
					i++;
				}
				out.println("</table>");
				out.println("</div>");
				
				out.println("<div class=\"colInline\">");
				out.println("<h1>Estad&iacute;sticas</h1>");
				out.println("<p>Resultados correctos: "+cantCorrectos+"</p>");
				out.println("<p>Resultados incorrectos: "+cantIncorrectos+"</p>");
				out.println("</div>");
			}
			
	 	%>

	<script src="./js/jquery.min.js"></script>
	<script src="./js/validateForm.js"></script>
</body>
</html>