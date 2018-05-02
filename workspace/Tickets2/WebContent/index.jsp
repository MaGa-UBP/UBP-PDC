<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/WEB-INF/tld/customs" prefix="ct" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Buscar Tickets</title>
   	<link type="text/css" rel="stylesheet" href="./css/style.css" />
   	<script type="text/javascript" src="./js/jquery.js"></script>
   	<script type="text/javascript" src="./js/utils.js"></script>
   	<script type="text/javascript" src="./js/JTickets.js"></script>
</head>
<body>

<ct:Busqueda funcion="jTicketsf.buscar()"/>
<div id="resultados" class="hide"></div>
<div id="response"></div>
</body>
</html>