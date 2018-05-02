package ar.edu.ubp.pdc.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class BusquedaTagHandler extends SimpleTagSupport {
	
	private String  funcion;
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		super.doTag();
		JspWriter out = this.getJspContext().getOut();
			
		String funcion=this.funcion;
		out.println("<form action=\"javascript:void(0)\" id=\"form\" >");
		out.println("<table>");
			out.println("<tr>");
				out.println("<td>");
					out.println("<p>Solicitante|Asunto|Texto</p>");
					out.println("<input type=\"text\" name=\"busqueda\">");
				out.println("</td>");
				out.println("<td>");
					out.println("<fieldset>");
						out.println("<p>Ordenar por:</p>");
						out.println("<input type=\"radio\" name=\"ordenar\" value=\"S\" id=\"isolicitante\" /><label for=\"isolicitante\">Solicitante</label>");
						out.println("<input type=\"radio\" name=\"ordenar\" value=\"F\" id=\"ifecha\" checked=\"checked\" /><label for=\"ifecha\">Fecha</label>");
						out.println("<input type=\"radio\" name=\"ordenar\" value=\"N\" id=\"inumero\" /><label for=\"inumero\">Nro. de Ticket</label>");
					out.println("</fieldset>");
				out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td><input type=\"button\" name=\"buscar\" value=\"Buscar\" id=\"buscar\" id=\"buscar\" onclick="+funcion+" /></td>");

		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		
	}
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	
}
