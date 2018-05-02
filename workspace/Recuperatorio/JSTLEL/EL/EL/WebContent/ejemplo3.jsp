<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fn" uri="/WEB-INF/tlds/myELFunctions.tld" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ejemplo 3</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
    <h2>${fn:toLower("HOLA MUNDO!!! :)")}</h2>
    <h2>${fn:toUpper("hola mundo!!! :)")}</h2>
    <h2>${fn:toWordcap("HOLA mundo!!! :)")}</h2>
    <a href="index.jsp" target="_self">Volver al index principal</a>
</body>
</html>
