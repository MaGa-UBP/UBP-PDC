<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Ejercicio 04/04/2018</title>
	<link rel="stylesheet" type="text/css" href="./bootstrap.3.3.7/content/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="./bootstrap.3.3.7/content/bootstrap-theme.min.css">
    <script type="text/javascript" src="./bootstrap.3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
<%

%>

<div class="container">
	<div class="row">
		<div class="col-xs-10 col-md-8 col-xs-offset-0 col-md-offset-2">
		<h1>Inputs:</h1>
			<form class="form-horizontal" action="index.jsp" method="POST">
				<% 
				String arrInputs[] = request.getParameterValues("inputs");
				if(arrInputs != null){
					for(String inp : arrInputs){
						out.println("<div class=\"form-group\">");
						out.println("<div class=\"col-sm-10\">");
						out.println("<input type=\"text\" class=\"form-control\" name=\"inputs\" value=\"" + inp +"\">");
						out.println("</div></div>");
					}
				}
				out.println("<div class=\"form-group\">");
				out.println("<div class=\"col-sm-10\">");
				out.println("<input type=\"text\" class=\"form-control\" name=\"inputs\">");
				out.println("</div></div>");
				%>	
			<div class="form-group">
			  	<div class="col-sm-offset-2 col-sm-10">
			    	<button type="submit" class="btn btn-default">Agregar</button>
			  	</div>
			</div>
			</form>
		</div>
	</div>
</div>
				

</body>
</html>