package util;

import model.Grafo;

public class GrafoFactory {

    public static Grafo construirGrafoExemplo(int tipo) {
        // tipo: 1 = dir. ponderado, 2 = não-dir. ponderado
        //       3 = dir. não ponderado, 4 = não-dir. não ponderado

        boolean direcionado = (tipo == 1 || tipo == 3);
        boolean ponderado = (tipo == 1 || tipo == 2);

        Grafo grafo = new Grafo(4, direcionado, ponderado);

        if (tipo == 1 || tipo == 2) { // ponderado
            grafo.adicionarAresta(0, 1, 2);
            grafo.adicionarAresta(0, 2, 5);
            grafo.adicionarAresta(1, 3, 1);
            grafo.adicionarAresta(3, 2, 4);
        } else { // não ponderado
            grafo.adicionarAresta(0, 1, 0);
            grafo.adicionarAresta(0, 2, 0);
            grafo.adicionarAresta(1, 3, 0);
            grafo.adicionarAresta(3, 2, 0);
        }

        return grafo;
    }
}
