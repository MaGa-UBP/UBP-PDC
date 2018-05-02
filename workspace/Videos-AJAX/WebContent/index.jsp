<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/tld/customs.tld" prefix="ct" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Videos</title>
	<link rel="stylesheet" type="text/css" href="./css/styles.css"/>
	<script type="text/javascript" src="./js/jquery.js"></script>
	<script type="text/javascript" src="./js/utils.js"></script>
	<script type="text/javascript" src="./js/videos.js"></script>
</head>
<body>
	<h3>Videos</h3>
	<div id="message"></div>
	<div id="response"></div>
	<div id="main">
		<form id="form" action="javascript:void(null)" method="post" onsubmit="jVideos.buscar()">
			<ct:critbusqvideos onClick="jVideos.buscar()" />
			<br/>
			<div id="result"></div>
		</form>
	</div>
</body>
</html>