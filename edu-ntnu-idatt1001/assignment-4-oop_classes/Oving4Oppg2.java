package Java.Oving4;

import java.util.*;

public class Oving4Oppg2 {
    public static void main(String[] args) {
        starting();
    }

    public static void starting() {
        System.out.println("Enter 1 to start game");
        System.out.println("Enter 2 to exit");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        if (input == 1) {
            startGame();
        } else if (input == 2) {
            System.out.println("Exiting game");
            System.exit(0);
        } else {
            System.out.println("Entered an invalid input");
            starting();
        }

        in.close();
    }

    public static void startGame() {
        Player[] player = new Player[2];
        player[0] = new Player(0);
        player[1] = new Player(0);

        int roundNumber = 0;

        do {
            System.out.println("Player 1: " + player[0].getSum());
            System.out.println("Player 2: " + player[1].getSum());
            player[0].setSumPoints(player[0].rollDice(player[0].getSum()));
            player[1].setSumPoints(player[1].rollDice(player[1].getSum()));
            System.out.println("Round number: " + roundNumber + ", player 1: " + player[0].getSum() + ", player 2: "
                    + player[1].getSum());
            roundNumber += 1;
        } while (!player[0].done(player[0].getSum()) && !player[1].done(player[1].getSum()));

        if (player[0].done(player[0].getSum()) == true) {
            System.out.println("\nPlayer 1 won!\n");
        } else {
            System.out.println("\nPlayer 2 won!\n");
        }

        System.out.println("Enter 1 to start game");
        System.out.println("Enter 2 to exit");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        if (input == 1) {
            startGame();
        } else if (input == 2) {
            System.out.println("Exiting game");
            System.exit(0);
        } else {
            System.out.println("Entered an invalid input");
            starting();
        }

        in.close();
    }
}
