package ar.edu.ubp.pdc.bean;

import java.util.LinkedList;

public class CategoriaVideosBean {

	private short nroCategoria;
	private String nomCategoria;
	private LinkedList<VideoBean> videos;
	
	public CategoriaVideosBean() { }
	
	public short getNroCategoria() {
		return nroCategoria;
	}
	
	public LinkedList<VideoBean> getVideos() {
		return videos;
	}
	
	public String getNomCategoria() {
		return nomCategoria;
	}

	public void setNroCategoria(short nroCategoria) {
		this.nroCategoria = nroCategoria;
	}
	
	public void setNomCategoria(String nomCategoria) {
		this.nomCategoria = nomCategoria;
	}
	
	public void setVideos(LinkedList<VideoBean> videos) {
		this.videos = videos;
	}
	
}
