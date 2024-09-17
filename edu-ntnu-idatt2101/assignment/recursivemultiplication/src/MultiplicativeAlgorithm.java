public class MultiplicativeAlgorithm {

  public double multiplyWithWholeNumbers(int n, double x) {
    if (n == 1) {
      return x;
    } else {
      return x + multiplyWithWholeNumbers((n - 1), x);
    }
  }

  public double multiplyUsingModulus(int n, double x) {
    if (n == 1) {
      return x;
    }

    // Checks if the number n is even using the modulus operation
    if (n % 2 == 0) {
      return multiplyUsingModulus(n/2, x + x);
    } else {
      return x + multiplyUsingModulus((n - 1)/2, x + x);
    }
  }

  public double multiplyUsingBitwiseOperator (int n, double x) {
    if (n == 1) {
      return x;
    }

    // Checks if the given number n is even using a bitwise operation
    if ((n & 1) == 0) {
      return multiplyUsingBitwiseOperator(n/2, x + x);
    } else {
      return x + multiplyUsingBitwiseOperator((n - 1)/2, x + x);
    }
  }
}
