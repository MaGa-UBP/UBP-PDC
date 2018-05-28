package ar.edu.ubp.pdc.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CriterioBusquedaTagHandler extends SimpleTagSupport {

	public String funcionJS;
	
	public void setFuncionJS(String funcionJS) {
		this.funcionJS = funcionJS;
	}

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		super.doTag();
		
		JspWriter out = this.getJspContext().getOut();
		
		out.println("<label for=\"istring_busqueda\">Solicitante | Asunto | Texto</label>");
		out.println("<div class=\"form-group\"><input id=\"istring_busqueda\" class=\"form-control\" type=\"text\" name=\"string_busqueda\" maxlength=\"255\"></div>");
		
		out.println("<fieldset>");
		out.println("<legend>Ordenar Por</legend>");
		out.println("<input type=\"radio\" id=\"S\" name=\"ordenar_por\" value=\"S\"><label for=\"S\">Por solicitante</label>");
		out.println("<input type=\"radio\" id=\"F\" name=\"ordenar_por\" value=\"F\" checked=\"checked\"><label for=\"S\">Por Fecha</label>");
		out.println("<input type=\"radio\" id=\"T\" name=\"ordenar_por\" value=\"T\"><label for=\"S\">Por n&uacute;mero</label>");
		out.println("</fieldset>");
		out.println("<button class=\"btn btn-primary\" onclick=\""+funcionJS+"\">Buscar</button>");
	}
}
