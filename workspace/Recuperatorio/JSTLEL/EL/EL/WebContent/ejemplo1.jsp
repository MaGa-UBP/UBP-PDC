<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="true" %> 
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Ejemplo 1</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
	<h2>Expression Language</h2>
	<h3>Operadores Matem&aacute;ticos</h3>
	${2 * 4}<br/>
	${5 / 2}<br/>
	${5 % 2}<br/>
	${2 + 2}<br/>
	${7 - 2}<br/>
	<h3>Operadores de Comparaci&oacute;n</h3>
	${2 == 2}<br/>
	${header["host"] eq "localhost:8085"}<br/>
	${2 != 2}<br/>
	${header["host"] ne "localhost:8085"}<br/>
	${2 < 2} o ${2 lt 2}<br/>
	${3 > 2} o ${3 gt 2}<br/>
	${2 <= 2} o ${2 le 2}<br/>
	${1 >= 2} o ${1 ge 2}<br/>
	<h3>Operadores L&oacute;gicos</h3>        
	${!(2 == 2)} o ${not(2 == 2)}<br/>
	${(2 == 2) && (2 >= 0)} o ${(2 == 2) and (2 >= 0)}<br/>
	${(2 == 2) || (2 != 2)} o ${(2 == 2) or (2 != 2)}<br/>
	<h3>Operador Ternario</h3>
	${2 < 3 ? "SI" : "NO"}<br/><br/><br/>        
	<a href="index.jsp" target="_self">Volver al index principal</a>
</body>
</html>
