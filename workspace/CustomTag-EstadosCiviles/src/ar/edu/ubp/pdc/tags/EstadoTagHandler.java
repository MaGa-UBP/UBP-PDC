package ar.edu.ubp.pdc.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class EstadoTagHandler extends SimpleTagSupport {
	private String  name;
	private String 	selected;
	
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		JspWriter out = this.getJspContext().getOut();
		
		String name = ((this.name == null)?"cod_estado_civil" : this.name);		
		String estados[]= {"Soltero","Casado","Separado","Divorciado","Viudo","Otro"}; 
		
		out.println("<select name=\"" + name + "\">");
		out.println("<option value=\"\">Debe seleccionar un estado civil</option>");
		for(int i=0;i<6;i++){
			out.println("<option "  + (selected != null && selected.equals(estados[i]) ? "selected" : "")  + " value="+estados[i]+">"+estados[i]+"</option>");
		}
		out.println("</select>");
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}
	
}
