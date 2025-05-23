package algoritmos;
import java.util.*;
import model.Aresta;
import model.Grafo;

public class BFS {
    public static void buscar(Grafo grafo, int origem) {
    	int n = grafo.getNumeroVertices();
    	boolean[] visitados = new boolean[n];
    	int[] distancia = new int[n];
    	
    	Arrays.fill(distancia, -1);
    	
    	Queue<Integer> fila = new LinkedList<>();
    	
    	
    	visitados[origem] = true;
    	distancia[origem] = 0;
    	
    	fila.add(origem);
    	
    	while(!fila.isEmpty()) {
    		int atual = fila.poll();
    		
    		System.out.println("Visitando vértice: " + atual);
    		
    		List<Aresta> arestas = grafo.getAresta(atual);
    		for(int i = 0 ; i < arestas.size(); i++) {
    			Aresta aresta = arestas.get(i);
    			int vizinho = aresta.destino;
    			
    			if(!visitados[vizinho]) {
    				visitados[vizinho] = true;
    				distancia[vizinho] = distancia[atual] + 1;
    				fila.add(vizinho);
    			}
    		}
    	}
    	
    	 System.out.println("\nDistâncias a partir do vértice " + origem + ":");
         for (int i = 0; i < n; i++) {
             System.out.println("Vértice " + i + ": " + distancia[i]);
         }
    }
}
