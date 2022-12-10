package org.vertexCover;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import java.util.ArrayList;

public class TwoApprox {
    private ArrayList<Integer> VPrime;
    private ArrayList<DefaultEdge> EPrime;
    public TwoApprox() {
        this.VPrime = new ArrayList<Integer>();
        this.EPrime = new ArrayList<DefaultEdge>();
    }

    public ArrayList<Integer> minVC(Graph<Integer, DefaultEdge> graph) {
        while(!graph.edgeSet().isEmpty()) {
            DefaultEdge e = graph.edgeSet().stream().findFirst().get();

            int u = graph.getEdgeSource(e);
            int v = graph.getEdgeTarget(e);

            this.VPrime.add(u);
            this.VPrime.add(v);
            //EPrime take edges incident to u and v
            this.EPrime.addAll(graph.edgesOf(u));
            this.EPrime.addAll(graph.edgesOf(v));

            graph.removeAllEdges(this.EPrime);
        }
        return VPrime;
    }

    public ArrayList<DefaultEdge> getEPrime() {
        return EPrime;
    }

    public ArrayList<Integer> getVPrime() {
        return VPrime;
    }
}
