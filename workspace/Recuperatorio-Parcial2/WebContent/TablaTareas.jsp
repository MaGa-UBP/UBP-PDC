<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.LinkedList,ar.edu.ubp.pdc.beans.TareasBean"%>
<%
@SuppressWarnings("unchecked")
	LinkedList<TareasBean> tareas = (LinkedList<TareasBean>)request.getAttribute("tareas");
%>
	 	 <table>

		<thead>
			<tr>
		    	<th align="left">Descripcion tarea </th>
		    	<th align="left">Seleccionada</th>

    		</tr>
		</thead>
    	<tbody>

<%               	
		int i=0;
 		for(TareasBean ta : tareas) {
           	out.println("<tr>");
           	out.println("<td align=\"right\">" + ta.getDescTarea() + "&nbsp;&nbsp;</td>");
            //out.println("<td align=\"left\">" + ta.getNro_tarea() + "</td>");
            
            out.println("<td align=\"left\"><input type=\"checkbox\"value=\""+ ta.getNroTarea() + "\" name=\"tarea\""+(ta.getSeleccionada().equals("S") ? "checked" : "")+ ">");
          	out.println("<input type=\"hidden\" name=\"nro_tarea\" value=\""+ ta.getNroTarea() + "\"/>");
          	out.println("<td>");
          	out.println("</tr>");
            i++;
        }
%>	
		</tbody>
    </table>
    