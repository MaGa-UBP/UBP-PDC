<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Probando AJAX</title>
</head>
<body>
	<div id="main">
		<form action="javascript:void(null)" method="post" onsubmit="jForm.enviar(event)" id="form">
		<!--  Si queremos que funcione el required, hay que disparar de alguna forma el submit -->
		<p>Valor 1: <input type="number" name="variable1" value="" required/></p>
		<p>Valor 2: <input type="number" name="variable2" value="" required/></p>
		<button>Enviar</button>
	</form>
	</div>
	<div id="result"></div>
	<script src="./js/jquery.min.js"></script>
	<script src="./js/form.js"></script>
</body>
</html>