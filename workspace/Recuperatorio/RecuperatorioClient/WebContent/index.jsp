<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="./js/jquery.js"></script>
	<script type="text/javascript" src="./js/utils.js"></script>
	<script type="text/javascript" src="./js/lista.js" charset="UTF-8"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recuperatorio</title>
</head>
<body>
<form id="recuperatorio" action="javascript:void(null)" method="post">
	<div id="lista"></div>
	<div id="afiliados"></div>
</form>
<script type="text/javascript">
	jLista.traer();
</script>
</body>
</html>