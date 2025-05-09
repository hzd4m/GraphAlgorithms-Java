# GraphAlgorithms-Java
Implementar, em Java, um conjunto de algoritmos clássicos de teoria dos grafos, com foco em representação, caminhos mínimos e árvores geradoras mínimas, conforme especificado em atividade avaliativa.
> Trabalho acadêmico da disciplina de Estrutura de Dados II / Teoria dos Grafos

---
## 📚 Base Teórica

Este projeto foi desenvolvido com base em duas grandes referências didáticas:

- **Java: Como Programar** – Paul Deitel, Harvey Deitel  
- **Data Structures and Algorithms in Java** (4ª ed.) – Michael T. Goodrich, Roberto Tamassia

Essas obras guiaram tanto a modelagem orientada a objetos quanto a implementação dos algoritmos de grafos com clareza e robustez.

---

## 🎯 Objetivos

- Implementar múltiplos algoritmos em um único programa Java, via menu interativo.
- Permitir entrada de grafos via definição interna.
- Praticar estruturas de dados avançadas aplicadas a grafos.
- Desenvolver modularização e reutilização de código orientado a objetos.

---

## 🛠️ Algoritmos Implementados

| Algoritmo                                                                 | Tipo de Grafo                      | Pontuação |
|--------------------------------------------------------------------------|------------------------------------|-----------|
| Lista de adjacência                                                      | Direcionado / Não-direcionado      | 1.0       |
| Menor caminho (BFS / Dijkstra)                                           | Dir./Não-dir. (ponderado ou não)   | 2.0       |
| Árvores geradoras mínimas (Prim, Kruskal, ApagaReserva)                 | Não-direcionado, ponderado         | 1.5       |
| Ordenação de arestas por peso                                           | N/A                                | 0.5       |

---
## 💻 Tecnologias

- Java 17+
- Paradigma Orientado a Objetos
- Interface via Terminal (CLI)
- IDE:  Eclipse

---

## 📎 Como Executar

```bash
javac src/**/*.java
java app.MenuPrincipal

