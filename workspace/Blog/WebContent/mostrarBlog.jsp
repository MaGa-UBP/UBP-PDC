<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="ar.edu.ubp.blog.beans.TemaBean, ar.edu.ubp.blog.beans.MensajeBean, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Blog</title>
	<link type="text/css" rel="stylesheet" href="./css/style.css" />
   	
   	<!-- Acá voy a querer mostrar todo lo que hace al aspecto visual del Blog -->
</head>
<body>

   	<%
   		@SuppressWarnings("unchecked")
		LinkedList<TemaBean> temas = (LinkedList<TemaBean>)request.getAttribute("temas");
   		@SuppressWarnings("unchecked")
   		LinkedList<MensajeBean> mensajes = (LinkedList<MensajeBean>)request.getAttribute("mensajes");
    %>
    <!-- Voy a querer volver a mandar todo al index, con nuevos parámetros -->
    
    <form id="form" method="post" action="index.jsp">
    
    <input type="hidden" name="tema_elegido" id="tema_elegido" value="">
    <div class="container">
    	<div id="sidebar">
        
	        <h2> Otros temas </h2>
		<%
	    	for(int i=1; i < temas.size(); i++){
	    		Integer nroT = temas.get(i).getNroTema();
	    		out.println("<a href=\"#\" onclick=\"jBlog.enviar('"+nroT.toString()+"')\">"+temas.get(i).getTitulo_res_tema()+"</a>");
	    		out.println("<br>");
	    	}
		%>
			<br>
    	</div>
    	
	    <div id="content">
		    <!-- titulo del tema elegido -->
	    	<h1> <%=  temas.get(0).getTitulo_tema() %> </h1>
			<!-- texto del tema elegido -->
	    	<% out.println(temas.get(0).getTexto_tema());
    	
	    	out.println("<b>Fecha registro: "+temas.get(0).getFecha_registro());
	    	out.println("/ Publicado en: "+ temas.get(0).getWeb_publ_tema()+"</b> <br>");
    	
    		//Acá se empiezan a mostrar los comentarios
    		out.println("<div id=\"mensajes\">");
    		for (MensajeBean mensaje : mensajes){
	    		out.println("<div class=\"mensaje\">");
	    		out.println("<p class=\"textoMensaje\">"+mensaje.getTexto_mensaje()+"</p>");
	    		out.println("<h4 class=\"adicionales\">");
	    		out.println(mensaje.getFecha_registro());
	    		out.println("/ Coment&oacute;: "+ mensaje.getAutor()+"</h4>");
	    		out.println("</div>");	
    		}%>
    	</div>
    	
    	</form>
    	
    	<%
    		String datosAutor = (request.getAttribute("autorComentarioBlog") == null ? "" : request.getAttribute("autorComentarioBlog").toString());
    		String autor = "";
    		String email = "";
    		if (!datosAutor.equals("")){
    			String datos[]= datosAutor.split(";");
    			autor = datos[0];
    			email = datos[1];
    		}
    	%>
    	
    	<hr></hr>
    	<form id="comentarios" action="insertarComentario.jsp" method="post" > 
    	<h5>Por favor, déjenos su comentario</h5>
    	
    	<input type="hidden" name="tema_elegido" id="tema_elegido" value="<%out.print(temas.get(0).getNroTema());%>">
    	
    	<input type="hidden" id="ultimoAutor" name="ultimoAutor">
    	
    	<label for="autor">Nombre</label>
    	<br>
    	<input type="text" id="autor" name="autor" maxlength="100" value="<%out.print(autor);%>">
    	<br><br>
    	<label for="emailAutor"> Email </label>
    	<br>
    	<input type="text" id="emailAutor" name="emailAutor" maxlength="100" value="<%out.print(email);%>">
    	<br><br>
    	<label for="textoMensaje"> Su comentario</label>
    	<br>
    	<textarea rows="20" cols="50" id="textoMensaje" name="textoMensaje" maxlength="255"></textarea>
    	<br><br>
    	<input type="checkbox" id="recordar" name="recordar" checked > Recordar mis datos para la próxima visita
    	<br><br>
    	
    	<input type="button" name="publicar" id="publicar" value="Publicar" onclick="jBlog.publicar()">
    	</div>
    	</form>
        
    </div>
   	
   	<script type="text/javascript" src="./js/jquery.js"></script>
   	<script type="text/javascript" src="./js/blog.js"></script>
   	

</body>
</html>