package org.vertexCover;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class GraphGen {

    /*
    generate a random graph
    @param n: number of vertices
    @param p: probability of edge
     */
    public static Graph<Integer, DefaultEdge> randomGraph(int n, double p) {
        Graph<Integer, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        for (int i = 0; i < n; i++) {
            graph.addVertex(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.random() < p) {
                    graph.addEdge(i, j);
                }
            }
        }
        return graph;
    }
}
