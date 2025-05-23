package algoritmos;

import model.Aresta;
import model.Grafo;

import java.util.*;

public class ApagaReserva {

    public static Grafo executar(Grafo grafoOriginal) {
        int n = grafoOriginal.getNumeroVertices();
        int[] pai = new int[n];

        for (int i = 0; i < n; i++) {
            pai[i] = i;
        }

        // Lista de todas as arestas (sem duplicar)
        List<ArestaExt> todasArestas = new ArrayList<>();

        for (int u = 0; u < n; u++) {
            for (Aresta a : grafoOriginal.getAresta(u)) {
                int v = a.destino;
                int peso = a.peso;
                if (u < v) {
                    todasArestas.add(new ArestaExt(u, v, peso));
                }
            }
        }

        // Ordena por peso crescente
        todasArestas.sort(Comparator.comparingInt(a -> a.peso));

        // Novo grafo somente com as arestas da AGM
        Grafo grafoReduzido = new Grafo(n, false, true);

        System.out.println("\n🧹 Arestas preservadas (AGM):");
        int pesoTotal = 0;

        for (ArestaExt aresta : todasArestas) {
            int u = aresta.u;
            int v = aresta.v;

            if (find(pai, u) != find(pai, v)) {
                union(pai, u, v);
                grafoReduzido.adicionarAresta(u, v, aresta.peso);
                System.out.println(u + " -- " + v + " (peso " + aresta.peso + ")");
                pesoTotal += aresta.peso;
            }
        }

        System.out.println("➡️ Peso total da nova estrutura (AGM): " + pesoTotal);

        return grafoReduzido;
    }

    private static int find(int[] pai, int v) {
        if (pai[v] != v) {
            pai[v] = find(pai, pai[v]);
        }
        return pai[v];
    }

    private static void union(int[] pai, int a, int b) {
        int raizA = find(pai, a);
        int raizB = find(pai, b);
        if (raizA != raizB) {
            pai[raizB] = raizA;
        }
    }

    static class ArestaExt {
        int u, v, peso;
        public ArestaExt(int u, int v, int peso) {
            this.u = u;
            this.v = v;
            this.peso = peso;
        }
    }
}
