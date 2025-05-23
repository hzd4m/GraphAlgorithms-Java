package model;

public class Aresta {
    public int destino;
    public int peso;
    
    public Aresta(int destino , int peso) {
    	this.destino = destino;
    	this.peso = peso;
    }
    
    @Override
    public String toString() {
    	return destino + "(" + peso + ")";
    }
    
    
}
