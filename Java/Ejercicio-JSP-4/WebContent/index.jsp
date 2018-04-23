<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<table>
			<%
			String[] celdas = request.getParameterValues("celdas");
			String celdaSeleccionada = request.getParameter("celdaSeleccionada");
			
			if(celdas != null) {
				for(int i = 0; i<3;i++){
					out.println("<tr>");
					for(int j = 0; j<3; j++){
						int iter = i*3+j;
						if(celdaSeleccionada.equals(Integer.toString(iter))){
							
						}else{
							out.println("<td class=\"optionSelect\" data-value=\""+ iter +"\">");
							out.println("<input type=\"hidden\" name=\"celdas\" value=\""+ celdas[iter] +"\"");
							out.println("<td>");
						}
						
					}
					out.println("</tr>");
				}
			}else{
				for(int i = 0; i<3;i++){
					out.println("<tr>");
					for(int j = 0; j<3; j++){
						out.println("<td class=\"optionSelect noSelected\" data-value=\""+(i*3+j)+"\">");
						out.println("<input type=\"hidden\" name=\"celdas\" value=\""+Double.class.cast(Math.random() * 10).intValue()+"\"");
						out.println("<td>");
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
				<input id="submit" type="submit" class="btnJugar" value="Probar Suerte">
			</div>

				
			
		</form>
		<script src="./js/jquery.min.js"></script>
		<script src="./js/adivina.js"></script>
	</body>
</html>