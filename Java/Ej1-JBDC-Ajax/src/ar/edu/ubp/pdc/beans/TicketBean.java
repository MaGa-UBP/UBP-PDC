package ar.edu.ubp.pdc.beans;

public class TicketBean {
	private String ticket;
	private String fechaTicket;
	private String solicitante;
	private String asuntoTicket;
	private String textoTicket;
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getFechaTicket() {
		return fechaTicket;
	}
	public void setFechaTicket(String fechaTicket) {
		this.fechaTicket = fechaTicket;
	}
	public String getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}
	public String getAsuntoTicket() {
		return asuntoTicket;
	}
	public void setAsuntoTicket(String asuntoTicket) {
		this.asuntoTicket = asuntoTicket;
	}
	public String getTextoTicket() {
		return textoTicket;
	}
	public void setTextoTicket(String textoTicket) {
		this.textoTicket = textoTicket;
	}
}
