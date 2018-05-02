package ar.edu.ubp.blog.beans;

public class MensajeBean {

	 private Integer nro_tema; 
	 private String nro_mensaje;
	 private String fecha_registro; 
	 private String autor;
	 private String emailAutor;
	 private String texto_mensaje;
	 
	public Integer getNro_tema() {
		return nro_tema;
	}
	public void setNro_tema(Integer nro_tema) {
		this.nro_tema = nro_tema;
	}
	public String getNro_mensaje() {
		return nro_mensaje;
	}
	public void setNro_mensaje(String nro_mensaje) {
		this.nro_mensaje = nro_mensaje;
	}
	public String getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEmailAutor() {
		return emailAutor;
	}
	public void setEmailAutor(String emailAutor) {
		this.emailAutor = emailAutor;
	}
	public String getTexto_mensaje() {
		return texto_mensaje;
	}
	public void setTexto_mensaje(String texto_mensaje) {
		this.texto_mensaje = texto_mensaje;
	}
	 
}
