import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader o6g1 = new BufferedReader(new FileReader("ø6g1"));
    BufferedReader o6g2 = new BufferedReader(new FileReader("ø6g2"));
    BufferedReader o6g3 = new BufferedReader(new FileReader("ø6g3"));
    BufferedReader o6g5 = new BufferedReader(new FileReader("ø6g5"));
    BufferedReader o6g7 = new BufferedReader(new FileReader("ø6g7"));
    BufferedReader o6Scan = new BufferedReader(new FileReader("ø6Skandinavia"));


    Graph g = new Graph();
    g.new_Graph(o6g7);

    int startNode = 0;
    //System.out.println("Start node: " + startNode);
    g.bfs(g.node[startNode]);

    System.out.println();
    Node result = g.topologicalSort();
    g.printTopologicalSort(result);
  }
}
