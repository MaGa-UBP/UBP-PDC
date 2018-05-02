package ar.edu.ubp.pdc.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;


	public class NotasTagHandler extends SimpleTagSupport {
		private String nombre;
		private String funcion;
		private String caracteres;
		
		@Override
		public void doTag() throws JspException, IOException
		{
			super.doTag();	
			JspWriter out = this.getJspContext().getOut();
			
			//String nombre = (this.nombre == null ? "" : this.nombre);
			String caracteres = (this.caracteres == null ? "255" : this.caracteres);
			out.println("<form>");
				out.println("<table>");
					out.println("<tr><th align=\"center\">");
						out.println("Nueva Nota");
					out.println("</th></tr>");
					out.println("<tr><td>");
						out.println("<textarea cols=\"50\" rows=\"8\" id=\"inota\" name=\""+nombre+"\" onkeyup=\"return jNotas.validActLen(this)\"></textarea>");
						out.println("<h5><span id=\"icact\"></span> / "+caracteres+" caracteres</h5>");
						out.println("<script type=\"text/javascript\">jNotas.setActLen("+caracteres+");</script>");
					out.println("</td></tr>");
					out.println("<tr><td>");
						out.println("<input type=\"button\" name=\"guardar\" value=\"Guardar\" onclick=\""+funcion+"\"/>");
						out.println("<input type=\"button\" name=\"cacelar\" value=\"Cancelar\" onclick=\"jNotas.cancelar()\"/>");
					out.println("</td></tr>");				
				out.println("</table>");
			out.println("</form>");
			

		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public void setFuncion(String funcion) {
			this.funcion = funcion;
		}
		
		public void setCaracteres(String caracteres) {
			this.caracteres = caracteres;
		}
	}

