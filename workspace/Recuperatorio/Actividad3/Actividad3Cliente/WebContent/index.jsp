<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Provincias</title>
    <link type="text/css" rel="stylesheet" href="./css/style.css" />
	<script type="text/javascript" src="./js/jquery.js"></script>
	<script type="text/javascript" src="./js/utils.js"></script>
	<script type="text/javascript" src="./js/feriados.js" charset="UTF-8"></script>
</head>
<body>
	<div id="pachorra"></div>
	<h3>Feriados</h3>
	<div id="message" class="hide"></div>
	<form id="form" action="javascript:void(null)" method="post">
		<table>
			<colgroup>
				<col width="50px"/>
				<col width="400px"/>
			</colgroup>	
			<tbody>
				<tr>
					<th align="right">Años Feriados</th>
					<td><div id="feriados" class="hide"></div></td>
				</tr>
			</tbody>
			
		</table>
	</form>
	</br>
	<table>
		<colgroup>
			<col width ="300px"/>
			<col width = "400px"/>
		</colgroup>
		<tbody id = "feriadosTable">
		</tbody>
	</table>
	<br/>  
	<script type="text/javascript">
	jFeriados.getAñosFeriados();
	</script>
</body>
</html>