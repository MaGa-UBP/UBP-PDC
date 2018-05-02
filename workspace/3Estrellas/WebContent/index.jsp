<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>3 Estrellas</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css" />
    <script type="text/javascript" src="./js/jquery.js"></script>
    <script type="text/javascript" src="./js/estrellas.js"></script>
</head>
<body>
	<div id="content">
	    <%!
	    int cols = 3, rows = 4, sels = 3;
	    int celdas[] = new int[sels];
	    %>
		<%
		if(request.getParameterMap().size() > 0) {
        	int i = 0, celda;
        	String celdasRdm = "";
       		do {
       			celda = Double.class.cast(Math.random() * (cols * rows)).intValue();
    			while(celda == 0 || celdasRdm.contains(celda + ";")) {
    				celda = Double.class.cast(Math.random() * (cols * rows)).intValue();
        		}
                celdasRdm  += celda + ";";
                celdas[i++] = celda;                
        	}
       		while(i < sels);       		       		
           	Arrays.sort(celdas);
		}
		%>
		<h3>Busca tus 3 estrellas</h3>
		<form id="form" action="index.jsp" method="post">
		<input type="hidden" id="celdas" name="celdas" value=""/>
		<%
		out.println("<table>");
		if(request.getParameter("celdas") != null) {
			int c = 0, s = 0, k = 0, celda = 1, celdasSel[] = new int[3];
			
			for(String cs : request.getParameter("celdas").split(";")) {
				celdasSel[k++] = Integer.parseInt(cs);
			}
			
			for(int i = 1; i <= rows; i++) {
				out.println("<tr>");
				for(int j = 1; j <= cols; j++) {
					out.println("<td class=\"");
					if(c < sels && celda == celdas[c]) {
						out.println("verde");
						if(s < sels && celdas[c] == celdasSel[s]) {
							s ++;
						}
						c++;
					}			
					else if(s < sels && celda == celdasSel[s]) {
						out.println("rojo");
						s++;
					}			
					else {
						out.println("azul");						
					}
					out.println("\"><span>" + celda + "</span>");
					out.println("<input type=\"hidden\" name=\"celda\" value=\""+ (celda ++) + "\"/>");
					out.println("</td>");
				}
				out.println("</tr>");
			}			
			out.println("</table>");
			
			if(Arrays.equals(celdas, celdasSel)) {
				out.println("<div id=\"info\">GANASTE!</div>");
			}
			
			out.println("<input type=\"button\" value=\"Volver a Intentar\" onclick=\"window.location.href='index.jsp'\"/>");
		}
		else {
			int celda = 1;
			for(int i = 1; i <= rows; i++) {
				out.println("<tr>");
				for(int j = 1; j <= cols; j++) {
					out.println("<td class=\"azul\" onclick=\"jForm.select(this)\"><span>" + celda + "</span>");
					out.println("<input type=\"hidden\" name=\"celda\" value=\"" + (celda ++) + "\"/>");
					out.println("</td>");
				}
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("<input type=\"button\" value=\"Probar Suerte\" onclick=\"jForm.valid()\"/>");
		}	
		%>
		</form>
	</div>
</body>
</html>