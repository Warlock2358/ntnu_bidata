public class HashListTextKey {
  public int collisionCount;
  int capacity = 256;
  NodeTextKey[] table = new NodeTextKey[capacity];


  public int stringHash(String s, int n) {
    int hash = 0;
    for (int i = s.length(); i-- > 0;) {
      hash = (hash * 7 + s.charAt(i)) % n;
    }
    return hash;
  }

  public void addElement(String name) {
    NodeTextKey node = new NodeTextKey(name, capacity);
    if (table[(node.hash)] != null) {
      System.out.println("Collision at: " + node.getHash() + " | Name 1: " + node.name + " | Name 2: " + table[(node.hash)].name);
      node.next = table[(node.hash)];
      collisionCount++;
    }
    table[(node.hash)] = node;
  }

  public String checkIfStudentsExists(String name) {
    int hash = stringHash(name, capacity);
    NodeTextKey node = table[hash];
    if (node == null) {
      return "Student does not exist";
    } else {
      while (node != null) {
        if (node.name.equals(name)) {
          return "Student in the list at index: " + hash;
        }
        node = node.next;
      }
    }
    return "Student does not exist";
  }
}
