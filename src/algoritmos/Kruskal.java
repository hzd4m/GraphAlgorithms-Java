package algoritmos;

import model.Aresta;
import model.Grafo;

import java.util.*;

public class Kruskal {

    public static void calcular(Grafo grafo) {
        int n = grafo.getNumeroVertices();
        int[] pai = new int[n];

        // Inicializa cada vértice como seu próprio pai (conjunto separado)
        for (int i = 0; i < n; i++) {
            pai[i] = i;
        }

        // Lista todas as arestas do grafo
        List<ArestaExt> todasArestas = new ArrayList<>();

        for (int u = 0; u < n; u++) {
            for (Aresta aresta : grafo.getAresta(u)) {
                int v = aresta.destino;
                int peso = aresta.peso;

                if (u < v) { // evita duplicação de arestas não direcionadas
                    todasArestas.add(new ArestaExt(u, v, peso));
                }
            }
        }

        // Ordena as arestas pelo peso crescente
        todasArestas.sort(Comparator.comparingInt(a -> a.peso));

        List<ArestaExt> agm = new ArrayList<>();
        int pesoTotal = 0;

        // Percorre as arestas ordenadas
        for (ArestaExt aresta : todasArestas) {
            int u = aresta.u;
            int v = aresta.v;

            if (find(pai, u) != find(pai, v)) {
                agm.add(aresta);
                pesoTotal += aresta.peso;
                union(pai, u, v);
            }
        }

        // Impressão da AGM
        System.out.println("\n🌉 Árvore Geradora Mínima (Kruskal):");
        for (ArestaExt a : agm) {
            System.out.println(a.u + " -- " + a.v + " (peso " + a.peso + ")");
        }
        System.out.println("➡️ Peso total da AGM: " + pesoTotal);
    }

    // Busca com compressão de caminho
    private static int find(int[] pai, int v) {
        if (pai[v] != v) {
            pai[v] = find(pai, pai[v]);
        }
        return pai[v];
    }

    // União de conjuntos
    private static void union(int[] pai, int a, int b) {
        int raizA = find(pai, a);
        int raizB = find(pai, b);
        if (raizA != raizB) {
            pai[raizB] = raizA;
        }
    }

    // Classe auxiliar para aresta com origem e destino
    static class ArestaExt {
        int u, v, peso;

        public ArestaExt(int u, int v, int peso) {
            this.u = u;
            this.v = v;
            this.peso = peso;
        }
    }
}
