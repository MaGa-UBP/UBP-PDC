<%@page import="sun.util.locale.ParseStatus"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html">
	<meta charset="ISO-8859-1">
	<title>Estrellas</title>

	<link rel="stylesheet" type="text/css" href="./css/style.css"/>
	<script type="text/javascript" src="./js/jquery.js"></script>
	<script type="text/javascript" src="./js/estrellas.js"></script>
</head>
<body>
	<form id="form" action="index.jsp" method="post">
		<div id="prode" align="center">
			<h1>Busca tus 3 estrellas</h1>
			<table id="tabla">
				<colgroup>
				<%
				for(int i = 1; i <= 3; i ++) {
		    		out.println("<col width=\"50px\"/>");
				}
				%>
				</colgroup>
				<%
				int aciertos = 0;
				ArrayList<String> sorteados = new ArrayList<String>();
				ArrayList<String> seleccionados = new ArrayList<String>();
				if(request.getParameterMap().size() != 0) {
					
					for(int i = 0; i < 2; i++) {
						int alea = (int) (Math.random()*12);
						if (i==0){
							sorteados.add(i, String.valueOf(alea));
						}
						do{
							alea = (int) (Math.random()*12);
						}
						while(sorteados.contains(String.valueOf(alea)));
						sorteados.add(i, String.valueOf(alea));
						
						
					}

					for(int i=0;i<12;i++){
						String name = String.valueOf(i);
						seleccionados.add(request.getParameter(name));
						//out.println(seleccionados.get(i));
					}
					for(int i = 0; i < 3; i++) {
						if(seleccionados.contains(sorteados.get(i))){
							aciertos++;								
						}
					}
				}	

				
					int n=0;
					
					for(int i = 1; i <= 4; i ++) {
		    			out.println("<tr>");
		    			for(int j = 1; j <= 3; j ++) {
		    				
		    				if (sorteados.contains(String.valueOf(n))){
		    					out.println("<td> <img src=\"./resources/verde.png\" id=\"imagen"+n+"\" name=\"imagen\" alt=\"azul\"/> <input type=\"hidden\" class=\"casilla\" name="+n+" value =\"\" id="+n+" /></td>");
		    				}
		    				else if(seleccionados.contains(String.valueOf(n))){
			        			out.println("<td> <img src=\"./resources/rojo.png\" id=\"imagen"+n+"\" name=\"imagen\" alt=\"azul\"/> <input type=\"hidden\" class=\"casilla\" name="+n+" value =\"\" id="+n+" /></td>");
			    				
		    				}
		    				else{
		    				out.println("<td> <img src=\"./resources/azul.png\" id=\"imagen"+n+"\" name=\"imagen\" alt=\"azul\"/> <input type=\"hidden\" class=\"casilla\" name="+n+" value =\"\" id="+n+" /></td>");
		    				}
		    				n++;
		    			}
		    			out.println("</tr>");
					}

					//sorteados.clear();
					
					//seleccionados.clear();	
						
					
				
				%>
				<%--out.println("<script>jEstrellas.sorteadas("+sorteados.get(1)+")</script>"); --%>
			</table>
			
			
		</div>
		<% if(request.getParameterMap().size() == 0) { %>
		<div id="botones" align="center">
			<br/><br/>
			<input type="button" name="jugar" value="Probar suerte"/>
		</div>
		<% 
		aciertos=0;
		}
		else { 
			out.println("aciertos= "+aciertos); 
			//aciertos=3;
			if (aciertos==3){
				out.println("<div id=\"ganador\" align=\"center\">GANASTE!</div>");
			}
			
			
		%>
		
	
		<div id="botones" align="center">
			<br/><br/>
			<input type="button" name="volver" value="Volver a Jugar"/>
		</div>
		<% } %>	
	</form>
</body>
</html>