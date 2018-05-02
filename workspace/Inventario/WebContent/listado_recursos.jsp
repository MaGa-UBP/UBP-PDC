<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.LinkedList,ar.edu.ubp.pdc.beans.RecursoBean" %>
<%@ taglib prefix="ct" uri="/WEB-INF/tld/custom.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="./css/style.css" />

<title>Inventario</title>

<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./js/utils.js"></script>
<script type="text/javascript" src="./js/recursos.js"></script>
</head>
<body>
<h3>Inventario</h3>
<table>
<tr>
	<th>Descripci&oacute;n</th>
	<th>Tipo</th>
	<th>Tipo de Propietario</th>
	<th>Propietario</th>
	<th>Vigente</th>
</tr>
<%
int i = 0;
LinkedList<RecursoBean> recursos = (LinkedList<RecursoBean>)request.getAttribute("recursos");
for(RecursoBean r : recursos) {
%>
<tr>
	<td><input type="text" name="desc_recurso" maxlength="255" size="50" value="<%= r.getDescRecurso() %>" <%= r.getVigente().equals("S") ? "" : "disabled" %>/></td>
	<td><ct:tipos_recursos nombre="<%= \"cod_tipo_recurso_\" + (i++) %>" incluirTodos="N" codTipoRecurso="<%= r.getCodTipoRecurso() %>" habilitado="<%= r.getVigente() %>" /></td>
	<td>
		<select name="tipo_propietario" onchange="jRecursos.getPropietarios(this,'<%= i %>')" <%= r.getVigente().equals("S") ? "" : "disabled" %>>
			<option value="A" <%= r.getTipoPropietario().equals("A") ? "selected" : "" %>>&Aacute;rea</option>
			<option value="P" <%= r.getTipoPropietario().equals("P") ? "selected" : "" %>>Empleado</option>
		</select>
	</td>
	<td id="prop_<%= i %>">
		<ct:propietarios nombre="propietario" tipoPropietario="<%= r.getTipoPropietario() %>" codArea="<%= r.getNroArea() %>" nroLegPersonal="<%= r.getNroLegPersonal() %>" habilitado="<%= r.getVigente() %>" />
	</td>
	<td>
		<input type="checkbox" name="vigente" value="<%= r.getVigente() %>" <%= r.getVigente().equals("S") ? "checked" : "" %> />
		<input type="hidden" name="nro_recurso" value="<%= r.getNroRecurso() %>" />
 	</td>
</tr>
<%	
}
%>


</table>



</body>
</html>