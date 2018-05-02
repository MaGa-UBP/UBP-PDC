<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Ejemplo 4</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
	<h2>Categor&iacute;as Seleccionadas</h2>
	<jsp:useBean id="cat1" class="ar.edu.ubp.das.beans.CategoriasBean" scope="page">
	    <%
	    String[] c = request.getParameterValues("categoria");
	    if(c != null) {
		    for(int i = 0; i < c.length; i++) {
		        cat1.setCategoria(c[i], i);
		    }
	    }
	    %>
	</jsp:useBean>
	<p>Primera Categor&iacute;a Elegida (Scriptlet): <%= cat1.getCategoria(0) %></p>
	
	<jsp:useBean id="cat2" class="ar.edu.ubp.das.beans.CategoriasBean" scope="page">
	    <jsp:setProperty name="cat2" property="categorias" value="${paramValues['categoria']}" />
	</jsp:useBean>
	<p>Primera Categor&iacute;a Elegida (EL): ${cat2.categorias[0]}</p>
	<a href="ejemplo4.jsp">Volver</a>	
</body>
</html>