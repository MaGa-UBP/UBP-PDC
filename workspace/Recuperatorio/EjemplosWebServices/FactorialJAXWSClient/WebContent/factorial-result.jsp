<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>    
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
	<%
	ArrayList<Long> factorial = (ArrayList<Long>)request.getAttribute("factorial");
	for(int i = 0; i < factorial.size(); i ++) 
	{
	%>
		<tr>
			<td align="right"><nobr><%= i %>&nbsp;&nbsp;</nobr></td>
			<td align="right"><nobr><%= factorial.get(i) %>&nbsp;&nbsp;</nobr></td>
		</tr>
	<%
	}
	%>	
	</tbody>
</table>    