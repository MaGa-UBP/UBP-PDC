<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	HashMap<String, String> mapNacionalidades;
	mapNacionalidades = new HashMap<String,String>();
	mapNacionalidades.put("AR", "Argentina");
	mapNacionalidades.put("BO", "Boliviana");
	mapNacionalidades.put("BR", "Brasile&ntilde;a");
	mapNacionalidades.put("CH", "Chilena");
	mapNacionalidades.put("PY", "Paraguaya");
	mapNacionalidades.put("UR", "Uruguaya");
	
	
	HashMap<String, String> mapEquipos;
	mapEquipos = new HashMap<String,String>();
	mapEquipos.put("BE", "Belgrano");
	mapEquipos.put("BC", "Boca");
	mapEquipos.put("L", "Lan&uacute;s");
	mapEquipos.put("RA", "Racing");
	mapEquipos.put("RV", "River");
	mapEquipos.put("SL", "San Lorenzo");	
	
%>
<table>
	<tr>
		<th>Apellido</th>
		<td><%= request.getParameter("apellido") %></td>
	</tr>
	<tr>
		<th>Sexo</th>
		<td><%= request.getParameter("sexo").equals("F") ? "Femenino" : "Masculino" %></td>
	</tr>
	<tr>
		<th>Nacionalidad</th>
		<td><%= !request.getParameter("nacionalidad").equals("-1") ?  mapNacionalidades.get(request.getParameter("nacionalidad")) : request.getParameter("otra_nacionalidad")  %></td>
	</tr>
	<tr>
		<th>Equipo</th>
		<td>
			<%
				/* String arrEquipos[] = request.getParameterValues("equipo");
			 	for(int i = 0; i<arrEquipos.length; i++){
					out.println(mapEquipos.get(arrEquipos[i]) +";");
				} */
			 	if(request.getParameterValues("equipo") != null){
			 		for(String e : request.getParameterValues("equipo")){
						out.println(mapEquipos.get(e) +";");
					}
			 	}else{
			 		out.println("Ninguno");
			 	}
				
			%>
		</td>
	</tr>
	<tr>
		<th>Hobbies</th>
		<td>
		<%
			/* String arrHobbies[] = request.getParameterValues("hobbies");
		 	for(int i = 0, l = arrHobbies.length; i<l; i++){
				out.println(arrHobbies[i] +";");
			} */
			for(String h : request.getParameterValues("hobbies")){
				out.println(h +";");
			}
		%>
		</td>
	</tr>
</table>
</body>
</html>