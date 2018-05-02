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
	<h2>Categor&iacute;as</h2>
	<form action="ejemplo4-res.jsp" method="post">
	    <p><input type="checkbox" id="A" name="categoria" value="A"/><label for="A">Categor&iacute;a A</label></p>
	    <p><input type="checkbox" id="B" name="categoria" value="B"/><label for="B">Categor&iacute;a B</label></p>
	    <p><input type="checkbox" id="C" name="categoria" value="C"/><label for="C">Categor&iacute;a C</label></p>
	    <p><input type="checkbox" id="D" name="categoria" value="D"/><label for="D">Categor&iacute;a D</label></p>
	    <p><input type="checkbox" id="E" name="categoria" value="E"/><label for="E">Categor&iacute;a E</label></p>
	    <input type="submit" value="Continuar..."/>
	</form>     	
    <br/>
    <a href="index.jsp" target="_self">Volver al index principal</a>
</body>
</html>