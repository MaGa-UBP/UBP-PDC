<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="width250">
	<colgroup>
		<col width="175px"/>
		<col width="175px"/>
	</colgroup>
	<thead>
		<tr>
			<td align="right"><nobr>X&nbsp;&nbsp;</nobr></td>
			<td align="right"><nobr>X!&nbsp;&nbsp;</nobr></td>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="f" items="${requestScope.factorial}" varStatus="s">
		<tr>
			<td align="right"><nobr>${s.index}&nbsp;&nbsp;</nobr></td>
			<td align="right"><nobr>${f}&nbsp;&nbsp;</nobr></td>
		</tr>
	</c:forEach>	
	</tbody>
</table>    