<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<script type="text/javascript" src="./js/jquery.js"></script>
	<script type="text/javascript" src="./js/utils.js"></script>
	<script type="text/javascript" src="./js/lista.js" charset="UTF-8"></script>
	<select name="obra_social" onchange="jLista.afiliados(this);">
		<option value="">Elija una opcion</option>
	<c:forEach var="f" items="${requestScope.lista}" varStatus="s">
			<option value="${f}">${f}</option>
	</c:forEach>
	</select>
