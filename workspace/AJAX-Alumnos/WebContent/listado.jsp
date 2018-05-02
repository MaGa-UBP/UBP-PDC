<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.LinkedList,ar.edu.ubp.pdc.beans.CarreraBean,ar.edu.ubp.pdc.beans.AlumnoBean"%>
<%
short nroCarreraSel = request.getParameter("nro_carrera") == null ? -1 : Short.parseShort(request.getParameter("nro_carrera"));

@SuppressWarnings("unchecked")
LinkedList<CarreraBean> aluCarreras = (LinkedList<CarreraBean>)request.getAttribute("aluCarreras");
LinkedList<AlumnoBean>  alumnos;

if(aluCarreras.size() == 0) { 
%>
	<p>No se registra alumnos en la carrera</p>
<%
}
else {		
	for(CarreraBean carrera : aluCarreras) {			
       	out.println("<h4>" + carrera.getCarrera() + "</h4>");
%>       	
    <table>
    	<colgroup>
	    	<col width="20px"/>
	    	<col width="360px"/>
	    	<col width="120px"/>
    	</colgroup>	
    	<tbody>
	    	<tr>
		    	<th align="right">Legajo&nbsp;&nbsp;</th>
		    	<th align="left">Apellido, Nombre</th>
		    	<th align="left">Documento</th>
    		</tr>
<%               	
 		for(AlumnoBean alumno : carrera.getAlumnos()) {
           	out.println("<tr>");
           	out.println("<td align=\"right\">" + alumno.getNroLegAlumno() + "&nbsp;&nbsp;</td>");
            out.println("<td align=\"left\">" + alumno.getNomAlumno() + "</td>");
          	out.println("<td align=\"left\">" + alumno.getDocumento() + "</td>");
            out.println("</tr>");
        }
%>
    </table>	 
<%
	}
} 
%>