<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.LinkedList,ar.edu.ubp.pdc.beans.NotaBean" %>
<%
int i = 0;
LinkedList<NotaBean> notas = (LinkedList<NotaBean>)request.getAttribute("notas");
for(NotaBean n : notas) {
%>

	<h4><%= n.getFechaNota() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a name="borrar" href="#" onclick="jNotas.borrar(this)">Borrar</a>
	<input type="hidden" name="anoNota" value="<%= n.getAnoNota() %>"/>
	<input type="hidden" name="nroNota" value="<%= n.getRnoNota() %>"/>
	<p><%= n.getTextoNota() %></p></br>
	</h4>
	


<%i++;}%>