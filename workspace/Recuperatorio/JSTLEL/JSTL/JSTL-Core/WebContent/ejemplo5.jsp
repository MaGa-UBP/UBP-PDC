<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="/WEB-INF/tlds/myELFunctions.tld" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ejemplo 5</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
	<h2>Uso de JavaBeans</h2>
	<form action="ejemplo5.jsp" method="post">
	    <c:forEach var="i" begin="0" end="7">
	        <input type="checkbox" id="categoria${i}" name="categoria" value="${fn:toAsciiToChar(i + 65)}"/><label for="categoria${i}">Categor&iacute;a ${fn:toAsciiToChar(i + 65)}</label><br/>
	    </c:forEach>
	    <br/>
	    <input type="submit" value="Mostrar selecci&oacute;n"/>
	</form>
    <br/>
	<c:if test="${!empty param}">
	    <h3>Categor&iacute;as seleccionadas:</h3>
	    <jsp:useBean id="cat" class="ar.edu.ubp.das.beans.CategoriasBean" scope="request">
	        <jsp:setProperty name="cat" property="categorias" value="${paramValues['categoria']}" />
	    </jsp:useBean>
	    <ul>
	    <c:forEach items="${cat.categorias}" var="c">
	        <li>${c}</li>
	    </c:forEach>
	    </ul>
	</c:if>     
	<a href="index.jsp" target="_self">Volver al index principal</a>
</body>
</html>