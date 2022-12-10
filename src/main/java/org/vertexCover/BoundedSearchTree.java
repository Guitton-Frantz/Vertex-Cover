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
     * boundedSearchTree algorithm to find the size of the vertex cover
     * @param graph the graph
     */
    public int minVCSize(Graph<Integer, DefaultEdge> graph) {
        int k = 0;
        while (!minVC(graph, k)) {
            k = k + 1;
        }
        return k;
    }
}
