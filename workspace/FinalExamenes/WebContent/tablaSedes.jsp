<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.LinkedList,ar.edu.ubp.pdc.beans.SedesBean"%>
<%
@SuppressWarnings("unchecked")
	LinkedList<SedesBean> sedes = (LinkedList<SedesBean>)request.getAttribute("sedes");

%>

	 	 <table>
		<thead>
			<tr>
		    	<th width="400px">Sede</th>
    		</tr>
		</thead>
    	<tbody>

<%          
		
 		for(SedesBean s : sedes) {
           	out.println("<tr>");
           	out.println("<td>" + s.getNomSede() + "&nbsp;</td>");
           	out.println("<td><input type=\"checkbox\" name=\"seleccionadas\" value=\""  + s.getNroSede() + "\"</td>");
			//out.println("<input type=\"hidden\" name=\"checkbox\" value=\""+s.getNroSede()+"\" />");
            out.println("</tr>");
            
        }

		
%>	
		</tbody>
    </table>