<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.LinkedList,ar.edu.ubp.pdc.beans.TicketsBean"%>
<%
@SuppressWarnings("unchecked")
	LinkedList<TicketsBean> tickets = (LinkedList<TicketsBean>)request.getAttribute("tickets");
%>
	 	 <table>
    	<colgroup>
	    	<col width="20px"/>
	    	<col width="360px"/>
	    	<col width="120px"/>
    	</colgroup>	
		<thead>
			<tr>
		    	<th align="right">Nro Ticket</th>
		    	<th align="left">Fecha</th>
		    	<th align="left">Solicitante</th>
		    	<th align="left">Asunto</th>
		    	<th align="left">Texto</th>
    		</tr>
		</thead>
    	<tbody>

<%               	
 		for(TicketsBean t : tickets) {
           	out.println("<tr>");
           	out.println("<td align=\"right\">" + t.getNro_ticket() + "&nbsp;&nbsp;</td>");
            out.println("<td align=\"left\">" + t.getFecha_ticket() + "</td>");
          	out.println("<td align=\"left\">" + t.getSolicitante() + "</td>");
          	out.println("<td align=\"left\">" + t.getAsunto_ticket() + "</td>");
          	out.println("<td align=\"left\">" + t.getTexto_ticket() + "</td>");
            out.println("</tr>");
        }
%>	
		</tbody>
    </table>