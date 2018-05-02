package ar.edu.ubp.das.beans;

public class CategoriasBean {

    private String[] categorias;

    public CategoriasBean() {
    	this.categorias = new String[100];
    }

    public String getCategoria(int posicion) { 
    	return categorias.length > 0 ? categorias[posicion] : null; 
    }

    public String[] getCategorias() {
    	return this.categorias;
    }
    
    public void setCategoria(String categoria, int posicion) { 
		this.categorias[posicion] = categoria; 
    }
    
    public void setCategorias(String[] categorias) {
    	this.categorias = categorias;
    }

}
