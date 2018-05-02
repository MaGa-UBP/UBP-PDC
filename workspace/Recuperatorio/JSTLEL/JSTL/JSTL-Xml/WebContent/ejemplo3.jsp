<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<!DOCTYPE html>
<c:catch var="exception">
	<c:import var="rssFeed" url="https://news.google.com.ar/?output=rss" charEncoding="UTF-8"/>
	<c:import var="rssFeedHtml" url="/WEB-INF/rss.xsl" />
	<x:transform xml="${rssFeed}" xslt="${rssFeedHtml}"/>
</c:catch>
<c:if test="${!empty exception}">
	<p>${exception}</p>
</c:if>
	