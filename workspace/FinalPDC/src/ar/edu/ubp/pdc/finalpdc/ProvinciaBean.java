package ar.edu.ubp.pdc.finalpdc;

public class ProvinciaBean {
	String provincia;
	String cod_provincia;
	public ProvinciaBean(String nombre, String codigo){
		this.provincia = nombre;
		this.cod_provincia = codigo;
	}
	
	public void setProvincia(String provincia){
		this.provincia = provincia;
	}
	public void setCod_provincia(String cod){
		this.cod_provincia = cod;
	}
	public String getProvincia(){
		return this.provincia;
	}
	public String getCod_provincia(){
		return this.cod_provincia;
	}
}
