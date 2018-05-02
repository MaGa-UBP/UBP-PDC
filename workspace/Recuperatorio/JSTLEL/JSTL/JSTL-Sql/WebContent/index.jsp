<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JSTL SQL</title>
	<link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
	<h1>Herramienta SQL</h1>
	<form name="sql" action="index.jsp" method="post" target="_top">
	    <textarea name="queries" rows="10" cols="109"></textarea>
	    <br/><br/>
	    <input type="submit" value="Ejecutar"/>
	</form>
	<br/>
	<c:set var="queries" value="${param.queries}" scope="request"/>
	<c:catch var="exception">
	    <c:if test="${!empty queries}">
	        <hr/>
	        <sql:setDataSource var="dataSource" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" url="jdbc:sqlserver://localhost;databaseName=das;" user="sa" password="pyxis" />
	        <c:forTokens delims=";" items="${queries}" var="query">
	            <c:choose>
	                <c:when test="${fn:indexOf(fn:toLowerCase(query), 'select') >= 0}">
	                    <sql:query dataSource="${dataSource}" var="result">
	                        ${query}
	                    </sql:query>
	
	                    <c:choose>
	                        <c:when test="${result.rowCount == 0}">
	                            <p>La consulta no retorn&oacute; filas</p>
	                        </c:when>
	                        <c:otherwise>
                              	<table>
                               		<thead>
                                    	<tr>
                                        	<c:forEach items="${result.columnNames}" var="col">
                                            	<td>${col}</td>
                                          	</c:forEach>
                                      	</tr>
                                  	</thead>
                                  	<tbody>
	                            	<c:forEach items="${result.rowsByIndex}" var="row">
	                                	<tr>
	                                    	<c:forEach items="${row}" var="value">
	                                        	<td>${value}</td>
	                                    	</c:forEach>
	                                	</tr>        
	                            	</c:forEach>                                   
                                    </tbody>
                            	</table>
	                        </c:otherwise>
	                    </c:choose>
	                </c:when>
	                <c:otherwise>
	                    <sql:transaction dataSource="${dataSource}" isolation="read_committed">
	                        <sql:update var="updateCount">
	                            ${query}
	                        </sql:update>
	                    </sql:transaction>
		
			            <c:choose>
			                <c:when test="${updateCount > 0}">
	                    		<p>${updateCount} fila(s) afectada(s)</p>
	                    	</c:when>
	                    	<c:otherwise>
	                    		<p>El comando se ejecut&oacute; exitosamente</p>
	                    	</c:otherwise>	                        
	                	</c:choose>
	                </c:otherwise>
	            </c:choose>
	        </c:forTokens>
	    </c:if>
	</c:catch>
	<c:if test="${!empty exception}">
	    <p>Error: ${exception}</p>
	</c:if>
</body>
</html>