<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Arrays" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Ejercicio 4</title>
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		
	</head>
	<body>

		<h1>Adivina si puedes</h1>
		<form id="formJuego" method="post" action="./index.jsp">
			
			<%
			String[] celdas = request.getParameterValues("celdas");
			String celdaSeleccionadaStr = request.getParameter("celdaSeleccionada");
			String opcionSeleccionada =  request.getParameter("opcionNumero");
			String valorSeleccionadoStr =  request.getParameter("respuestaNumero");
			String [] correctos = request.getParameterValues("correctos");
			
			String res = "correct";
			int cantCorrectos = 0;
			
			if(correctos != null){
				for(String correcto : correctos){
					out.println("<input type=\"hidden\" name=\"correctos\" value=\""+correcto+"\">");
				}
				cantCorrectos = correctos.length;
			}

			
			if(opcionSeleccionada!= null){
				int celdaSeleccionada = Integer.parseInt(celdaSeleccionadaStr);
				int valorSeleccionado =  Integer.parseInt(valorSeleccionadoStr);
				if(opcionSeleccionada.equals("mayor")){
					if(Integer.parseInt(celdas[celdaSeleccionada])<valorSeleccionado){
						out.println("<p class=\"message\">Fallaste, vuelve a intentarlo");
						res = "incorrect";
					}else{
						out.println("<input type=\"hidden\" name=\"correctos\" value=\""+celdaSeleccionada+"\">");
						cantCorrectos++;
					}
				}else{
					if(Integer.parseInt(celdas[celdaSeleccionada])>valorSeleccionado){
						out.println("<p class=\"message\">Fallaste, vuelve a intentarlo");
						res = "incorrect";
					}else{
						out.println("<input type=\"hidden\" name=\"correctos\" value=\""+celdaSeleccionada+"\">");
						cantCorrectos++;
					}
				}
			}
			if(cantCorrectos == 3){
				out.println("<p class=\"message\">¡Ganaste!</p>");
			}
			out.println("<table>");
			if(celdas == null || !res.equals("correct")) {
				for(int i = 0; i<3;i++){
					out.println("<tr>");
					for(int j = 0; j<3; j++){
						out.println("<td class=\"optionSelect noSelected\" data-value=\""+(i*3+j)+"\">");
						out.println("<input type=\"hidden\" name=\"celdas\" value=\""+Double.class.cast(Math.random() * 10).intValue()+"\"");
						out.println("<td>");
					}
					out.println("</tr>");
				}
			}else{
				int celdaSeleccionada = Integer.parseInt(celdaSeleccionadaStr);
				for(int i = 0; i<3;i++){
					out.println("<tr>");
					for(int j = 0; j<3; j++){
						int iter = i*3+j;
						if(celdaSeleccionada == iter || (correctos != null && Arrays.asList(correctos).contains( Integer.toString(iter)))){
							out.println("<td class=\"optionSelect correct\" data-value=\""+ iter +"\">");
							out.println("<p>"+celdas[iter]+"</p>");
							out.println("<input type=\"hidden\" name=\"celdas\" value=\""+ celdas[iter] +"\"");
							out.println("<td>");
						}else{
							out.println("<td class=\"optionSelect\" data-value=\""+ iter +"\">");
							out.println("<input type=\"hidden\" name=\"celdas\" value=\""+ celdas[iter] +"\"");
							out.println("<td>");
						}
						
					}
					out.println("</tr>");
				}
			}
			%>
			</table>
			<div class="respuesta">
				<input type="radio" id="mayor" name="opcionNumero" value="mayor">
 				<label for="mayor">Mayor</label>

				<input type="radio" id="menor" name="opcionNumero" value="menor" checked="checked">
				<label for="menor">Menor o igual</label>
				
				<input type="text" id="respuestaNumero" name="respuestaNumero" required>
				<input type="hidden" id="celdaSeleccionada" name="celdaSeleccionada" value="-1"> 
			</div>
			<div class="btnContainer">
				
				<%
				if(cantCorrectos ==3){
					out.println("<a href=\"./\" class=\"btnJugar\">Recomenzar</a>");
				}else{
					out.println("<input id=\"submit\" type=\"submit\" class=\"btnJugar\" value=\"Probar Suerte\">");
				}
				%>
			</div>

				
			
		</form>
		<script src="./js/jquery.min.js"></script>
		<script src="./js/adivina.js"></script>
	</body>
</html>