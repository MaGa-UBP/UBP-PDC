package ar.edu.ubp.pdc.tp2.classes;

public class Product {
	private String ID;
	private String nombre;
	private Integer cantidad;
	private Float precio;
	private String urlImagen;
	
	public Product(String iD, String nombre, String urlImagen, Integer cantidad, Float precio) {
		this.ID = iD;
		this.nombre = nombre;
		this.urlImagen = urlImagen;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
}
