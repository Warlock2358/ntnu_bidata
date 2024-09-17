public class TopologyList {
  boolean found;
  Node next;

  public Node dfTopology(Node n, Node l) {
    TopologyList nd = (TopologyList)n.d;
    if (nd.found) {
      return l;
    }
    nd.found = true;
    for (Edge e = n.edge; e != null; e = e.next) {
      l = dfTopology(e.to, l);
    }
    nd.next = l;
    return n;
  }
}
