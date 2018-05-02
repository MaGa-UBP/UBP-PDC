package ar.edu.ubp.das.beans;

public class CategoriasBean {

    private String[] categorias;

    public CategoriasBean() {
    	this.categorias = new String[100];
    }

    public String[] getCategorias() {
    	return this.categorias;
    }
    
    public void setCategorias(String[] categorias) {
    	this.categorias = categorias;
    }

}
