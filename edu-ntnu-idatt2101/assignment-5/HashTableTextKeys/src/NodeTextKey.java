public class NodeTextKey {
  String name;
  NodeTextKey next = null;
  int hash;
  HashListTextKey hashList = new HashListTextKey();

  public NodeTextKey(String name, int listSize) {
    this.name = name;
    this.hash = hashList.stringHash(name, listSize);
  }

  public int getHash() {
    return hash;
  }


}
