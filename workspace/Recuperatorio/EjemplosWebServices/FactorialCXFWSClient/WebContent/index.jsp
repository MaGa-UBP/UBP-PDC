<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Factorial</title>
	<link type="text/css" rel="stylesheet" href="./css/style.css" />
	<script type="text/javascript" src="./js/jquery.js"></script>
	<script type="text/javascript" src="./js/utils.js"></script>
	<script type="text/javascript" src="./js/factorial.js" charset="UTF-8"></script>
</head>
<body>
	<h1>Factorial</h1>    
	<div id="message"></div>
	<div id="main">    
		<form id="factorial" action="javascript:void(null)" method="post">
			<table class="width250">
		    	<colgroup>
		    		<col width="75px"/>
		    		<col width="125px"/>
		    	</colgroup>
		    	<tbody>
			        <tr>
			        	<th align="right">Ingrese un n&uacute;mero:</th>
			        	<td><input type="text" id="nro" name="nro" value="" maxlength="10" size="12" /></td>
			    	</tr>
			    	<tr>
			    		<th colspan="2" align="right"><input type="submit" value="Calcular" onclick="jFactorial.calcular()"/></th>
			    	</tr>
			    </tbody>
			</table>    	
		</form>
		<br/>
		<div id="result"></div>    
	</div>	
</body>
</html>