package ar.edu.ubp.das.beans;

public class PersonaBean {

    private String apellido, nombre;    
    private boolean existe;
    
    public PersonaBean() { }
            
    public void setApellido(String a) {
        this.apellido = a;
    }
            
    public void setNombre(String n) {
        this.nombre = n;
    }
    
    public void setExiste(boolean e) {
    	this.existe = e;
    }
    
    public String getApellido() {
        return this.apellido;
    }

    public String getNombre() {
        return this.nombre;
    }
    
    public boolean isExiste() {
    	return this.existe;
    }

    public String getNombreCompleto() {
        return this.apellido + ", " + this.nombre;
    }

}
