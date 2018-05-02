<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.LinkedList,ar.edu.ubp.pdc.beans.SedesBean"%>
<%

	//if(request.getAttribute("sedes")){
	@SuppressWarnings("unchecked")
	LinkedList<SedesBean> sedes2 = (LinkedList<SedesBean>)request.getAttribute("sedes");
	//}
%>

	 	 <table>
		<thead>
			<tr>
		    	<th width="400px">Sede</th>
    		</tr>
		</thead>
    	<tbody>

<%          
		
			String [] ultimaSel =(String[]) request.getSession().getAttribute("ultimaSel");
			LinkedList<Integer> ultimaSele = new LinkedList<Integer>();
			for(int i=0;i<ultimaSel.length;i++){
				ultimaSele.add(Integer.valueOf(ultimaSel[i])); 	
			}
			
	 		for(SedesBean se : sedes2) {
	           	out.println("<tr>");
	           	out.println("<td>" + se.getNomSede() + "&nbsp;</td>");
	           	if (ultimaSele.contains(se.getNroSede())){
	           		out.println("<td><input type=\"checkbox\" name=\"seleccionadas\" value=\""  + se.getNroSede() + "\" checked/></td>");	
	           	}
	           	else out.println("<td><input type=\"checkbox\" name=\"seleccionadas\" value=\""  + se.getNroSede() + "\"/></td>");
	            out.println("</tr>");
	            
	        }	
		
%>	
		</tbody>
    </table>