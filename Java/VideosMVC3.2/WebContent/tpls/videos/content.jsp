<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="/WEB-INF/tld/customs.tld" prefix="ct" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="ar.edu.ubp.das.src.videos.properties.etiquetas" var="etq" scope="session"/>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><fmt:message key="titulo" bundle="${etq}" /></title>
	<link type="text/css" rel="stylesheet" href="/util/StyleSheet.do/load=page,messages,videos" />
	<script type="text/javascript" src="/util/Javascript.do/load=jquery,jquery.i18n.properties,utils,videos"></script>
	<script type="text/javascript">
	jUtils.changeLang("etiquetas_js", "${lang}");
	</script>
</head>
<body>
	<h3 class="fl"><fmt:message key="titulo" bundle="${etq}" /></h3>    
	<span class="fr"><a href="/videos/Content.do/lang=es"><fmt:message key="espanol" bundle="${etq}" /></a> <a href="/videos/Content.do/lang=en"><fmt:message key="ingles" bundle="${etq}" /></a></span>
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