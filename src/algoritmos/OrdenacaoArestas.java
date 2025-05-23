package algoritmos;

import model.Aresta;
import model.Grafo;

import java.util.*;

public class OrdenacaoArestas {

    public static void exibir(Grafo grafo) {
        int n = grafo.getNumeroVertices();
        boolean direcionado = grafo.isDirecionado();

        List<ArestaExt> todasArestas = new ArrayList<>();

        // Coleta todas as arestas do grafo
        for (int u = 0; u < n; u++) {
            for (Aresta aresta : grafo.getAresta(u)) {
                int v = aresta.destino;
                int peso = aresta.peso;

                if (direcionado || u < v) {
                    todasArestas.add(new ArestaExt(u, v, peso));
                }
            }
        }

        // Ordena em ordem crescente
        List<ArestaExt> crescente = new ArrayList<>(todasArestas);
        crescente.sort(Comparator.comparingInt(a -> a.peso));

        System.out.println("\n⬆️ Arestas em ordem crescente de peso:");
        for (ArestaExt a : crescente) {
            System.out.println(a.u + " -- " + a.v + " (peso " + a.peso + ")");
        }

        // Ordena em ordem decrescente
        List<ArestaExt> decrescente = new ArrayList<>(todasArestas);
        decrescente.sort((a, b) -> Integer.compare(b.peso, a.peso));

        System.out.println("\n⬇️ Arestas em ordem decrescente de peso:");
        for (ArestaExt a : decrescente) {
            System.out.println(a.u + " -- " + a.v + " (peso " + a.peso + ")");
        }
    }

    // Classe auxiliar
    static class ArestaExt {
        int u, v, peso;

        public ArestaExt(int u, int v, int peso) {
            this.u = u;
            this.v = v;
            this.peso = peso;
        }
    }
}
