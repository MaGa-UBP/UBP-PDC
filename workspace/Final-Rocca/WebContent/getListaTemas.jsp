<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="/WEB-INF/tld/customs.tld" prefix="ct" %>

	<ct:ListaTemas nombre="listaTemas" codigo="<%=request.getParameter(\"codigo\")%>"/>
