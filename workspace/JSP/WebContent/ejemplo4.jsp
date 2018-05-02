<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	<title>Ejemplo 4</title>
	<link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
	<%
	HashMap<String,String> nacionalidades = new HashMap<String,String>();
	HashMap<String,String> equipos        = new HashMap<String,String>();

	nacionalidades.put("AR", "Argentina");
    nacionalidades.put("BO", "Boliviana");
    nacionalidades.put("BR", "Brasileña");
    nacionalidades.put("CH", "Chilena");
    nacionalidades.put("PY", "Paraguaya");
    nacionalidades.put("UY", "Uruguaya");
    
    equipos.put("BE", "Belgrano");
    equipos.put("BC", "Boca");
    equipos.put("L", "Lanús");
    equipos.put("RA", "Racing");
    equipos.put("RV", "River");
    equipos.put("SL", "San Lorenzo");
	%>
	<h3>Formulario de carga de datos</h3>
    <table>
       	<colgroup>
       		<col width="20%" />
       		<col width="45%" />
       	</colgroup>
    	<tr>
             <th align="right">Apellido:</th>
             <td><%= request.getParameter("apellido") %></td>
        </tr>
		<tr>
             <th align="right">Nombre:</th>
             <td><%= request.getParameter("nombre") %></td>
		</tr>
		<tr>
             <th align="right">Clave:</th>
             <td><%= request.getParameter("clave") %></td>
		</tr>
		<tr>
             <th align="right">Confirmaci&oacute;n Clave:</th>
             <td><%= request.getParameter("confirmar_clave") %></td>
		</tr>
		<tr>
             <th align="right">Sexo:</th>
             <td><%= (request.getParameter("sexo").equals("F") ? "Femenino" : "Masculino") %></td>
		</tr>
		<tr>
             <th align="right">Nacionalidad:</th>
             <td><%= (request.getParameter("otra_nacionalidad") == null || request.getParameter("otra_nacionalidad").equals("") ? nacionalidades.get(request.getParameter("nacionalidad")) : request.getParameter("otra_nacionalidad")) %></td>
		</tr>
		<tr>
             <th align="right" valign="top">Equipo Favorito:</th>
             <td>
             <% 
             if(request.getParameterValues("equipo") != null) {
	             String eq[] = request.getParameterValues("equipo");
	             for(int i = 0, l = eq.length; i < l; i ++) {
	            	 out.println(equipos.get(eq[i]) + "; ");
	             }
             }
             else {
            	 out.println("Ninguno");
             }
             %>
             </td>
		</tr>
		<tr>
            <th align="right" valign="top">Hobbies:</th>
            <td>
            <% 
            String h[] = request.getParameterValues("hobbies");
            for(int i = 0, l = h.length; i < l; i ++) {
           	 	out.println(h[i] + "; ");
            }
            %>
            </td>
		</tr>
		<tr>
            <th align="right" valign="top">Otras Actividades:</th>
            <td><%= request.getParameter("actividades") %></td>
		</tr>
	</table>
	<br/>
	<a href="./ejemplo4.html">Volver</a>
</body>
</html>