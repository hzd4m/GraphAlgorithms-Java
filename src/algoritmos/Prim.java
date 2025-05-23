package algoritmos;

import model.Aresta;
import model.Grafo;

import java.util.Arrays;
import java.util.List;

public class Prim{
    public static void calcular(Grafo grafo){
        int n = grafo.getNumeroVertices();
        
        
        int[] chave = new int[n];
        int[] pai = new int[n];
        boolean[] incluido = new boolean[n]; 
        
        
        Arrays.fill(chave , Integer.MAX_VALUE);
        Arrays.fill(pai, -1);
        
        
        chave[0] = 0;
        // Repetimos n -1 vezes para formar n -1 conexões(arestas) 
        for(int i = 0 ; i < n - 1; i++){
             int u = -1; 
             int menorChave = Integer.MAX_VALUE;
             
             for(int v = 0 ; v < n ; v++){
             if(!incluido[v] && chave[v] < menorChave){
                  menorChave = chave[v];
                  u = v;
             }
         }
         //Grafo desconexo
         if(u == -1){
            break;
         }
         
         incluido[u] = true; 
         
         List<Aresta> vizinhos = grafo.getAresta(u);
         
         for(int j = 0; j < vizinhos.size() ; j++){
             Aresta aresta = vizinhos.get(j);
             int v = aresta.destino; 
             int peso = aresta.peso; 
             
             
             if(!incluido[v] && peso < chave[v]){
                 chave[v] = peso;
                 pai[v] = u;
             } 
           } 
         }
             System.out.println("\n🌲 Árvore Geradora Mínima (Prim):");
        int pesoTotal = 0;

        for (int i = 1; i < n; i++) {
            if (pai[i] != -1) {
                System.out.println(pai[i] + " -- " + i + " (peso " + chave[i] + ")");
                pesoTotal += chave[i];
            }
        }

        System.out.println("➡️ Peso total da AGM: " + pesoTotal);
    }
}

        
        
        