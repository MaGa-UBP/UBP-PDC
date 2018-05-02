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
	<script type="text/javascript" src="./js/paises.js" charset="UTF-8"></script>
</head>
<body>
	<h3>Selecci&oacute;n de Provincias</h3>
	<div id="message" class="hide"></div>
	<form id="form" action="javascript:void(null)" method="post">
		<table>
			<colgroup>
				<col width="50px"/>
				<col width="400px"/>
			</colgroup>	
			<tbody>
				<tr>
					<th align="right">Pa&iacute;s:</th>
					<td><div id="paises" class="hide"></div></td>
				</tr>
				<tr>
					<th align="right">Provincia:</th>
					<td><div id="provincias" class="hide"></div></td>
				</tr>
			</tbody>
		</table>
	</form>
	<br/>  
	<script type="text/javascript">
	jPaises.getPaises();
	</script>
</body>
</html>