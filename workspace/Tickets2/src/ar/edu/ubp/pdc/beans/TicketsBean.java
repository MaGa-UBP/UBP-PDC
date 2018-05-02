package ar.edu.ubp.pdc.beans;

public class TicketsBean {

	private int año_ticket;
	private String id_ticket;
	private String fecha_ticket;
	private String asunto_ticket;
	private String texto_ticket;
	private String solicitante;
	
	public int getAño_ticket() {
		return año_ticket;
	}
	public void setAño_ticket(int año_ticket) {
		this.año_ticket = año_ticket;
	}
	public String getNro_ticket() {
		return id_ticket;
	}
	public void setNro_ticket(String nro_ticket) {
		this.id_ticket = nro_ticket;
	}
	public String getFecha_ticket() {
		return fecha_ticket;
	}
	public void setFecha_ticket(String fecha_ticket) {
		this.fecha_ticket = fecha_ticket;
	}
	public String getAsunto_ticket() {
		return asunto_ticket;
	}
	public void setAsunto_ticket(String asunto_ticket) {
		this.asunto_ticket = asunto_ticket;
	}
	public String getTexto_ticket() {
		return texto_ticket;
	}
	public void setTexto_ticket(String texto_ticket) {
		this.texto_ticket = texto_ticket;
	}
	public String getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(String nro_solicitante) {
		this.solicitante = nro_solicitante;
	}

	
}
