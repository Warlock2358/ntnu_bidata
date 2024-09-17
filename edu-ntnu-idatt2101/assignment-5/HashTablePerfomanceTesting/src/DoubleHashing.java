public class DoubleHashing extends HashTablePerformance {

  public int elementsDouble = 0;
  public long collisionCountDouble = 0;

  public DoubleHashing(int size) {
    super(size);
  }

  public void doubleHash(long x) {
    int pos = hash_1(x);

    if (ht[pos] == null) {
      ht[pos] = x;
      elementsDouble++;
      return;
    }
    int h2 = hash_2(x);
    for (; ; ) {
      pos += h2;
      if (ht[Math.abs(pos%size)] == null) {
        ht[Math.abs(pos%size)] = x;
        elementsDouble++;
        return;
      }
      collisionCountDouble++;
    }
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
