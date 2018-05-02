<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.LinkedList,ar.edu.ubp.pdc.beans.TemaBean"%>

    
<%@taglib uri="/WEB-INF/tld/customs.tld" prefix="ct" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Final PDC</title>
		<meta name="author" content="Cenzano">
		<link rel="stylesheet" type="text/css" href="./css/style.css"/>
	    <script type="text/javascript" src="./js/jquery.js"></script>
	    <script type="text/javascript" src="./js/utils.js"></script>
	    <script type="text/javascript" src="./js/main.js"></script>
	</head>
<body>

	<h3 class="tittle">Temas registrados</h3>
	<div id="message"></div>
	<form id="form" action="javascript:void(null);" method="post">
		<table id="tableTemas">
			<thead id="theadTemas">
				<tr>
					<!--<th align="left">nro tema</th>-->
					<th align="left">nro grupo de atencion</th>
					<th align="left">desc tema</th>
					<th align="left">vigente</th>
					<!--  <th>&nbsp;</th>-->
				</tr>
			</thead>
			<tbody>
			<%
			@SuppressWarnings("unchecked")
			LinkedList<TemaBean> temas = (LinkedList<TemaBean>)request.getAttribute("temas");
            for(TemaBean tema : temas) {
			    out.println("<tr>");
                //out.println("<td>" + tema.getNroTema() + "</td>");
                out.println("<td>");
                %>
                <ct:listaGrupo name="listGroup" grupo="<%= tema.getNroGrupoAtencion() %>"/>
                <%
                out.println("</td>");
                out.println("<td><input type=\"text\" name=\"inputDescTema\" value=\"" + tema.getDescTema() + "\" /></td>");
                out.println("<td><input type=\"checkbox\" name=\"checkVigente\" value=\"" + tema.getVigente() + "\""+ (tema.getVigente().equals("S") ? "checked" : "") +" onchange=\"jFinal.vigencia(this)\" /></td>");
                out.println("</tr>");
            } 
			%>
			</tbody>
		</table>
		<br/>
		<a href="#" class="link" onclick="jFinal.guardarTemp()">Guardar temporalmente</a>
		<a href="#" class="link" onclick="jFinal.guardar()">Guardar</a>
		<a href="#" class="link" onclick="">Cancelar</a>
	</form>	
	
</body>
</html>