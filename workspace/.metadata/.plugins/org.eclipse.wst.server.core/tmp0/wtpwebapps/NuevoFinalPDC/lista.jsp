<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="ar.edu.ubp.pdc.fdeschant.examen.RecursosBean,java.util.LinkedList "%>
    <%@taglib uri="/WEB-INF/tld/customs.tld" prefix="ct" %>
    
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./js/utils.js"></script>
<script type="text/javascript" src="./js/main.js"></script>
<link rel="stylesheet" type="text/css" href="./css/main.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recursos</title>
</head>
<body>
<p> Recursos </p>
<table>
			<thead>
				<tr>
					<th align="left">Recursos</th>
					<th align="left">Propietarios</th>
					<th align="left">nro recurso</th>
					<th align="left">vigente</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
	<tbody>
	<%
	
	LinkedList<RecursosBean> lista =(LinkedList<RecursosBean>)(request.getAttribute("lista"));
	for(int i= 0; i<lista.size();i++) {
		RecursosBean rec= lista.get(i);
		
	%>
		<tr id="<%= (i%2==0? "even":"odd")%>">
			<td><ct:temas todos="N" tipoRecurso="<%=rec.getCod_tipo_recurso() %>" nombre=""/></td>
			<td><ct:propietario tipoPropietario="<%=rec.getTipo_propietario() %>" nombre="" idArea="<%=rec.getNro_area() %>" idPersonal="<%=rec.getNro_leg_personal() %>"/>  <%=rec.getDesc_recurso() %></td>
			<td><%=rec.getNro_recurso() %></td>
			<td><%=rec.getVigente() %></td>
			
		</tr>
	<%
	}
	%>
	</tbody>
</table>
<a href="./guardar" onclick="jFinal.Guardar();">Guardar</a>
<a href="./index.jsp"> Cancelar</a>
</body>
</html>