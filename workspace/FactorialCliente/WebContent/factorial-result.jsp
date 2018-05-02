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
	long factorial[] = (long[])request.getAttribute("factorial");	
	for(int i = 0; i < factorial.length; i ++) 
	{
	%>
		<tr>
			<td align="right"><nobr><%= i %>&nbsp;&nbsp;</nobr></td>
			<td align="right"><nobr><%= factorial[i] %>&nbsp;&nbsp;</nobr></td>
		</tr>
	<%
	}
	%>	
	</tbody>
</table>    