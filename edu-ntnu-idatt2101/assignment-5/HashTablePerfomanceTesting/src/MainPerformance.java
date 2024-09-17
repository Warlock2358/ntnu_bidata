import java.util.Random;

public class MainPerformance {


  //public static ArrayList<Long> list = new ArrayList<>(capacity);


  public static long[] randomList(int size) {
    Random random = new Random();
    long[] list = new long[size];
    list[0] = random.nextInt(1000);
    for (int i = 1; i < size; i++) {
      list[i] = list[i - 1] + random.nextInt(1000) + 1;
    }
    shuffleArray(list);
    return list;
  }

  public static void shuffleArray(long[] arr) {
    Random rnd = new Random();
    for (int i = 0; i < arr.length; i++) {
      int randomIndex = i + rnd.nextInt(arr.length - i);
      swap(arr, i, randomIndex);
    }
  }

  public static void swap(long[] arr, int i, int j) {
    long temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }


  public static void main(String[] args) {
    int capacity = 12514741; // Prime number
    long[] randomList = randomList(capacity);

    int[] percentages = {50, 80, 90, 99, 100};

    for (int percentage : percentages) {
      int numInsertions = ((capacity * percentage)/100);
      
      // Testing linear probing
      long startTime = System.nanoTime();
      LinearProbe linearProbe = new LinearProbe(capacity);
      for (int i = 0; i < numInsertions; i++) {
        linearProbe.linearProbe(randomList[i]);
      }
      long endTime = System.nanoTime();
      if (linearProbe.countOccupiedSlots() != numInsertions) {
        System.out.println("[WARNING] Linear Probing discrepancy: Expected " + numInsertions + " but found " + linearProbe.countOccupiedSlots());
      }
      long elapsedTime = (endTime - startTime)/1000000;

      System.out.println("Linear Probing for " + percentage + "% fill: Collisions = " +
              linearProbe.collisionCountProbe +", elements = "+ linearProbe.elementsProbe + ", Time = " + elapsedTime + " ms");

      // Testing double hashing
      long startTimeHash = System.nanoTime();
      DoubleHashing doubleHashing = new DoubleHashing(capacity);
      for (int i = 0; i < numInsertions; i++) {
        doubleHashing.doubleHash(randomList[i]);
      }
      long endTimeHash = System.nanoTime();
      if (doubleHashing.countOccupiedSlots() != numInsertions) {
        System.out.println("[WARNING] Double Hashing discrepancy: Expected " + numInsertions + " but found " + doubleHashing.countOccupiedSlots());
      }

      long elapsedTimeHash = (endTimeHash - startTimeHash)/1000000;
      System.out.println("Double Hashing for " + percentage + "% fill: Collisions = " +
              doubleHashing.collisionCountDouble +", elements = "+ doubleHashing.elementsDouble + ", Time = " + elapsedTimeHash + " ms");
    }
  }
}
