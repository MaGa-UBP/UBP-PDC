package ar.edu.ubp.pdc.beans;

import java.util.LinkedList;

public class CarreraBean {

	private short nroCarrera;
	private String carrera;
	private LinkedList<AlumnoBean> alumnos;

	public short getNroCarrera() {
		return nroCarrera;
	}
	public void setNroCarrera(short nroCarrera) {
		this.nroCarrera = nroCarrera;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public LinkedList<AlumnoBean> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(LinkedList<AlumnoBean> alumnos) {
		this.alumnos = alumnos;
	}
	
}
