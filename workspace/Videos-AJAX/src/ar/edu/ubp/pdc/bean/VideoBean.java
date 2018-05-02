package ar.edu.ubp.pdc.bean;

public class VideoBean {

	private short nroCategoria;
	private String nomCategoria;
	private int nroVideo;
	private String titulo;
	private String cantante;
	private String linkVideo;
	private boolean visto;

	public VideoBean() { }
	
	public short getNroCategoria() {
		return nroCategoria;
	}

	public void setNroCategoria(short nroCategoria) {
		this.nroCategoria = nroCategoria;
	}

	public String getNomCategoria() {
		return nomCategoria;
	}

	public void setNomCategoria(String nomCategoria) {
		this.nomCategoria = nomCategoria;
	}

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

	public boolean isVisto() {
		return visto;
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

	public void setVisto(boolean visto) {
		this.visto = visto;
	}

}
