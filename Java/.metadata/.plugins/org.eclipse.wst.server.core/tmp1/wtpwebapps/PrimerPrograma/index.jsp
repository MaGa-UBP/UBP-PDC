<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Primer Programa JSP</title>

<link rel="stylesheet" type="text/css" href="./assets/css/style.css">


<link rel="stylesheet" type="text/css" href="./assets/bootstrap.3.3.7/content/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./assets/bootstrap.3.3.7/content/bootstrap-theme.min.css">
<script type="text/javascript" src="./assets/bootstrap.3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<%-- Declaraciones globales (Scope application) --%>
<%!
	int contador = 0;
%>
	<div class="container">
		<div class="row">
			<div class="col-xs-10 col-md-8 col-xs-offset-0 col-md-offset-2">
				<form class="form-horizontal" action="calculos.jsp" method="POST">
					<div class="form-group">
						<label for="inputValor1" class="col-sm-2 control-label">Valor 1</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="inputValor1" name="inputValor1">
						</div>
					</div>
					<div class="form-group">
						<label for="inputValor2" class="col-sm-2 control-label">Valor 2</label>
						<div class="col-sm-10">
					    	<input type="number" class="form-control" id="inputValor2" name="inputValor2">
					  	</div>
					</div>
					<div class="form-group">
					  	<div class="col-sm-offset-2 col-sm-10">
					    	<button type="submit" class="btn btn-default">Calcular</button>
					  	</div>
					</div>
				</form>
				<p><%= ++contador %></p>
				<a href="index.jsp">Recargar</a>
			</div>
		</div>
	</div>
</body>
</html>