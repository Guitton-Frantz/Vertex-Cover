package org.vertexCover;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

public class BoundedSearchTree {

    public boolean minVC(Graph<Integer, DefaultEdge> graph,int k ) {
        Graph<Integer, DefaultEdge> graph1 = graph;
        Graph<Integer, DefaultEdge> graph2 = graph;

        if (graph.edgeSet().isEmpty()) {
            return true;
        } else if (k == 0) {
            return false;
        } else {
            DefaultEdge e = graph.edgeSet().stream().findFirst().get();
            int u = graph.getEdgeSource(e);
            int v = graph.getEdgeTarget(e);

            graph1.removeVertex(u);
            graph2.removeVertex(v);
            return minVC(graph1, k-1)|| minVC(graph2, k-1);
        }
    }

    /**
     * boundedSearchTree algorithm to find the size of the vertex cover tahnks to dichotomy
     * @param graph the graph
     * @param lowerBound the lower bound
     * @param upperBound the upper bound
     */
    public int boundedSearchTree(Graph<Integer, DefaultEdge> graph, int lowerBound, int upperBound) {
        int k = (lowerBound + upperBound) / 2;
        if (lowerBound == upperBound) {
            return lowerBound;
        } else if (minVC(graph, k)) {
            return boundedSearchTree(graph, lowerBound, k);
        } else {
            return boundedSearchTree(graph, k + 1, upperBound);
        }
    }
}
