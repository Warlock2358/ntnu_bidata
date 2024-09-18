import java.util.Date;

public class Main {
  private static final int n1 = 10000000;

  public static void main(String[] args) {
    MultiplicativeAlgorithm multiplicativeAlgorithm = new MultiplicativeAlgorithm();

    Date startWhole = new Date();
    int roundsWhole = 0;
    double tidWhole;
    Date endWhole;

    do {
      multiplicativeAlgorithm.multiplyWithWholeNumbers(8000, 5.5);
      endWhole = new Date();
      roundsWhole++;
    } while (endWhole.getTime() - startWhole.getTime() < 1000);
    tidWhole = (double) (endWhole.getTime() - startWhole.getTime()) / roundsWhole;
    System.out.println("Multiplying with whole numbers" + "\nTime: " + tidWhole + " ms");
    System.out.println("Result: " + multiplicativeAlgorithm.multiplyWithWholeNumbers(7000, 5.5));

    Date startEvenOdd = new Date();
    int roundsEvenOdd = 0;
    double tidEvenOdd;
    Date endEvenOdd;

    do {
      multiplicativeAlgorithm.multiplyUsingModulus(n1, 5.5);
      endEvenOdd = new Date();
      roundsEvenOdd++;
    } while (endEvenOdd.getTime() - startEvenOdd.getTime() < 1000);
    tidEvenOdd = (double) (endEvenOdd.getTime() - startEvenOdd.getTime()) / roundsEvenOdd;
    System.out.println("Multiplying using modulus" + "\nTime: " + tidEvenOdd + " ms");
    System.out.println("Result: " + multiplicativeAlgorithm.multiplyUsingModulus(1000000, 5.5));

    Date startBitwise = new Date();
    int roundsBitwise = 0;
    double tidBitwise;
    Date endBitwise;

    do {
      multiplicativeAlgorithm.multiplyUsingBitwiseOperator(n1, 5.5);
      endBitwise = new Date();
      roundsBitwise++;
    } while (endBitwise.getTime() - startBitwise.getTime() < 1000);
    tidBitwise = (double) (endBitwise.getTime() - startBitwise.getTime()) / roundsBitwise;
    System.out.println("Multiplying using bitwise operator" + "\nTime: " + tidBitwise + " ms");
    System.out.println("Result: " + multiplicativeAlgorithm.multiplyUsingBitwiseOperator(1000000, 5.5));

  }
}
