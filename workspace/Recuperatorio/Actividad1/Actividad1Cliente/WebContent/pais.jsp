<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.LinkedList,ar.edu.ubp.das.ws.PaisBean" %>
<% 
	LinkedList<PaisBean> paises = (LinkedList<PaisBean>)request.getAttribute("paises");
	for (int i = 0; i < paises.size(); i++)
	{
		out.println("<p>");
		out.println("Cod: " + paises.get(i).getCodPais());
		out.println("</p>");
		out.println("<p>");
		out.println("Nom: " + paises.get(i).getNomPais());
		out.println("</p>");
	}
%>