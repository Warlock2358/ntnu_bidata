import java.util.Date;
import java.util.Arrays;

public class Main {

  private final int n = 1000000;

  public int[] randomMillionNumbers() {
    int[] t = new int[n];
    for (int i = 0; i < t.length; i++) {
      t[i] = (int) (Math.random() * 1000000);
    }
    return t;
  }

  public int[] semiRandomMillionNumbers() {
    int[] t = new int[n];
    for (int i = 0; i < t.length; i++) {
      if ((i & 1) == 0) {
        t[i] = 42;
      } else {
        t[i] = (int) (Math.random() * 1000000);
      }
    }
    return t;
  }

  private int sum(int[] t) {
    int sum = 0;
    for (int i : t) {
      sum += i;
    }
    return sum;
  }

  // Test Methods
  public static void checkListSorted(int[] list, int sumBefore) {
    // Testing if the list is sorted
    for (int i = 1; i <= list.length - 1; i++) {
      if (list[i] < list[i - 1]) {
        System.out.println(("Comparison test failed" + list[i] + " < " + list[i - 1]));
      }
    }

    // Testing the sum of the list before and after sorting
    final int sumOftAfterRandom = new Main().sum(list);
    if (sumBefore != sumOftAfterRandom) {
      System.out.println("Sum test failed");
    }

    // Testing the sum of the list before and after sorting with streams
    if(sumBefore != Arrays.stream(list).sum()) System.out.println("Sum test failed with streams");

  }

  public static void main(String[] args) {

    int[] randomList = new Main().randomMillionNumbers();
    int[] randomListHelp = Arrays.copyOf(randomList, randomList.length);
    int[] semiRandomList = new Main().semiRandomMillionNumbers();
    int[] semiRandomListHelp = Arrays.copyOf(semiRandomList, semiRandomList.length);

    final int sumOfRandomList = new Main().sum(randomList);
    final int sumOfRandomListHelp = new Main().sum(randomListHelp);
    final int sumOfSemiRandomList = new Main().sum(semiRandomList);
    final int sumOfSemiRandomListHelp = new Main().sum(semiRandomListHelp);

    int[] insertionLimits = {10, 15, 20, 25, 30, 35, 40, 45, 50, 55};

    Date startRandom = new Date();
    double timeRandom;
    SortingAlgorithm.quickSort(randomList, 0, randomList.length - 1);
    Date endRandom = new Date();
    timeRandom = (double) (endRandom.getTime() - startRandom.getTime());
    System.out.println("Time used for sorting random list without help: " + timeRandom + " ms");

    // Testing if the list is sorted
    checkListSorted(randomList, sumOfRandomList);

    for (int insertionLimit : insertionLimits) {
      int[] randomListHelpInLoop = Arrays.copyOf(randomListHelp, randomListHelp.length);
      SortingAlgorithm.runInsertionSort = insertionLimit;
      System.out.println("Insertion limit: " + SortingAlgorithm.runInsertionSort);

      long startTime = System.nanoTime();
      SortingAlgorithm.quickSortWithHelp(randomListHelpInLoop, 0, randomListHelpInLoop.length - 1);
      long endTime = System.nanoTime();
      double timeRandomHelp = (double) (endTime - startTime) / 1000000;
      System.out.println("Time used for sorting random list with help: " + timeRandomHelp + " ms");

      // Testing if the list is sorted
      checkListSorted(randomListHelpInLoop, sumOfRandomListHelp);
    }

    Date startSemiRandom = new Date();
    double timeSemiRandom;
    SortingAlgorithm.quickSort(semiRandomList, 0, semiRandomList.length - 1);
    Date endSemiRandom = new Date();
    timeSemiRandom = (double) (endSemiRandom.getTime() - startSemiRandom.getTime());
    System.out.println("Time used for sorting semi-random list without help: " + timeSemiRandom + " ms");

    // Testing if the list is sorted
    checkListSorted(semiRandomList, sumOfSemiRandomList);

    Date startSemiRandomHelp = new Date();
    double timeSemiRandomHelp;
    SortingAlgorithm.quickSortWithHelp(semiRandomListHelp, 0, semiRandomListHelp.length - 1);
    Date endSemiRandomHelp = new Date();
    timeSemiRandomHelp = (double) (endSemiRandomHelp.getTime() - startSemiRandomHelp.getTime());
    System.out.println("Time used for sorting semi-random list with help: " + timeSemiRandomHelp + " ms");


    // Testing if the list is sorted
    checkListSorted(semiRandomListHelp, sumOfSemiRandomListHelp);


    Date startSorted = new Date();
    double timeSorted;
    SortingAlgorithm.quickSort(randomList, 0, randomList.length - 1);
    Date endSorted = new Date();
    timeSorted = (double) (endSorted.getTime() - startSorted.getTime());
    System.out.println("Time used for sorting sorted list without help: " + timeSorted + " ms");


    // Testing if the list is sorted
    checkListSorted(randomList, sumOfRandomList);

    SortingAlgorithm.quickSort(randomListHelp, 0, randomListHelp.length - 1);

    Date startSortedHelp = new Date();
    double timeSortedHelp;
    SortingAlgorithm.quickSortWithHelp(randomListHelp, 0, randomListHelp.length - 1);
    Date endSortedHelp = new Date();
    timeSortedHelp = (double) (endSortedHelp.getTime() - startSortedHelp.getTime());
    System.out.println("Time used for sorting sorted list with help: " + timeSortedHelp + " ms");

    // Testing if the list is sorted
    checkListSorted(randomListHelp, sumOfRandomListHelp);

    Date startSemiSorted = new Date();
    double timeSemiSorted;
    SortingAlgorithm.quickSort(semiRandomList, 0, semiRandomList.length - 1);
    Date endSemiSorted = new Date();
    timeSemiSorted = (double) (endSemiSorted.getTime() - startSemiSorted.getTime());
    System.out.println("Time used for sorting semi-sorted list without help: " + timeSemiSorted + " ms");


    // Testing if the list is sorted
    checkListSorted(semiRandomList, sumOfSemiRandomList);

    Date startSemiSortedHelp = new Date();
    double timeSemiSortedHelp;
    SortingAlgorithm.quickSortWithHelp(semiRandomListHelp, 0, semiRandomListHelp.length - 1);
    Date endSemiSortedHelp = new Date();
    timeSemiSortedHelp = (double) (endSemiSortedHelp.getTime() - startSemiSortedHelp.getTime());
    System.out.println("Time used for sorting semi-sorted list with help: " + timeSemiSortedHelp + " ms");

    // Testing if the list is sorted
    checkListSorted(semiRandomListHelp, sumOfSemiRandomListHelp);
  }
}
