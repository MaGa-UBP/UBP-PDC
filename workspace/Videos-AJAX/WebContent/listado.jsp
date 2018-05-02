<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.LinkedList,ar.edu.ubp.pdc.bean.CategoriaVideosBean,ar.edu.ubp.pdc.bean.VideoBean" %>
<%!
boolean containsVideo(Cookie[] cookies, int nroVideo) {
	for(Cookie c : cookies) {
		if(c.getValue().equals(String.valueOf(nroVideo))) {
			return true;
		}
	}
	return false;
}
%>
<% 
LinkedList<CategoriaVideosBean> categorias = (LinkedList<CategoriaVideosBean>)request.getAttribute("categorias");
if(categorias.size() > 0) {
	for(CategoriaVideosBean categoria: categorias) {
		out.println("<h4>" + categoria.getNomCategoria() + "</h4>");
		for(VideoBean video : categoria.getVideos()) {
			out.println("<p>");
			out.println("<a href=\"#\" onclick=\"jVideos.ver(this);return false\">" + video.getTitulo() + "</a>");
			out.println("<i>" + video.getCantante() + "</i>");
			out.println("<span id=\"span-" + video.getNroVideo() + "\">" + (containsVideo(request.getCookies(), video.getNroVideo()) ? "[Visto]" : "") + "</span>");
			out.println("<input type=\"hidden\" name=\"nroVideo\"  value=\"" + video.getNroVideo() + "\" />");
		    out.println("<input type=\"hidden\" name=\"titulo\"    value=\"" + video.getTitulo() + "\" />");
			out.println("<input type=\"hidden\" name=\"cantante\"  value=\"" + video.getCantante() + "\" />");
			out.println("<input type=\"hidden\" name=\"linkVideo\" value=\"" + video.getLinkVideo() + "\" />");
		    out.println("</p>"); 
		}
	}
}
else {
%>
<p>No existen videos que satisfagan el criterio de búsqueda especificado</p>
<%
}
%>