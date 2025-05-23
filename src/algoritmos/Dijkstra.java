package algoritmos;
import model.Aresta;
import model.Grafo;

import java.util.*;
public class Dijkstra {
    public static void calcular(Grafo grafo, int origem) {
    	int n = grafo.getNumeroVertices();
    	int[] dist = new int[n];
    	boolean[] visitado = new boolean[n];
    	
    	Arrays.fill(dist, Integer.MAX_VALUE);
    	dist[origem] = 0;
    	
    	
    	for(int i = 0 ; i < n ; i++) {
    		int u = -1;
    		int menorDistancia = Integer.MAX_VALUE;
    		
    		for(int j = 0 ; j < n ; j++) {
    			if(!visitado[j] && dist[j] < menorDistancia) {
    				menorDistancia = dist[j];
    				u = j; 
    			}
    			
    			}
    		
    		if (u == -1) {
    			break;
    		}
    		
    		visitado[u] = true; 
    		
    		List<Aresta> vizinho = grafo.getAresta(u);
    		
    		for(int k = 0 ; k < vizinho.size() ; k++) {
    			Aresta aresta = vizinho.get(k);
    			int v = aresta.destino;
    			int peso = aresta.peso;
    			
    			if(!visitado[v] && dist[u] + peso < dist[v]) {
    				dist[v] = dist[u] + peso;
    			}
    		}
    	}
    	 System.out.println("\n📍 Menores distâncias a partir do vértice " + origem + ":");
         for (int i = 0; i < n; i++) {
             System.out.print("Vértice " + i + ": ");
             if (dist[i] == Integer.MAX_VALUE) {
                 System.out.println("não alcançável");
             } else {
                 System.out.println(dist[i]);
             }
         }
     }
 }
    	
    	
    	
    
