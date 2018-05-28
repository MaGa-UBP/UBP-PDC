<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.LinkedList, ar.edu.ubp.pdc.beans.TicketBean"%>
<table class="table table-striped">
	<tr>
		<th>Ticket N&deg;</th>
		<th>Fecha</th>
		<th>Solicitante</th>
		<th>Asunto</th>
		<th>Texto</th>
	</tr>
	<%
	LinkedList<TicketBean> tickets = (LinkedList<TicketBean>) request.getAttribute("tickets");

	for(TicketBean ticket : tickets){		
	%>
	<tr>
		<td><%= ticket.getTicket() %></td>
		<td><%= ticket.getFechaTicket() %></td>
		<td><%= ticket.getSolicitante()%></td>
		<td><%= ticket.getAsuntoTicket() %></td>
		<td><%= ticket.getTextoTicket() %></td>
	</tr>
	<%
	}
	%>

</table>
