<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.LinkedList,ar.edu.ubp.pdc.beans.GruposBean"%>
<%
@SuppressWarnings("unchecked")
	LinkedList<GruposBean> grupos = (LinkedList<GruposBean>)request.getAttribute("grupos");
%>
<script type="text/javascript" src="./js/main.js"></script>
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./js/utils.js"></script>

	 	 <table class="normal">

		<thead>
			<tr>
		    	<th align="right">Codigo de Area</th>
		    	<th align="left">Numero Grupo</th>
		    	<th align="left">Nombre Grupo</th>
		    	<th align="left">Vigente</th>
    		</tr>
		</thead>
    	<tbody>

<%      
		int i=0;
 		for(GruposBean g : grupos) {
           	out.println("<tr>");
           	out.println("<td align=\"left\">" + g.getCod_area() + "&nbsp;&nbsp;</td>");
            out.println("<td align=\"left\">" + g.getNro_grupo()+ "</td>");
          	out.println("<td align=\"left\">" + g.getNom_grupo() + "</td>");
          	out.println("<td align=\"left\">" + g.getVigente() + "</td>");
          	out.println("<td> <a id=\"editar\""+i+" name=\"editar\""+i+" href=\"#\">editar</a> </td>");
          	out.println("<td> <a id=\"borrar\""+i+" name=\"borrar\""+i+" href=\"#\">borrar</a> </td>");
          	out.println("<td> <a name=\"guardar\" href=\"#\" onclick=\"jMain.guardar()\">guardar</a> </td>");
            out.println("</tr>");
        }
%>	
			<tr>
				<td><input type="text" name="coda"/></td>
				<td><input type="text" name="nrog"/></td>
				<td><input type="text" name="nomg"/></td>
				<td><input type="checkbox" name="vig"/></td>
				<td> <a name="guardar" href="#" onclick="jMain.guardar()">guardar</a> </td>
			</tr>
		</tbody>
    </table>
    <div id="error2"></div>