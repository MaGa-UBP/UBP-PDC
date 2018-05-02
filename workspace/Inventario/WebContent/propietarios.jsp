<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="ct" uri="/WEB-INF/tld/custom.tld" %>
<ct:propietarios nombre="propietario" tipoPropietario="<%= request.getParameter(\"tipo_propietario\") %>" habilitado="S" />
    