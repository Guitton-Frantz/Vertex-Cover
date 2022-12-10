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
    static Map<Integer, Map<String, Integer>> results = new HashMap<Integer, Map<String, Integer>>();
    static int countCol = 0;
    public static void main(String[] args) {
        int i = 10;
        while (i <= 50) {

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


            int twoApproxVC1 = twoApprox.minVC(graph3).size();
            r1.put("VC 2 approx size", twoApproxVC1);
            r1.put("VC kernel size", kernel.kernelization(graph1, twoApproxVC1/2, twoApproxVC1));
            r1.put("VC bounded search tree size", boundedSearchTree.boundedSearchTree(graph2, twoApproxVC1/2, twoApproxVC1));

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
            int twoApproxVC2 = twoApprox.minVC(graph3).size();

            r2.put("VC 2 approx size", twoApproxVC2);
            r2.put("VC kernel size", kernel.kernelization(graph1, twoApproxVC2/2, twoApproxVC2));
            r2.put("VC bounded search tree size", boundedSearchTree.boundedSearchTree(graph2, twoApproxVC2/2, twoApproxVC2));


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

            int twoApproxVC3 = twoApprox.minVC(graph3).size();

            r3.put("VC 2 approx size", twoApproxVC3);
            r3.put("VC kernel size", kernel.kernelization(graph1, twoApproxVC3/2, twoApproxVC3));
            r3.put("VC bounded search tree size", boundedSearchTree.boundedSearchTree(graph2, twoApproxVC3/2, twoApproxVC3));

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
            int twoApproxVC4 = twoApprox.minVC(graph3).size();

            r4.put("VC 2 approx size", twoApproxVC4);
            r4.put("VC kernel size", kernel.kernelization(graph1, twoApproxVC4/2, twoApproxVC4));
            r4.put("VC bounded search tree size", boundedSearchTree.boundedSearchTree(graph2, twoApproxVC4/2, twoApproxVC4));

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

            int twoApproxVC5 = twoApprox.minVC(graph3).size();

            r5.put("VC 2 approx size", twoApproxVC5);
            r5.put("VC kernel size", kernel.kernelization(graph1, twoApproxVC5/2, twoApproxVC5));
            r5.put("VC bounded search tree size", boundedSearchTree.boundedSearchTree(graph2, twoApproxVC5/2, twoApproxVC5));

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
        onlyTwoApproxVC(2000);
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
    public static void onlyTwoApproxVC(int i){
        System.out.println("only two approx VC");
        int n = 60;
        while(n <= i){
            TwoApprox twoApprox = new TwoApprox();

            double p1 = (double) 3 / n;
            double p2 = (double) 4 / n;
            double p3 = (double) 5 / n;
            double p4 = 0.1;
            double p5 = 0.2;

            Graph<Integer, DefaultEdge> graph = GraphGen.randomGraph((int) n, p1);
            HashMap<String, Integer> r1 = new HashMap<String, Integer>();
            r1.put("n", n);
            r1.put("p", (int) (p1 * 100));
            r1.put("m", graph.edgeSet().size());
            Graph<Integer, DefaultEdge> finalGraph = graph;
            //deltaG the highest degree of the graph
            int deltaG = getMaxDegree(finalGraph);
            r1.put("deltaG", deltaG);
            r1.put("dmoyG", getAverageDegree(finalGraph));

            int twoApproxVC1 = twoApprox.minVC(graph).size();
            r1.put("VC 2 approx size", twoApproxVC1);

            graph = GraphGen.randomGraph((int) n, p2);
            HashMap<String, Integer> r2 = new HashMap<String, Integer>();
            r2.put("n", n);
            r2.put("p", (int) (p2 * 100));
            r2.put("m", graph.edgeSet().size());
            Graph<Integer, DefaultEdge> finalGraph2 = graph;
            //deltaG the highest degree of the graph
            int deltaG2 = getMaxDegree(finalGraph2);
            r2.put("deltaG", deltaG2);
            r2.put("dmoyG", getAverageDegree(finalGraph2));

            int twoApproxVC2 = twoApprox.minVC(graph).size();
            r2.put("VC 2 approx size", twoApproxVC2);

            graph = GraphGen.randomGraph((int) n, p3);
            HashMap<String, Integer> r3 = new HashMap<String, Integer>();
            r3.put("n", n);
            r3.put("p", (int) (p3 * 100));
            r3.put("m", graph.edgeSet().size());
            Graph<Integer, DefaultEdge> finalGraph3 = graph;
            //deltaG the highest degree of the graph
            int deltaG3 = getMaxDegree(finalGraph3);
            r3.put("deltaG", deltaG3);
            r3.put("dmoyG", getAverageDegree(finalGraph3));

            int twoApproxVC3 = twoApprox.minVC(graph).size();
            r3.put("VC 2 approx size", twoApproxVC3);

            graph = GraphGen.randomGraph((int) n, p4);
            HashMap<String, Integer> r4 = new HashMap<String, Integer>();
            r4.put("n", n);
            r4.put("p", (int) (p4 * 100));
            r4.put("m", graph.edgeSet().size());
            Graph<Integer, DefaultEdge> finalGraph4 = graph;
            //deltaG the highest degree of the graph
            int deltaG4 = getMaxDegree(finalGraph4);
            r4.put("deltaG", deltaG4);
            r4.put("dmoyG", getAverageDegree(finalGraph4));

            int twoApproxVC4 = twoApprox.minVC(graph).size();
            r4.put("VC 2 approx size", twoApproxVC4);

            graph = GraphGen.randomGraph((int) n, p5);
            HashMap<String, Integer> r5 = new HashMap<String, Integer>();
            r5.put("n", n);
            r5.put("p", (int) (p5 * 100));
            r5.put("m", graph.edgeSet().size());
            Graph<Integer, DefaultEdge> finalGraph5 = graph;
            //deltaG the highest degree of the graph
            int deltaG5 = getMaxDegree(finalGraph5);
            r5.put("deltaG", deltaG5);
            r5.put("dmoyG", getAverageDegree(finalGraph5));

            int twoApproxVC5 = twoApprox.minVC(graph).size();
            r5.put("VC 2 approx size", twoApproxVC5);

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
            if(n < 100){
                n += 10;
            } else if (n < 500 && n >= 100) {
                n += 20;
            } else if (n < 1000 && n >= 500) {
                n += 50;
            } else {
                n += 100;
            }
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