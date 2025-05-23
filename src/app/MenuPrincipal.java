package app;

import java.util.Scanner;
import model.Grafo;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Grafo grafo = null;
        boolean criado = false;

        while (true) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Criar novo grafo");
            System.out.println("2. Adicionar aresta");
            System.out.println("3. Imprimir lista de adjacência");
            System.out.println("4. Executar BFS (Busca em Largura)");
            System.out.println("5. Executar Dijkstra");
            System.out.println("6. Executar Prim (AGM)");
            System.out.println("7. Executar Kruskal (AGM)");
            System.out.println("8. Executar ApagaReserva (subgrafo AGM)");
            System.out.println("9. Ordenar arestas por peso");
            System.out.println("10. Criar grafo de exemplo (1 a 4)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = in.nextInt();
            in.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o número de vértices: ");
                    int n = in.nextInt();
                    in.nextLine();
                    System.out.print("O grafo é direcionado? (true/false): ");
                    boolean direcionado = in.nextBoolean();
                    in.nextLine();
                    System.out.print("O grafo é ponderado? (true/false): ");
                    boolean ponderado = in.nextBoolean();
                    in.nextLine();
                    grafo = new Grafo(n, direcionado, ponderado);
                    criado = true;
                    System.out.println("✅ Grafo criado com sucesso.");
                    break;

                case 2:
                    if (!criado) {
                        System.out.println("⚠️ Crie o grafo primeiro (opção 1).");
                        break;
                    }
                    System.out.print("Vértice origem: ");
                    int origem = in.nextInt();
                    in.nextLine();
                    System.out.print("Vértice destino: ");
                    int destino = in.nextInt();
                    in.nextLine();
                    System.out.print("Peso da aresta: ");
                    int peso = in.nextInt();
                    in.nextLine();
                    grafo.adicionarAresta(origem, destino, peso);
                    System.out.println("✅ Aresta adicionada.");
                    break;

                case 3:
                    if (!criado) {
                        System.out.println("⚠️ Crie o grafo primeiro (opção 1).");
                        break;
                    }
                    System.out.println("\n📌 Lista de Adjacência:");
                    grafo.imprimirListaAdjacencia();
                    break;

                case 4:
                    if (!criado) {
                        System.out.println("⚠️ Crie o grafo primeiro (opção 1).");
                        break;
                    }
                    System.out.print("Vértice de origem para BFS: ");
                    int origemBFS = in.nextInt();
                    in.nextLine();
                    algoritmos.BFS.buscar(grafo, origemBFS);
                    break;

                case 5:
                    if (!criado) {
                        System.out.println("⚠️ Crie o grafo primeiro (opção 1).");
                        break;
                    }
                    System.out.print("Vértice de origem para Dijkstra: ");
                    int origemDIJ = in.nextInt();
                    in.nextLine();
                    algoritmos.Dijkstra.calcular(grafo, origemDIJ);
                    break;

                case 6:
                    if (!criado) {
                        System.out.println("⚠️ Crie o grafo primeiro (opção 1).");
                        break;
                    }
                    if (grafo.isDirecionado()) {
                        System.out.println("⚠️ Prim só funciona com grafos não direcionados.");
                        break;
                    }
                    if (!grafo.isPonderado()) {
                        System.out.println("⚠️ Prim exige grafo ponderado.");
                        break;
                    }
                    algoritmos.Prim.calcular(grafo);
                    break;

                case 7:
                    if (!criado) {
                        System.out.println("⚠️ Crie o grafo primeiro (opção 1).");
                        break;
                    }
                    if (grafo.isDirecionado()) {
                        System.out.println("⚠️ Kruskal só funciona com grafos não direcionados.");
                        break;
                    }
                    if (!grafo.isPonderado()) {
                        System.out.println("⚠️ Kruskal exige grafo ponderado.");
                        break;
                    }
                    algoritmos.Kruskal.calcular(grafo);
                    break;

                case 8:
                    if (!criado) {
                        System.out.println("⚠️ Crie o grafo primeiro (opção 1).");
                        break;
                    }
                    if (grafo.isDirecionado()) {
                        System.out.println("⚠️ ApagaReserva só funciona com grafos não direcionados.");
                        break;
                    }
                    if (!grafo.isPonderado()) {
                        System.out.println("⚠️ ApagaReserva exige grafo ponderado.");
                        break;
                    }
                    grafo = algoritmos.ApagaReserva.executar(grafo);
                    System.out.println("✅ Grafo atualizado: agora contém apenas a Árvore Geradora Mínima.");
                    break;

                case 9:
                    if (!criado) {
                        System.out.println("⚠️ Crie o grafo primeiro (opção 1).");
                        break;
                    }
                    algoritmos.OrdenacaoArestas.exibir(grafo);
                    break;
                
                case 10:
                    System.out.print("Digite o tipo do grafo exemplo (1 = Dir+Pond, 2 = NãoDir+Pond, 3 = Dir+NãoPond, 4 = NãoDir+NãoPond): ");
                    int tipo = in.nextInt();
                    in.nextLine();
                    grafo = util.GrafoFactory.construirGrafoExemplo(tipo);
                    criado = true;
                    System.out.println("✅ Grafo de exemplo criado com sucesso:");
                    grafo.imprimirListaAdjacencia();
                    break;


                case 0:
                    System.out.println("👋 Encerrando o programa...");
                    in.close();
                    return;

                default:
                    System.out.println("❌ Opção inválida.");
            }
        }
    }
}
