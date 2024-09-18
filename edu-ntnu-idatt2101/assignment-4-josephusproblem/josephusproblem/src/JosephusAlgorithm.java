public class JosephusAlgorithm {

  static class Node {
    int data;
    Node nextNode;

    public Node(int data) {
      this.data = data;
    }
  }

  public void josephus(int m, int n) {
    Node head = new Node(1);
    Node prev = head;
    for (int i = 2; i <= n; i++) {
      prev.nextNode = new Node(i);
      prev = prev.nextNode;
    }
    prev.nextNode = head;
    Node start = head, end = head;
    while (start.nextNode != start) {
      int count = 1;
      while (count != m) {
        end = start;
        start = start.nextNode;
        count++;
      }
      end.nextNode = start.nextNode;
      start = end.nextNode;
    }
    System.out.println("Last person left standing " + "(Josephus Position) is " + start.data);
  }

  public static void main(String[] args) {
    JosephusAlgorithm j = new JosephusAlgorithm();
    j.josephus(3, 41);
  }
}
