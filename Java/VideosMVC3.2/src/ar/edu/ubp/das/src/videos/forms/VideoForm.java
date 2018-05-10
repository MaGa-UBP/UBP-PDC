package ar.edu.ubp.das.src.videos.forms;

import ar.edu.ubp.das.mvc.action.DynaActionForm;

public class VideoForm extends DynaActionForm {

	private int    nroVideo;
	private String titulo;
	private String cantante;
	private String linkVideo;
   
	public VideoForm() { }

	public int getNroVideo() {
		return nroVideo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getCantante() {
		return cantante;
	}

	public String getLinkVideo() {
		return linkVideo;
	}

	public void setNroVideo(int nroVideo) {
		this.nroVideo = nroVideo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setCantante(String cantante) {
		this.cantante = cantante;
	}

	public void setLinkVideo(String linkVideo) {
		this.linkVideo = linkVideo;
	}

}
