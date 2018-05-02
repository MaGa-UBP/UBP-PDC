<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.LinkedList"%>
    <%@ taglib prefix="ct" uri="/WEB-INF/tld/custom.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Fechas de examenes</title>

<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./js/utils.js"></script>
<script type="text/javascript" src="./js/main.js"></script>
</head>
<body>
<form id="form" action="javascript:void(null)" method="post">
	<fieldset title="Datos de la fecha" style="width:580px">
	<legend>Datos de la fecha</legend>
		<label>Carrera</label>
		<ct:carreras nombre="carreras" funcion="algo" obligatoria="si"/><br/><br/>
		<label for="prev">Prevista</label><input type="radio" name="op" value="prevista" id="prev" checked />
        <label for="conf">Confirmada</label><input type="radio" name="op" value="confirmada" id="conf" />
        <div id="divfecha">
        	<label>Fecha Examen</label><input type="text" name="fecha"/>
        </div>
        <div id="divfechas">
        	<label>Fecha desde</label><input type="text" name="fechas1"/>
        	<label>Fecha hasta</label><input type="text" name="fechas2"/>
        </div>
	</fieldset>
	&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<label>marcar</label> 
	&emsp;<a id="todas" href="#">Todas</a>&emsp;<label>/</label>&emsp;<a id="ultimas" href="#">Ultimas seleccionadas</a>
	<div id="divsedes"></div>
	<br/>
	<div id="divbotones">
		<input type="button" name="guardar" value="Gruardar" onclick="jMain.guardar()"/>
		<input type="button" name="cancelar" value="Cancelar" onclick="jMain.cancelar()"/>
	</div>
	<div id="response"></div>
	<div id="aux"></div>
	<input type="hidden" name="ult" value="no">
	<%	
	//@SuppressWarnings("unchecked")
	/*LinkedList<String> ultimasSeleccionadas = (LinkedList<String>) request.getSession().getAttribute("ultimaSel");
	for(int i=0;i<ultimasSeleccionadas.size();i++){
		out.println(ultimasSeleccionadas.get(i)); 	
	}
	String [] ultimaSel =(String[]) request.getSession().getAttribute("ultimaSel");
	for(int i=0;i<ultimaSel.length;i++){
		out.println(ultimaSel[i]); 	
	}*/
	//out.println(request.getSession().getAttribute("ultimaSel"));
	//Integer [] ultimaSel =(Integer[]) request.getSession().getAttribute("ultimaSel");
	/*String [] ultimaSel =(String[]) request.getSession().getAttribute("ultimaSel");

	for(int i=0;i<ultimaSel.length;i++){
		out.println(ultimaSel[i]); 	
	}*/
	
	%>
	
</form>
</body>
</html>