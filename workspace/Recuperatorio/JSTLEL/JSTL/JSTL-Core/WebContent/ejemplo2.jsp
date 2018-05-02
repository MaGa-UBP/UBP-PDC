<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ejemplo 2</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
	<h2>Condicionales</h2>
	<h3>Validador</h3>
	<form action="ejemplo2.jsp" method="post">
	    <table>
	        <colgroup>
	            <col width="50%"/>
	            <col width="50%"/>
	        </colgroup>
	        <tbody>
	            <tr>
	                <th align="right">Ingresa un valor:</th>
	                <td><input type="text" name="nro" maxlength="10" size="7"/></td>
	            </tr>
	        </tbody>
	        <tfoot>
	            <tr>
	                <td colspan="2" align="right"><input type="submit" value="Procesar"/></td>
	            </tr>
	        </tfoot>
	    </table>            
	</form>
	<c:set var="i" value="${param.nro}" scope="request" />
	<c:catch var="exception1">
	    <c:if test="${!empty i}">
	        <h3>c:if</h3>
	        <c:if test="${i % 2 == 0}">
	            <p>El valor ingresado es par</p>
	        </c:if>
	        <c:if test="${i % 2 != 0}">
	            <p>El valor ingresado es impar</p>
	        </c:if>
	    </c:if>
	</c:catch>
	<c:if test="${!empty exception1}">
	    <p>El valor ingresado debe ser un n&uacute;mero. Detalle: ${exception1}</p>
	</c:if>
	<c:catch var="exception2">
	    <c:if test="${!empty i}">
	        <h3>c:choose</h3>
	        <c:choose>
	            <c:when test="${i mod 2 eq 0}">
	                <p>El valor ingresado es par</p>
	            </c:when>
	            <c:otherwise>
	                <p>El valor ingresado es impar</p>
	            </c:otherwise>
	        </c:choose>
	    </c:if>
	</c:catch>
	<c:if test="${!empty exception2}">
	    <p>El valor ingresado debe ser un n&uacute;mero</p>
	</c:if>
	<br/>
	<a href="index.jsp" target="_self">Volver al index principal</a>        
</body>
</html>