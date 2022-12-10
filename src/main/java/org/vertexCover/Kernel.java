package org.vertexCover;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;

import java.util.ArrayList;
import java.util.List;

public class Kernel {

    // kernelization algorithm
    public List<Object> minVC(Graph<Integer, DefaultEdge> graph, int k) {
        boolean stop = false;
        boolean VC1 = false;
        boolean VC2 = false;
        List<Object> VC = new ArrayList<>();
        while (!stop) {
            //find a vertex with degree 1
            if(graph.vertexSet().stream().anyMatch(u -> graph.degreeOf(u) == 1)) {
                int u = graph.vertexSet().stream().filter(vertex -> graph.degreeOf(vertex) == 1).findFirst().get();
                //get the neighbour of u
                int v = Graphs.neighborListOf(graph, u).get(0);
                VC.add(v);
                //remove the vertex and its incident edge
                k = k - 1;
                graph.removeVertex(v);
            }else {
                VC1 = true;
            }
            //if vertex with degree >= k+1
            int finalK = k;
            if(graph.vertexSet().stream().anyMatch(v -> graph.degreeOf(v) >= finalK +1)) {
                int finalK1 = k;
                int v = graph.vertexSet().stream().filter(vertex -> graph.degreeOf(vertex) >= finalK1 +1).findFirst().get();
                VC.add(v);
                k = k - 1;
                graph.removeVertex(v);
            }else {
                VC2 = true;
            }

            stop = VC1 && VC2;
        }
        return VC;
    }
}
