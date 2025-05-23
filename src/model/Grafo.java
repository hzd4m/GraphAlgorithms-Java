package model;
import java.util.ArrayList;
import java.util.List;

public class Grafo {
     private List<List<Aresta>> adjacencia;
     private boolean direcionado;
     private boolean ponderado;
     
     public Grafo(int numeroVertices, boolean direcionado , boolean ponderado) {
    	 this.direcionado = direcionado;
    	 adjacencia = new ArrayList<>();
    	 this.ponderado = ponderado;
    	 
    	 for(int i = 0 ; i < numeroVertices ; i++) {
    		 adjacencia.add(new ArrayList<>());
    	 }
     }
     
     public void adicionarAresta(int origem, int destino, int peso) {
    	 if(!ponderado) {
    		 peso = 1;
    	 }
    	 
    	 adjacencia.get(origem).add(new Aresta(destino,peso));
    	 
    	 if(!direcionado) {
    		 adjacencia.get(destino).add(new Aresta(origem,peso));
    	 }
     }
     
     public void imprimirListaAdjacencia() {
    	 for(int i = 0; i < adjacencia.size(); i++) {
    		 System.out.println("Vértice "+ i + " -> ");
    		 for(int j = 0; j < adjacencia.get(i).size(); j++) {
    			 Aresta a = adjacencia.get(i).get(j);
    			 System.out.println(a + " ");
    			 
    		 }
    		 System.out.println();
    	 }
     }
     
     public int getNumeroVertices() {
    	 return adjacencia.size();
     }
     
     public List<Aresta> getAresta(int vertice){
    	 return adjacencia.get(vertice);
     }
     
     public boolean isDirecionado() {
    	 return direcionado;
     }
     
     public boolean isPonderado() {
    	    return ponderado;
    	}

}
