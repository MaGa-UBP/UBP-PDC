package ar.edu.ubp.das.src.videos.forms;

import java.util.LinkedList;

import ar.edu.ubp.das.mvc.action.DynaActionForm;

public class CategoriaForm extends DynaActionForm {

	private short nroCategoria;
	private String nomCategoria;
	private LinkedList<VideoForm> videos;
	
	public short getNroCategoria() {
		return nroCategoria;
	}
	
	public LinkedList<VideoForm> getVideos() {
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
	
	public void setVideos(LinkedList<VideoForm> videos) {
		this.videos = videos;
	}
	
}
