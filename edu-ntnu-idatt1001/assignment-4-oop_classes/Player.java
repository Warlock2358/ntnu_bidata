package Java.Oving4;

import java.util.*;

public class Player {
    private static Random dice = new Random();
    private int sumPoints;

    public Player(int points) {
        sumPoints = points;
    }

    public void setSumPoints(int sumPoints) {
        this.sumPoints = sumPoints;
    }

    public int getSum() {
        return sumPoints;
    }

    public int rollDice(int points) {
        int newSum;

        int i = dice.nextInt(6);
        i += 1;
        if (i == 1) {
            newSum = 0;
        } else if (points == 100) {
            newSum = points - i;
        } else {
            newSum = points + i;
        }
        return newSum;
    }

    public boolean done(int points) {
        if (points == 100) {
            return true;
        } else {
            return false;
        }
    }
}
