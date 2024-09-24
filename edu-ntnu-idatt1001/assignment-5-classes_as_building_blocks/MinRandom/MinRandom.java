package Java.Oving5.MinRandom;

import java.util.*;

// Husk å separete klasser i egne filer for å holde styr på dem
// Gjør det for de resterende øvingene også

public class MinRandom { // Oving 5 Oppgave 2
    private static Random random = new Random();

    public int nextInt(int lower, int upper) {
        int max = upper - lower;
        int result = random.nextInt(max);
        result = result + lower;
        return result;
    }

    public double nextDouble(double lower, double upper) {
        double difference = upper - lower;
        double randomDouble = random.nextDouble();
        double result = lower + (difference * randomDouble);
        return result;
    }

}
