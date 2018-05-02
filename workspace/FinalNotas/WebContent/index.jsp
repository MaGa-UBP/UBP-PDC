<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/WEB-INF/tld/customs" prefix="ct" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Notas</title>
   	<link type="text/css" rel="stylesheet" href="./css/style.css" />
   	<script type="text/javascript" src="./js/jquery.js"></script>
   	<script type="text/javascript" src="./js/utils.js"></script>
   	<script type="text/javascript" src="./js/main.js"></script>
   	<script type="text/javascript" src="./js/notas.js"></script>
</head>
<body>
	<%String ultimaS =(String) request.getSession().getId(); %>
	<form id="form" action="GuardarNota.jsp" method="post">
	<input type="hidden" name="idsession" value="<%=ultimaS%>"/>
	<%if((request.getSession().getAttribute("cantNotas")==null ? "" : request.getParameter("nota")).equals("4")){
		out.println("<script type=\"text/javascript\">jNotas.mensaje();</script>");
	}
	%>
	<table>
		<tr>
		<td><div id="divnotas" align="top"></div></td>
		<td><ct:notas nombre="nota" funcion="jNotas.valid()"/></td>
		<div id="aux"></div>
		</tr>
	</table>
	</form>
</body>
</html>