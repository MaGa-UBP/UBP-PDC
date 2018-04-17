<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Arrays"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Quini 6</title>
		<link rel="stylesheet" type="text/css" href="./css/style.css">
	</head>
	<body>

		<h1>Quini 6</h1>
		<form id="formQuini" method="post" action="index.jsp">
		
			<%

				String start = request.getParameter("start");
				int cantBolillas = 0;
				int nuevaBolilla = 0;
				
				if(start != null){
					String[] bolillas = new String[6];
					String arrBolillas[] = request.getParameterValues("bolillas");
					
					if(arrBolillas != null){
						int i=0;
						for(String bolilla : arrBolillas){
							bolillas[i]=bolilla;
							i++;
						}
						cantBolillas = arrBolillas.length;
						out.println("<table class=\"quini\"><tr>");
						for(String bolilla : arrBolillas){
							out.println("<td>" + bolilla + "</td>");
							out.println("<input type=\"hidden\" name=\"bolillas\" value=\""+bolilla+"\">");
						}	
						out.println("</tr></table>");
					}
					cantBolillas++;
					if(cantBolillas < 6){
						nuevaBolilla = Double.class.cast(Math.random() * 45).intValue();
						while(Arrays.asList(bolillas).contains(Integer.toString(nuevaBolilla))){
							nuevaBolilla = Double.class.cast(Math.random() * 45).intValue();
						}	 
					}
					
					out.println("<input type=\"hidden\" name=\"bolillas\" value=\""+nuevaBolilla+"\">");
					
				}
				
				
				if(cantBolillas==0){
					out.println("<input id=\"submit\" type=\"submit\" name=\"btnSubmit\" class=\"btnQuini\" value=\"Iniciar Sorteo\">");
				}else if(cantBolillas == 6){
					out.println("<input type=\"button\" id=\"btnReset\" class=\"btnQuini\" value=\"Reiniciar Sorteo\">");
				}
			%>
			<input name="start" type="hidden"  value="true">
		</form>
		<%
			if(cantBolillas>0){
				out.println("<div class=\"ultimaBolilla\">");
				out.println(nuevaBolilla);
				out.println("</div>");
			}
			
		%>
		 <script src="./js/jquery.min.js"></script>
		 <script src="./js/quini.js"></script>
		<script type="text/javascript">
			
			<%
			 if (cantBolillas < 6 && cantBolillas >0){ 
				out.println("setTimeout(\"play()\", 1000)");
			 } 
			%>
		</script>
	</body>
</html>

