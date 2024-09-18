package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader flowGraph1 = new BufferedReader(new FileReader("src/flytgraf1.txt"));
    BufferedReader flowGraph2 = new BufferedReader(new FileReader("src/flytgraf2.txt"));
    BufferedReader flowGraph3 = new BufferedReader(new FileReader("src/flytgraf3.txt"));
    BufferedReader flowGraph4 = new BufferedReader(new FileReader("src/flytgraf4.txt"));
    BufferedReader flowGraph5 = new BufferedReader(new FileReader("src/flytgraf5.txt"));

    Graph g = new Graph();
    g.newGraph(flowGraph4);

    Node source = g.node[0];
    Node sink = g.node[7];

    g.printMaxFlow(g.maxFlow(source, sink), source, sink);
  }
}
