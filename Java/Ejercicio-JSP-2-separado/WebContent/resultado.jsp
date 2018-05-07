<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%

	List<List<String>> equipos = new ArrayList<List<String>>();
	if(equipos.size() == 0) {
		equipos.add(Arrays.asList("EQUIPO A", "EQUIPO B"));
		equipos.add(Arrays.asList("EQUIPO C", "EQUIPO D"));
		equipos.add(Arrays.asList("EQUIPO E", "EQUIPO F"));
		equipos.add(Arrays.asList("EQUIPO G", "EQUIPO H"));
		equipos.add(Arrays.asList("EQUIPO I", "EQUIPO J"));
		equipos.add(Arrays.asList("EQUIPO K", "EQUIPO L"));
		equipos.add(Arrays.asList("EQUIPO M", "EQUIPO N"));
		equipos.add(Arrays.asList("EQUIPO O", "EQUIPO P"));
		equipos.add(Arrays.asList("EQUIPO Q", "EQUIPO R"));
		equipos.add(Arrays.asList("EQUIPO S", "EQUIPO T"));
	}

		Random random = new Random();
	if(request.getParameterValues("resultados") != null){
		String resultados [] = request.getParameterValues("resultados");
		out.println("<div class=\"colInline\">");
		out.println("<h1>Resultados</h1>");
		out.println("<table>");
		out.println("<tr><th>Equipo</th><th>L</th><th>V</th><th>Equipo</th></tr>");

		int i=0;
		int cantCorrectos = 0, cantIncorrectos = 0;
		for(List<String> match : equipos){
			Integer l = random.nextInt(6);
			Integer v = random.nextInt(6);
			
			String scores="";
			if(l>v){
				scores="izq";
			}else if(l<v){
				scores="der";
			}else{
				scores="empate";
			}
			String classRes = "";
			
			if(scores.equals(resultados[i])){
				classRes = "success";
				cantCorrectos++;
			}else{
				classRes = "error";
				cantIncorrectos++;
			}
			out.println("<tr class=\""+ classRes +" filaPartido\">");
			out.println("<td>"+match.get(0)+"</td>");
			out.println("<td>"+l+"</td>");
			out.println("<td>"+v+"</td>");
			out.println("<td>"+match.get(1)+"</td>");
			out.println("</tr>");
			i++;
		}
		out.println("</table>");
		out.println("</div>");
		
		out.println("<div class=\"colInline\">");
		out.println("<h1>Estad&iacute;sticas</h1>");
		out.println("<p>Resultados correctos: "+cantCorrectos+"</p>");
		out.println("<p>Resultados incorrectos: "+cantIncorrectos+"</p>");
		out.println("</div>");
	}
%>