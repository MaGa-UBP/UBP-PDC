<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="ct" uri="/WEB-INF/tld/customs.tld" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tickets</title>
	<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="./css/styles.css">
	<script src="./js/jquery.js" type="text/javascript"></script>
	<script src="./js/tickets.js" type="text/javascript"></script>
	<script src="./js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
	<div class="container">
		<%!
		
		public String getCookieValue(Cookie[] cookies, String name){
			for(Cookie c : cookies){
				if(c.getName().equals(name)){
					return c.getValue();
				}
			}
			return "";
		}
		%>
		<h3>Tickets</h3>
		<div id="message"></div>
		<div id="tickets" class="row">
			<div class="col-xs-12">
			<form id="form" action="javascript:void(null)" method="post">
				<ct:crit_busq_tickets funcionJS="jTickets.buscar()"/>
				<div id="result"></div>
			</form>
			<script type="text/javascript">
			jTickets.buscar();
			</script>
			</div>
		</div>
		
		<%
		
		Cookie cookies[] = request.getCookies();
		String solicitante = getCookieValue(cookies, "solicitante");
		String emailSolicitante = getCookieValue(cookies, "email_solicitante");
		
		%>
		<div id="ticket">
			<div id="executing"></div>
			<form id="ticket_form" action="javascript:void(null)" method="post" onsubmit="jTickets.registrar(event)">
				<div class="row">
					<div class="col-xs-12 col-md-6">
						<div class="row form-group">
							<label for="isolicitante" class="col-sm-2 control-label">Solicitante</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="isolicitante" name="solicitante" placeholder="solicitante" maxlength="255" required value="<%= solicitante %>">
							</div>
						</div>
					</div>
					<div class="col-xs-12 col-md-6">
						<div class="row form-group">
							<label for="iemail" class="col-sm-2 control-label">Email</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="iemail" placeholder="Email" name="email_solicitante" maxlength="255" required value="<%= emailSolicitante %>">
							</div>
						</div>
					</div>
					<div class="col-xs-12">
						<div class="row form-group">
							<label for="iasunto" class="col-sm-1 control-label">Asunto</label>
							<div class="col-sm-11">
								<input type="text" class="form-control" id="iasunto" placeholder="Asunto" name="asunto_ticket" maxlength="255" required>
							</div>
						</div>
					</div>
					
					<div class="col-xs-12">
						<label for="iasunto">Texto</label>
						<textarea class="form-control" name="texto_ticket" cols="50" rows="20" ></textarea>
					</div>
				</div>
				
				<div class="row">
					<div class="col-lg-12">
						<button class="btn btn-success" type="submit">Registrar</button>
						<button class="btn btn-danger" type="reset">Cancelar</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	
</body>
</html>