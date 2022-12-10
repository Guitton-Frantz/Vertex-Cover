package org.vertexCover;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.*;

public class App {
    public static void main(String[] args) {
        //Hash map of hash maps
        Map<Integer, Map<String, Integer>> results = new HashMap<Integer, Map<String, Integer>>();
        int countCol = 0;
        int k = 10;
        int i = 10;
        while (i <= 2000) {

            Kernel kernel = new Kernel();
            BoundedSearchTree boundedSearchTree = new BoundedSearchTree();
            TwoApprox twoApprox = new TwoApprox();

            double p1 = (double) 3 / i;

            Graph<Integer, DefaultEdge> graph = GraphGen.randomGraph((int) i, p1);

            Graph<Integer, DefaultEdge> graph1 = new SimpleGraph<>(DefaultEdge.class);
            Graph<Integer, DefaultEdge> graph2 = new SimpleGraph<>(DefaultEdge.class);
            Graph<Integer, DefaultEdge> graph3 = new SimpleGraph<>(DefaultEdge.class);
            Graphs.addGraph(graph1, graph);
            Graphs.addGraph(graph2, graph);
            Graphs.addGraph(graph3, graph);

            HashMap<String, Integer> r1 = new HashMap<String, Integer>();
            r1.put("n", i);
            r1.put("p", (int) (p1 * 100));
            r1.put("m", graph.edgeSet().size());
            Graph<Integer, DefaultEdge> finalGraph = graph;
            //deltaG the highest degree of the graph
            int deltaG = getMaxDegree(finalGraph);
            r1.put("deltaG", deltaG);
            r1.put("dmoyG", getAverageDegree(finalGraph));


            boundedSearchTree.minVC(graph2, k);

            r1.put("VC 2 approx size", twoApprox.minVC(graph3).size());
            r1.put("VC kernel size", kernel.minVC(graph1, k).size());
            r1.put("VC bounded search tree size", graph2.vertexSet().size());

            double p2 = (double) 4 / i;
            graph = GraphGen.randomGraph((int) i, p2);
            Graphs.addGraph(graph1, graph);
            Graphs.addGraph(graph2, graph);
            Graphs.addGraph(graph3, graph);

            HashMap<String, Integer> r2 = new HashMap<String, Integer>();
            r2.put("n", i);
            r2.put("p", (int) (p2 * 100));
            r2.put("m", graph.edgeSet().size());
            Graph<Integer, DefaultEdge> finalGraph2 = graph;
            int deltaG2 = getMaxDegree(finalGraph2);
            r2.put("deltaG", deltaG2);
            r2.put("dmoyG", getAverageDegree(finalGraph2));

            int twoApproxVcSize = twoApprox.minVC(graph3).size();
            boundedSearchTree.minVC(graph2, k);

            r2.put("VC 2 approx size", twoApprox.minVC(graph3).size());
            r2.put("VC kernel size", kernel.minVC(graph1, k).size());
            r2.put("VC bounded search tree size", graph2.vertexSet().size());


            double p3 = (double) 5 / i;
            graph = GraphGen.randomGraph((int) i, p3);
            Graphs.addGraph(graph1, graph);
            Graphs.addGraph(graph2, graph);
            Graphs.addGraph(graph3, graph);

            HashMap<String, Integer> r3 = new HashMap<String, Integer>();
            r3.put("n", i);
            r3.put("p", (int) (p3 * 100));
            r3.put("m", graph.edgeSet().size());
            Graph<Integer, DefaultEdge> finalGraph3 = graph;
            int deltaG3 = getMaxDegree(finalGraph3);
            r3.put("deltaG", deltaG3);
            r3.put("dmoyG", getAverageDegree(finalGraph3));

            boundedSearchTree.minVC(graph2, k);

            r3.put("VC 2 approx size", twoApprox.minVC(graph3).size());
            r3.put("VC kernel size", kernel.minVC(graph1, k).size());
            r3.put("VC bounded search tree size", graph2.vertexSet().size());

            double p4 = 0.1;
            graph = GraphGen.randomGraph((int) i, p4);
            Graphs.addGraph(graph1, graph);
            Graphs.addGraph(graph2, graph);
            Graphs.addGraph(graph3, graph);

            HashMap<String, Integer> r4 = new HashMap<String, Integer>();
            r4.put("n", i);
            r4.put("p", (int) (p4 * 100));
            r4.put("m", graph.edgeSet().size());
            Graph<Integer, DefaultEdge> finalGraph4 = graph;

            int deltaG4 = getMaxDegree(finalGraph4);
            r4.put("deltaG", deltaG4);
            r4.put("dmoyG", getAverageDegree(finalGraph4));
            boundedSearchTree.minVC(graph2, k);

            r4.put("VC 2 approx size", twoApprox.minVC(graph3).size());
            r4.put("VC kernel size", kernel.minVC(graph1, k).size());
            r4.put("VC bounded search tree size", graph2.vertexSet().size());

            double p5 = 0.2;
            graph = GraphGen.randomGraph((int) i, p5);
            Graphs.addGraph(graph1, graph);
            Graphs.addGraph(graph2, graph);
            Graphs.addGraph(graph3, graph);

            HashMap<String, Integer> r5 = new HashMap<String, Integer>();
            r5.put("n", i);
            r5.put("p", (int) (p5 * 100));
            r5.put("m", graph.edgeSet().size());
            Graph<Integer, DefaultEdge> finalGraph5 = graph;

            int deltaG5 = getMaxDegree(finalGraph5);
            r5.put("deltaG", deltaG5);
            r5.put("dmoyG", getAverageDegree(finalGraph5));
            boundedSearchTree.minVC(graph2, k);

            r5.put("VC 2 approx size", twoApprox.minVC(graph3).size());
            r5.put("VC kernel size", kernel.minVC(graph1, k).size());
            r5.put("VC bounded search tree size", graph2.vertexSet().size());

            //create unique id for each row
            results.put(countCol, r1);
            countCol++;
            results.put(countCol, r2);
            countCol++;
            results.put(countCol, r3);
            countCol++;
            results.put(countCol, r4);
            countCol++;
            results.put(countCol, r5);
            countCol++;

            System.out.println("n = " + i);
            System.out.println("p = " + p1);
            System.out.println("p = " + p2);
            System.out.println("p = " + p3);
            System.out.println("p = " + p4);
            System.out.println("p = " + p5);

            if(i < 100){
                i += 10;
            } else if (i < 500 && i >= 100) {
                i += 20;
            } else if (i < 1000 && i >= 500) {
                i += 50;
            } else {
                i+= 100;
            }
        }

        System.out.println(results);

        //put the result in a csv file
        try {
            FileWriter writer = new FileWriter("results.csv");
    CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
    csvPrinter.printRecord("n","p", "m", "deltaG", "dmoyG", "VC 2 approx size", "VC kernel size", "VC bounded search tree size");
    for (Map.Entry<Integer, Map<String, Integer>> entry : results.entrySet()) {
        csvPrinter.printRecord(entry.getValue().get("n"), entry.getValue().get("p"), entry.getValue().get("m"), entry.getValue().get("deltaG"), entry.getValue().get("dmoyG"), entry.getValue().get("VC 2 approx size"), entry.getValue().get("VC kernel size"), entry.getValue().get("VC bounded search tree size"));

    }
    csvPrinter.flush();
    csvPrinter.close();

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        }

    }

    public static int getMaxDegree(Graph graph){
        int maxDegree = 0;
        for (Object vertex : graph.vertexSet()) {
            int degree = graph.edgesOf(vertex).size();
            if (degree > maxDegree) {
                maxDegree = degree;
            }
        }
        return maxDegree;
    }
    public static int getAverageDegree(Graph graph){
        int sumDegree = 0;
        for (Object vertex : graph.vertexSet()) {
            sumDegree += graph.edgesOf(vertex).size();
        }
        return sumDegree / graph.vertexSet().size();
    }

}