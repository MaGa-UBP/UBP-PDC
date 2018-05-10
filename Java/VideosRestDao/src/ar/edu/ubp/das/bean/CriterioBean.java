package ar.edu.ubp.das.bean;

import ar.edu.ubp.das.db.Bean;

public class CriterioBean implements Bean{

	private short nroCategoria;
	private String stringBusqueda;
	
	public short getNroCategoria() {
		return nroCategoria;
	}
	
	public void setNroCategoria(short nroCategoria) {
		this.nroCategoria = nroCategoria;
	}
	
	public String getStringBusqueda() {
		return stringBusqueda;
	}
	
	public void setStringBusqueda(String stringBusqueda) {
		this.stringBusqueda = stringBusqueda;
	}

}
