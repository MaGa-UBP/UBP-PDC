package ar.edu.ubp.das.beans;

public class ContadorBean {

    private int contador;
    
    public ContadorBean() {
        this.contador = 0;
    }
    
    public void setContador(int c) {
        this.contador += c;
    }
            
    public int getContador() {
        return this.contador;
    }
                
}
