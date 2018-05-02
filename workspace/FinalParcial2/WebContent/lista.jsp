<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.LinkedList,ar.edu.ubp.pdc.beans.PreferenciaBean"%>
<% 
@SuppressWarnings("unchecked")
LinkedList <PreferenciaBean> preferencias = (LinkedList <PreferenciaBean>)request.getAttribute("preferencias"); 


@SuppressWarnings("unchecked")
LinkedList <PreferenciaBean> misPreferencias = (LinkedList <PreferenciaBean>)request.getAttribute("misPreferencias"); 


if(preferencias == null){
	out.println("<p>No se registran preferencias</p>");
}
else{
	out.println("<div class=\"prefList\" >");
	out.println("<h4>Preferencias posibles</h4>");
	out.println("<form action=\"JavaScript:void(0); method=\"#\" id=\"formReg\" >");
	out.println("<table><tbody>");
	for(PreferenciaBean p : preferencias){
		out.println("<tr><td class=\"preferencia\" onclick=\"jPreferencias.clicked(this)\">");
		out.println("<span id=\"value\" >" + p.getDescPreferencia() + "</span>");
		out.println("<span id=\"proc\" class=\"hide\" > Procesando ... </span>");
		out.println("<input type=\"hidden\" name=\"codPref\" value=\""+p.getCodTipo()+"\" />");
		out.println("<input type=\"hidden\" name=\"nroPref\" value=\""+p.getNroPreferencia()+"\" />");
		out.println("</td></tr>");
	}
	out.println("</tbody></table>");
	out.println("</form>");
	out.println("</div>");
}

if(misPreferencias == null){
	out.println("<p>No se registran preferencias registradas</p>");
}
else{
	out.println("<div class=\"prefList\" >");
	out.println("<h4>Mis Preferencias</h4>");
	out.println("<table id=\"misPref\"><tbody>");
	for(PreferenciaBean p : misPreferencias){
		out.println("<tr><td class=\"preferencia\">");
		out.println(p.getDescPreferencia());
		out.println("</td></tr>");
	}
	out.println("</tbody></table>");
	out.println("</div>");
}

%>