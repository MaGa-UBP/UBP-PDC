<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ar.edu.ubp.pdc.classes.Juego, java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Piedra, Papel o Tijera</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">

</head>
<body>
<%
	HashMap<Integer, String> mapResultados;
	mapResultados = new HashMap<Integer,String>();
	mapResultados.put(-1, "perdiste");
	mapResultados.put(0, "empataste");
	mapResultados.put(1, "ganaste");
	
	HashMap<String, String> mapOpciones;
	mapOpciones = new HashMap<String,String>();
	mapOpciones.put("0", "Piedra");
	mapOpciones.put("1", "Papel");
	mapOpciones.put("2", "Tijera");
	
	
	Integer pGanadas = 0;
	Integer pPerdidas = 0;
	
	if(request.getParameter("pGanadas") != null){
		pGanadas = Integer.parseInt(request.getParameter("pGanadas"));
	}
	
	if(request.getParameter("pPerdidas") != null){
		pPerdidas = Integer.parseInt(request.getParameter("pPerdidas"));
	}
	
	if(request.getParameterValues("opcion") != null){
		String opcion = request.getParameter("opcion");
		Juego.getJuego().jugar(Integer.parseInt(opcion));
		if(Juego.getJuego().getResultado() == 1){
			pGanadas++;
		}else if(Juego.getJuego().getResultado() == -1){
			pPerdidas++;
		}
	}
	String arrJugador[] = request.getParameterValues("jugador");
	String arrComputadora[] = request.getParameterValues("computadora");
	String arrResultados[] = request.getParameterValues("resultado");
	String jugadas = request.getParameter("jugadas");
	
%>
	<h3>Te invito a jugar... :)</h3>
	<% if(pGanadas !=3 && pPerdidas !=3){ %>
		<form id="jugadaForm" method="POST" action="index.jsp">
			<label id="selectLbl">Seleccione una opci&oacute;n:</label>
			<select name="opcion" required>
			  <option value="-1" selected="selected"></option>
			  <option value="0">Piedra</option>
			  <option value="1">Papel</option>
			  <option value="2">Tijera</option>
			</select>
			<input id="submit" type="submit" class="btnJugar" value="Jugar">
			<%
			out.println("<input type=\"hidden\" name=\"pGanadas\" value=\""+pGanadas+"\">");
			out.println("<input type=\"hidden\" name=\"pPerdidas\" value=\""+pPerdidas+"\">");
			if(jugadas != null){
				//INPUT CON CONCATENACION

			}
			if(arrJugador != null){
				for(int i=0; i<arrJugador.length; i++){
					
					out.println("<input type=\"hidden\" name=\"jugador\" value=\""+arrJugador[i]+"\">");
					out.println("<input type=\"hidden\" name=\"computadora\" value=\""+arrComputadora[i]+"\">");
					out.println("<input type=\"hidden\" name=\"resultado\" value=\""+arrResultados[i]+"\">");
				}
			}
			if(request.getParameter("opcion") != null){
				String res = mapResultados.get(Juego.getJuego().getResultado());
				out.println("<input type=\"hidden\" name=\"jugador\" value=\""+Juego.getJuego().getEleccionUsuario()+"\">");
				out.println("<input type=\"hidden\" name=\"computadora\" value=\""+Juego.getJuego().getEleccionDispositivo()+"\">");
				out.println("<input type=\"hidden\" name=\"resultado\" value=\""+res+"\">");
			}
			%>
			<div id="errorSelect" class="hide">
				<p>Debe seleccionar una opci&oacute;n</p>
			</div>
		</form> 
	<% } 
	
	if(request.getParameter("opcion") != null){
		out.println("<h3>Resultados</h3>");
		out.println("<table class=\"resultados\"><tr class=\"header\"><th>Usuario</th><th>Computadora</th><th>Resultado</th></tr>");
		//Muestro los anteriores
		if(arrJugador != null){
			for(int i=0; i<arrJugador.length; i++){
				out.println("<tr class="+arrResultados[i]+"><td>"+arrJugador[i]+"</td><td>"+arrComputadora[i]+"</td><td class=\"resultados\">"+arrResultados[i]+"</td></tr>");	
			}
		}
		//Muestro el actual seleccionado
		String res = mapResultados.get(Juego.getJuego().getResultado());
		out.println("<tr class="+res+"><td>"+Juego.getJuego().getEleccionUsuario()+"</td><td>"+Juego.getJuego().getEleccionDispositivo()+"</td><td class=\"resultados\">"+res+"</td></tr>");
		out.println("</table>");
	}
	
	if(pGanadas ==3 ){
		out.println("<div class=\"mensaje\">");
		out.println("<p>Felicitaciones, ganaste! :D</p>");
		out.println("<a href=\"#\" id=\"volverJugar\" class=\"btnJugar\">Volver a jugar</a>");
		out.println("</div>");
	}else if (pPerdidas == 3){
		out.println("<div class=\"mensaje\">");
		out.println("<p>Perdiste :(</p>");
		out.println("<a href=\"#\" id=\"volverJugar\" class=\"btnJugar\">Volver a jugar</a>");
		out.println("</div>");
	}
	%>
	
	<script src="./js/jquery.min.js"></script>
	<script src="./js/validateForm.js"></script>
</body>
</html>