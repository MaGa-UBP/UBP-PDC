<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ct" uri="/WEB-INF/tlds/customs.tld" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ct:saludo/>
	<br/>
	<ct:mensaje nombre="Gaston"/>
	<br/>
	<ct:mensaje nombre="Gaston" apellido="Ramirez"/>
</body>
</html>