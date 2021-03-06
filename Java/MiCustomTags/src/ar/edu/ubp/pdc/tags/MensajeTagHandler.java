package ar.edu.ubp.pdc.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MensajeTagHandler extends SimpleTagSupport {
	
	private String nombre;
	private String apellido;
	
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		super.doTag();
		JspWriter out = this.getJspContext().getOut();
		out.println("Hola "+ this.nombre + " " + (this.apellido == null ? "" : this.apellido));
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
