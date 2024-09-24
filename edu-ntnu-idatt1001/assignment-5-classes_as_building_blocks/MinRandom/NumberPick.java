package Java.Oving5.MinRandom;

import java.util.*;

public class NumberPick {
    private static MinRandom minRandom = new MinRandom();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
        // testRun();
    }

    public static void testRun() {
        System.out.println("Integers between 10 and 20:");
        for (int i = 0; i < 20; i++) {
            System.out.println(minRandom.nextInt(10, 20));
        }
        System.out.println("Decimals between 10 and 20:");
        for (int i = 0; i < 20; i++) {
            System.out.println(minRandom.nextDouble(10, 20));
        }
    }

    public static void showMenu() {
        System.out.println("Enter the lower bound of the interval:");
        int lower = in.nextInt();
        System.out.println("Enter the upper bound of the interval:");
        int upper = in.nextInt();

        System.out.println("Press 1 for integer");
        System.out.println("Press 2 for decimal");
        System.out.println("Press 3 to exit");

        int menuInput = in.nextInt();
        if (menuInput == 1) {
            System.out.println(minRandom.nextInt(lower, upper));
            showMenu();
        } else if (menuInput == 2) {
            System.out.println(minRandom.nextDouble(lower, upper));
            showMenu();
        } else if (menuInput == 3) {
            System.out.println("Exiting...");
        } else {
            System.out.println("Invalid input");
            showMenu();
            return;
        }
    }
}
