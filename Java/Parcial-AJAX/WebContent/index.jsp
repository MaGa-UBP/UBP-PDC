<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mi Agenda</title>
<link rel="stylesheet" type="text/css" href="./assets/css/style.css">
<link rel="stylesheet" type="text/css" href="./assets/css/bootstrap.min.css">
</head>
<body>
	<div class="container">

		<div class="row">
			<div class="col-xs-12 col-md-6 col-lg-4">
				<h1>Mi Agenda</h1>
				<form id="formAgenda" method="post" action="index.jsp">
					<div class="row">
						<%  /* 	Creo un campo hidden input[name=descartar] para guardar un flag de si el 
							evento fue descartado o no. Default = false	*/
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
							
						%>
						<input type="hidden"  name="descartar" value="false"/>
			         			<div class="col-md-6">
							<div class="form-group">
						    	<label for="iFechaEvento">Fecha</label>
								<input type="date" <%= "value=\""+ df.format(new Date())+"\"" %> id="iFechaEvento" name="fecha" class="form-control" required >
						 	</div>
				 		</div>
				 		<div class="col-md-6">
							<label for="iPrioridad">Priodidad</label>
			                   <select id="iPrioridad" name="prioridad" class="form-control">
								<option value="Alta">Alta</option>
								<option value="Media" selected="selected">Media</option>
								<option value="Baja">Baja</option>
							</select>
				 		</div>
				 		<div class="col-md-12">
							<label for="iDescripcion">Descripcion</label>
							<textarea cols="50" rows="5" id="iDescripcion" name="descripcion" class="form-control" placeholder="Ingrese la descripción del evento" required></textarea>
				 		</div>
				 		<div class="col-md-4">
							<label for="iNotificacionS">Notificar</label>
							<div class="radio">
								<label><input type="radio" name="notif" value="S" id="iNotificacionS" checked="checked">Si</label>
								<label><input type="radio" name="notif" value="N" id="iNotificacionN">No</label>
							</div>
				 		</div>
				 		<div class="col-md-8">
							<label for="iEmail">Email a notificar</label>
							<input type="email" id="iEmail" name="email" class="form-control" placeholder="Ingrese el e-mail a notificar" required>
				 		</div>
				 		<div class="col-xs-12">
				 			<input type="submit"  name="btnSubmit" class="btn btn-primary" value="Agendar"/>
				 			<button type="reset"  name="btnReset" class="btn btn-warning">Limpiar</button>
				 		</div>
				 	</div>
				 </form>
			</div>
			<div class="col-xs-12 col-sm-10" id="results">
			<table class="table hidden">
				<thead><tr><th>#</th><th>Fecha</th><th>Descripci&oacute;n</th><th>Prioridad</th><th>Notificar a</th><th></th></tr></thead>  
				<tbody id="resultsTable"></tbody>
			</table>
			</div>
		</div>
	</div>

	<script src="./assets/js/jquery.min.js"></script>
	<script src="./assets/js/bootstrap.min.js"></script>
	<script src="./assets/js/validateForm.js"></script>
</body>
</html>