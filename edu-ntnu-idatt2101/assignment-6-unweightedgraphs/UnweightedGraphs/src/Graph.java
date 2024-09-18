import java.io.IOException;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Graph extends TopologyList {
  int N, K;
  Node []node;

  public void new_Graph(BufferedReader br) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    node = new Node[N];
    for (int i = 0; i < N; i++) {
      node[i] = new Node();
      node[i].nodeNumber = i;
    }
    K = Integer.parseInt(st.nextToken());
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      node[from].edge = new Edge(node[to], node[from].edge);
    }
  }

  public void initPrev(Node s) {
    for (int i = N; i-- > 0; ) {
      node[i].d = new Prev();
    }
    ((Prev) s.d).dist = 0;
  }

  public void bfs(Node s) {
    initPrev(s);
    Queue queue = new Queue(N - 1);
    queue.enqueue(s);
    while (!queue.isEmpty()) {
      Node n = (Node) queue.nextInQueue();

      for (Edge e = n.edge; e != null; e = e.next) {
        Prev p = (Prev) e.to.d;
        if (p.dist == p.infinity) {
          p.dist = ((Prev) n.d).dist + 1;
          p.prev = n;
          queue.enqueue(e.to);
        }
      }
    }

    System.out.println("Node Prev Dist");

    // More correct way to print the graph
    // Error in printing the graph
    /* for (Node n : node) {
      Prev p = (Prev) n.d;
      System.out.println(n.nodeNumber + " " + (p.prev != null ? p.prev.nodeNumber : " ") + "  " + (p.dist != p.infinity ? p.dist : " "));
    }
    */

    // Hacky way to print the graph

    for(int i = 0; i < node.length; i++) {
      Prev p = (Prev) node[i].d;
      System.out.println(i + " " + (p.prev != null ? p.prev.nodeNumber : " ") + " " + (p.dist != p.infinity ? p.dist : " "));
    }
  }

  public Node topologicalSort() {
    Node l = null;
    for (int i = N; i-- > 0;) {
      node[i].d = new TopologyList();
    }

    for (int i = N; i-- > 0;) {
      l = dfTopology(node[i], l);
    }
    return l;
  }

  public void printTopologicalSort(Node result) {

    System.out.println("Topological Sort Result:");
    while (result != null) {
      System.out.print(result.nodeNumber + " ");
      result = ((TopologyList) result.d).next;
    }
    System.out.println();
  }
}
