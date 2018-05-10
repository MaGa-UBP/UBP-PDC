<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:message key="visto" bundle="${etq}" var="visto" />
<c:choose>
	<c:when test="${requestScope.categorias.size() > 0}">
		<c:forEach var="categoria" items="${requestScope.categorias}">
			<h4>${categoria.nomCategoria}</h4>
			<c:forEach var="video" items="${categoria.videos}">
				<c:set var="idVideo" value="V${video.nroVideo}"/>
				<p>
					<a href="#" onclick="jVideos.ver(this);return false">${video.titulo}</a>
					<i>${video.cantante}</i>
					<span id="span-${video.nroVideo}">${empty cookie[idVideo] ? "" : visto}</span>
					<input type="hidden" name="nroVideo" value="${video.nroVideo}" />
					<input type="hidden" name="titulo" value="${video.titulo}" />
					<input type="hidden" name="cantante" value="${video.cantante}" />
					<input type="hidden" name="linkVideo" value="${video.linkVideo}" />
				</p> 
			</c:forEach>
		</c:forEach>	
	</c:when>
	<c:otherwise>
		<p><fmt:message key="sin_videos" bundle="${etq}" /></p>
	</c:otherwise>		
</c:choose>    
