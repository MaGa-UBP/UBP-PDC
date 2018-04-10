<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resultados del c&aacute;lculo</title>
</head>
<body>
<% 
	int valor1, valor2;

	/* comentario en bloque en Java*/
	/*	<%-- --/> comentario JSP */
	
	valor1 = Integer.parseInt(request.getParameter("inputValor1")); //Casting
	valor2 = Integer.parseInt(request.getParameter("inputValor2"));
%>
<p>Suma: <%= valor1+valor2 %> </p>
<%
	out.println("<p>Resta: "+ (valor1-valor2) + "</p>");
	out.println("<p>Multiplicaci&oacute;n: "+ (valor1*valor2) + "</p>");
%>
<p>Divisi&oacute;n: <%= valor2==0? " " : valor1/(float)valor2 %> </p>

<%
	if(valor2 == 0){
%>	
	<p>No puede dividirse por 0.</p>
<% } %>

<%-- Lo mismo que arriba, sin cortar el bloque JAVA
<% 
	if(valor2 == 0){
		out.println("<p>No puede dividirse por 0.</p>
	}
%>
--%>
</body>
</html>