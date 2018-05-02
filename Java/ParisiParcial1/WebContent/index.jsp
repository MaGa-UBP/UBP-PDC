<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Parcial 1</title>
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="./css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="./css/style.css">
    <script type="text/javascript" src="./js/bootstrap.min.js"></script>
    <script type="text/javascript" src="./js/jquery.min.js"></script>
    <script type="text/javascript" src="./js/validationForm.js"></script> 
</head>

<body>
	<h3> Mi agenda</h3>
	<%
	if(request.getParameterMap().size() == 0) {
	%>
	<div>
		<form method="post" id="formAgenda" action="index.jsp" class="col-md-12 order-md-1" onsubmit="jForm.valid(event)">
			<div class="row">
       			<div class="col-md-2 mb-3">
             		<label for="ifecha">Fecha</label>
					<input type="date" id="ifecha" name="fecha" class="form-control" required value="">
           		</div>
         		<div class="col-md-2 mb-3">
					<label for="iprioridad">Prioridad</label>
					<select id="iprioridad" name="prioridad" class="form-control" required onchange="jForm.selPrioridad(this)">
						<option value="A">Alta</option>
						<option value="M" selected="selected">Media</option>
						<option value="B">Baja</option>
					</select>
				</div>
       		</div>
       		<div class="row">
     			<div class="col-md-4 mb-3">
					<label for="idescripcion">Descripcion</label>
                	<textarea cols="50" rows="5" id="idescripcion" name="descripcion" class="form-control" placeholder="Ingrese la descripcion del evento" required></textarea>
       			</div>
   			</div>
   			
   			<div class="row">
         		<div class="col-md-2 mb-3">
         			<div class="single-line">
         			  <label for="inotificarsi">Notificar</label>
						<div class="radio">
							<label><input type="radio" name="notificar" value="S" id="inotificarsi" checked="checked" onchange="jForm.selNotificar(this)">Si</label><br>
						</div>
						<div class="radio">
							<label><input type="radio" name="notificar" value="N" id="inotificarno" onchange="jForm.selNotificar(this)">No</label>
						</div>
         			</div>
					
				</div>
            	<div class="col-md-2 mb-3">
                	<label for="iemail">E-mail a notificar</label>
					<input type="email" id="iemail" name="email" class="form-control" required  placeholder="Ingrese e-mail a notificar" value="" maxlength="255">
       			</div>
			</div>
			<div class="row">
				<div class="col-lg-4">
					<button type="submit" name="boton1" class="btn btn-primary">Agendar</button>
					<button type="reset"  name="boton2" class="btn btn-warning">Limpiar</button>
				</div>
    		</div>
		</form>
	</div>
	
	<%
	}
	else {

	HashMap<String,String> prioridades = new HashMap<String,String>();

	//SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
	//SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	
	//Date fecha = parser.parse(request.getParameter("fecha"));

	prioridades.put("A", "Alta");
    prioridades.put("M", "Media");
    prioridades.put("B", "Baja");    
%>

 		<h3>Formulario de carga de datos</h3>
    <table class="table table-striped">
       	<colgroup>
       		<col width="15%" />
       	</colgroup>
       	<thead>
       		<tr>
       		 <td align="right">#</td>
             <td align="right">Fecha</td>
             <td align="right">Descripcion</td>
             <td align="right">Prioridad</td>
             <td align="right">Notificar a</td>
             <td align="right">    </td>
        	</tr>
       	</thead>
       	<tbody>
       		<tr>
       			<td align="right">  </td>
       			<td align="right"> <%= request.getParameter("fecha") %>  </td>
       			<td align="right"> <%= request.getParameter("descripcion") %>  </td>
       			<td align="right"> <%= prioridades.get(request.getParameter("prioridad")) %> </td>
       			<td align="right"> <%= request.getParameter("email") %>  </td>
       			<td align="right"> <button type="reset" name="boton3" onsubmit="jForm.click(event)">Descartar</button>  </td>
       		</tr>
       	</tbody>
	</table>
	<br/>
	<%
	}
	%>


</body>
</html>