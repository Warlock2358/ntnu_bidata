package Java.Oving6_v2;

import java.util.*;

public class RandomNumberGen {
    private static Random random = new Random();
    private static int rounds = 1000;
    private static int numbers = 10;
    private static int[] amount = new int[numbers];

    public static void main(String[] args) {
        for (int i = 0; i < rounds; i++) {
            int number = random.nextInt(numbers);
            amount[number]++;
        }

        for (int i = 0; i < numbers; i++) {
            System.out.println("Number " + i + " was generated " + amount[i] + " times");
        }
    }
}
