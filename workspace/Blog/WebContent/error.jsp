<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
   <link type="text/css" rel="stylesheet" href="./css/style.css" />
   <script type="text/javascript" src="./js/jquery.js"></script>
   <script type="text/javascript" src="./js/blog.js"></script>
   <title>Reporte de Error</title>            
</head>
<body>
	<div id="error">
	<%
	out.println(request.getAttribute("error"));
	if(request.getAttribute("volver") != null) {
		%>
		<a href="index.jsp">Volver</a>
	<%
	}
	%>
	</div>
</body>
</html>