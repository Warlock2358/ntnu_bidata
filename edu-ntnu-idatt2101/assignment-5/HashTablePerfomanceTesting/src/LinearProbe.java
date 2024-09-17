public class LinearProbe extends HashTablePerformance {

  public int elementsProbe = 0;
  public long collisionCountProbe = 0;

  public LinearProbe(int size) {
    super(size);
  }

  public int probe(int h, int i, int m) {
    return (h + i) % m;
  }

  public void linearProbe(long k) {
    int m = ht.length;
    int h = hash(k);
    while (ht[h] != null) {
      h = probe(h, 1, m);
      collisionCountProbe++;
    }
    ht[h] = k;
    elementsProbe++;
  }

  public int countOccupiedSlots() {
    int count = 0;
    for (Long aLong : ht) {
      if (aLong != null) {
        count++;
      }
    }
    return count;
  }
}
