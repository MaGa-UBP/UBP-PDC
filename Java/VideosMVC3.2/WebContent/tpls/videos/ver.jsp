<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<p>
	<b>${param.titulo}</b>&nbsp;&nbsp;
	<i>${param.cantante}</i>
</p>
<iframe width="560" height="315" src="${param.linkVideo}"></iframe>		
<br/><br/>
<a href="#" onclick="jVideos.volver();return false;"><fmt:message key="volver" bundle="${etq}" /></a>	
