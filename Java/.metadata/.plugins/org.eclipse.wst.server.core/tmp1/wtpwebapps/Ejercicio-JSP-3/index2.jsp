<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.concurrent.TimeUnit, java.util.Arrays"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quini 6</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<h1>Quini 6</h1>
	<%!
		int i = 0;
		String[] bolillas = new String[6];
	%>
	<%
	String arrInputs[] = request.getParameterValues("bolillas");
	if(arrInputs != null){
		for(String inp : arrInputs){
			out.println(inp);
		}
	}
	%>
	<form method="post">	
		<%
		i++;
		if(i<6){
			out.println("<input name=\"iniciar\" type=\"hidden\" value=\"true\">");
		}else{
			out.println("<input name=\"iniciar\" type=\"hidden\" value=\"false\">");
		}
		int nuevaBolilla = -1;
		if(request.getParameter("iniciar")!=null){
			if(request.getParameter("iniciar").equals("true")){
				if(arrInputs != null){
					for(String inp : arrInputs){
						out.println("<input name=\"bolillas\" type=\"hidden\" value=\""+inp+"\">");
					}	
				}
				nuevaBolilla = Double.class.cast(Math.random() * 45).intValue();
				while(Arrays.asList(bolillas).contains(Integer.toString(nuevaBolilla))){
					nuevaBolilla = Double.class.cast(Math.random() * 45).intValue();
				}
				out.println("<input name=\"bolillas\" type=\"hidden\" value=\""+nuevaBolilla+"\">");
			}
		}
		
		%>
		<input id="submit" type="submit" class="btnQuini" value="Iniciar Sorteo"
<%-- 		<%
		if(request.getParameter("iniciar")!=null){
			if(request.getParameter("iniciar").equals("true")){
				out.println("disabled=\"disabled\"");
			}	
		}%> --%>
		>
	</form>
	<%
		if(nuevaBolilla != -1){
			out.println("<div class=\"bolillaNueva\">");
			out.println(nuevaBolilla);
			out.println("</div>");
		}
	%>
	<script>
	<%
	out.println("var cantBolillas = "+i+";");
	%>
	</script>

	
 	<script src="./js/jquery.min.js"></script>
	<script src="./js/validateForm.js"></script> 
</body>
</html>