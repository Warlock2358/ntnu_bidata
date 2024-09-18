public class HashTablePerformance {

  public int size;
  public Long[] ht;



  //static ArrayList<Long> hashList = new ArrayList<>(Main.capacity);

  public HashTablePerformance(int size) {
    this.size = size;
    this.ht = new Long[size];
  }

  public int hash(long numb) {
    return Math.floorMod(numb, size);
  }

  public int hash_1(long key) {
    return Math.floorMod(key, size);
  }

  public int hash_2(long key) {
    return Math.floorMod((2 * key + 1), size);
  }
}
