<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date,  java.util.Locale, java.text.DateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mi Agenda - Parcial PDC</title>
<link rel="stylesheet" type="text/css" href="./assets/css/style.css">
<link rel="stylesheet" type="text/css" href="./assets/bootstrap.3.3.7/content/bootstrap.min.css">

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-6 col-lg-4">
				<h1>Mi Agenda</h1>
				<form id="formAgenda" method="post" action="index.jsp">
				<%
				String [] descripciones = request.getParameterValues("descripcion");
				String [] fechas = request.getParameterValues("fecha");
				String [] prioridad = request.getParameterValues("prioridad");
				String [] notifEmail = request.getParameterValues("email");
				String [] descartadas = request.getParameterValues("descartar");

				//Creo hiddens para recuperar valores de eventos guardados anteriormente
				if(descripciones != null && fechas != null  && prioridad != null && notifEmail != null){
					int i = 0;
					for(String descripcion : descripciones){
						out.println("<input type=\"hidden\" name=\"fecha\" value=\""+fechas[i]+"\">");
						out.println("<input type=\"hidden\" name=\"descripcion\" value=\""+descripcion+"\">");
						out.println("<input type=\"hidden\" name=\"prioridad\" value=\""+prioridad[i]+"\">");
						out.println("<input type=\"hidden\" name=\"email\" value=\""+notifEmail[i]+"\">");
						out.println("<input type=\"hidden\" name=\"descartar\" id=\"descartar_"+i+"\" value=\""+descartadas[i]+"\">");
						i++;
					}
				}

				
				//Creo date para setear valor en input[name=fecha]
				Locale     locale;
				DateFormat df, df2;
				String     date, date2;

				locale = request.getLocale();
				df     = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
				date   = df.format(new Date());
				
				df2     = DateFormat.getDateInstance(DateFormat.SHORT, locale);
				date2   = df2.format(new Date());
				
				date = date.split("-")[2]+"-"+ date2.split("/")[1]+"-"+ date.split("-")[0];
				
				%>
					<div class="row">
						<%  /* 	Creo un campo hidden input[name=descartar] para guardar un flag de si el 
							evento fue descartado o no. Default = false	*/
						%>
						<input type="hidden"  name="descartar" value="false"/>
            			<div class="col-md-6">
							<div class="form-group">
						    	<label for="iFechaEvento">Fecha</label>
								<input type="date" <%= "value=\""+date+"\"" %> id="iFechaEvento" name="fecha" class="form-control" required >
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
		</div>
		
		<%
			//Creo tabla de resultados con los datos de los eventos anteriores y el ultimo agregado
			if(descripciones != null && fechas != null  && prioridad != null && notifEmail != null){
				out.println("<div class=\"row\">");
				out.println("<div class=\"col-xs-12 col-sm-8\">");
				out.println("<table  class=\"table\">");
				out.println("<thead><tr><th>#</th><th>Fecha</th><th>Descripci&oacute;n</th><th>Prioridad</th><th>Notificar a</th><th></th></tr></thead>  <tbody>");
				int i = 0;
				for(String descripcion : descripciones){
					out.println("<tr "+(descartadas[i].equals("true")? "class=\"recuperar\"" : "")+">");
					out.println("<td class=\"numero\">"+(i+1)+"</td>");
					out.println("<td class=\"decorate\">"+fechas[i]+"</td>");
					out.println("<td class=\"decorate\">"+descripcion+"</td>");
					out.println("<td class=\"decorate\">"+prioridad[i]+"</td>");
					/* 	Uso texto "N" para cuando el email no está informado y asi poder mantener el index igual
						para todos los campos. Si el texto no es "N" muestro el mail, sino no muestro nada			*/
					out.println("<td class=\"decorate\">"+(!notifEmail[i].equals("N")? notifEmail[i] : " ")+"</td>");
					/* 	Controlo si el evento fue descartado o no emdiante el hidden generado para esto	*/
					out.println("<td><a href=\"#\" class=\"btnDescartar\">"+(descartadas[i].equals("false")? "Descartar" : "Recuperar")+"</a></td>");
					out.println("</tr>");
					i++;
				}
				
				
				out.println(" </tbody></table");
				out.println("</div>");
				out.println("</div>");
			}
		%>
	</div>
	
	
	<script src="./assets/js/jquery.min.js"></script>
	<script src="./assets/bootstrap.3.3.7/Scripts/bootstrap.min.js"></script>
	<script src="./assets/js/validate.js"></script>
</body>
</html>