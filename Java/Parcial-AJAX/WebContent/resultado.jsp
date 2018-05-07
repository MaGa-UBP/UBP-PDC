<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.text.SimpleDateFormat, java.util.*"%>
<%
// create SimpleDateFormat object with source string date format
SimpleDateFormat sdfSource = new SimpleDateFormat(
        "yyyy-MM-dd");

// parse the string into Date object
Date date = sdfSource.parse(request.getParameter("fecha"));

// create SimpleDateFormat object with desired date format
SimpleDateFormat sdfDestination = new SimpleDateFormat("dd/MM/yyyy");


out.println("<tr>");
out.println("<td class=\"numero\">"+request.getParameter("index")+"</td>");
out.println("<td class=\"decorate\">"+ sdfDestination.format(date) +"</td>");
out.println("<td class=\"decorate\">"+request.getParameter("descripcion")+"</td>");
out.println("<td class=\"decorate\">"+request.getParameter("prioridad")+"</td>");
out.println("<td class=\"decorate\">"+(request.getParameter("email")!=null? request.getParameter("email") : "")+"</td>");
out.println("<td><a href=\"#\" class=\"btnDescartar\">Descartar</a></td>");
out.println("</tr>");

%>