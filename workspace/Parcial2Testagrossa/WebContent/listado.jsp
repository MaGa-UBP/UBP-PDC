<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.LinkedList,ar.edu.ubp.pdc.beans.PreferenciasBean"%>
<%

@SuppressWarnings("unchecked")
LinkedList <PreferenciasBean> preferenciasPosiblesList = (LinkedList <PreferenciasBean>)request.getAttribute("preferenciasPosiblesList"); 

@SuppressWarnings("unchecked")
LinkedList <PreferenciasBean> preferenciasRegistradaList = (LinkedList <PreferenciasBean>)request.getAttribute("preferenciasRegistradaList");  


if(preferenciasPosiblesList == null) {
	out.println("<p>No se registra preferenciasPosiblesList</p>");
}
else {
    out.println("<div class=\"fl\">");
	out.println("<h4><b>Preferencias Posibles</b></h4>");
	out.println("<form action=\"JavaScript:void(0); method=\"#\" id=\"formReg\" >");
	out.print("<input type=\"hidden\" name=\"preferenciaRegistrada\" value=\"\">");
	out.println("<table><tbody>");
	for(PreferenciasBean p : preferenciasPosiblesList){
		out.println("<tr><td id=\""+ p.getCodTipo() + "-" + p.getNroPreferencia() +"\" onClick=\"jParcial.registrar(this)\" >");
			out.println(p.getDescPreferencia());
		out.println("</td></tr>");
	}
	out.println("</tbody></table>");
	out.println("</form>");
	out.println("</div>");
}
if(preferenciasRegistradaList == null) {
	out.println("<p>No se registra preferenciasRegistradaList</p>");
}
else {
	out.println("<div class=\"fl\">");
	out.println("<h4><b>Mis Preferencias</b></h4>");
	out.println("<table><tbody id=\"iregistradas\">");
	for(PreferenciasBean p : preferenciasRegistradaList){
		out.println("<tr><td>");
			out.println(p.getDescPreferencia());
		out.println("</td></tr>");
	}
	out.println("</tbody></table>");
	out.println("</div>");
	
} 
%>