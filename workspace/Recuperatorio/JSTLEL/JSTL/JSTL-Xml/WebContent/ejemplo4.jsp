<%@ page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<!DOCTYPE html>
<c:catch var="exception">
	<c:import var="stock" url="/WEB-INF/stock.xml"/>
	<c:import var="stockHtml" url="/WEB-INF/stock.xsl"/>
	<x:transform xml="${stock}" xslt="${stockHtml}"/>
</c:catch>
<c:if test="${!empty exception}">
	<p>${exception}</p>
</c:if>
	