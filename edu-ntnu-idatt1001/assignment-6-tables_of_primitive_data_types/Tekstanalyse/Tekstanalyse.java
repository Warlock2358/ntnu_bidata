package Java.Oving6_v2.Tekstanalyse;

import java.util.*;

public class Tekstanalyse {
    private static String[] bokstaver = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "æ", "ø", "å" };
    private static int[] antallTegn;

    /**
     * Tekstanalyse konstruktør. Bruker parameteren input til å lage en liste med
     * hver enkelt bokstav og setter verdien dere til 0. Så gjør den input stringen
     * om til små bokstaver og går gjennom hver enkelt bokstav og øker verdien i
     * listen med 1 *
     */
    public Tekstanalyse(String input) {
        // 1. Declare an array of 30 integers.
        // 2. Initialize the array to all zeros.
        // 3. For each character in the string, increment the appropriate element in the
        // array.
        antallTegn = new int[30];
        for (int i = 0; i < 30; i++) {
            antallTegn[i] = 0;
        }

        // 1. The input is converted to lowercase.
        // 2. The length of the input is found.
        // 3. For each character in the input, the character is converted to a string
        // and the index of the character is found.
        // 4. If the character is not found in the list of characters, the index is set
        // to 29.
        // 5. The number of times the character appears in the input is incremented.
        input = input.toLowerCase(); // Gjør om til små bokstaver
        int lengde = input.length(); // Finner lengden på input
        for (int a = 0; a < lengde; a++) {
            char indeksTegn = input.charAt(a); // Finner tegnet på indeksen
            String bokstav = Character.toString(indeksTegn);
            int indeks = Arrays.asList(bokstaver).indexOf(bokstav);
            if (indeks == -1) {
                indeks = 29;
            }
            antallTegn[indeks]++;
        }
    }

    // 1. The method `getAntallForskjellige` loops through the array `antallTegn`
    // and counts the number of elements that are greater than zero.
    // 2. The method `getAntallForskjellige` returns the number of elements that are
    // greater than zero.
    public int getAntallForskjellige() {
        int sum = 0;
        for (int i = 0; i < 29; i++) {
            if (antallTegn[i] > 0) {
                sum++;
            }
        }
        return sum;
    }

    // 1. The method `getAntallBokstaver()` returns the sum of all the elements in
    // the array `antallTegn`.
    // 2. The method `getAntallBokstaver()` is called from the main method.
    // 3. The main method prints the sum of all the elements in the array
    // `antallTegn`.
    public int getAntallBokstaver() {
        int sum = 0;
        for (int i = 0; i < 29; i++) {
            sum = antallTegn[i] + sum;
        }
        return sum;
    }

    public double getAntallIkkeBokstaver() {
        int antallBokstaver = getAntallBokstaver();
        int antallIkke = antallTegn[29];

        double total = antallBokstaver + antallIkke;
        double prosent = (antallIkke / total) * 100;
        prosent = Math.round(prosent * 100) / 100;
        return prosent;
    }

    public static int getAntallSpesifikkBokstav(String bokstav) {
        int indeks = Arrays.asList(bokstaver).indexOf(bokstav);
        int sum = 0;
        if (indeks > -1) {
            sum = antallTegn[indeks];
        }
        return sum;
    }

    public String getFlestForekomster() {
        int hoyest = -1;
        String hoyestBokstav = "";
        for (int i = 0; i < 29; i++) {
            if (antallTegn[i] > hoyest) {
                hoyest = antallTegn[i];
                hoyestBokstav = bokstaver[i];
            } else if (antallTegn[i] == hoyest) {
                hoyestBokstav = hoyestBokstav + ", " + bokstaver[i];
            }
        }
        return "Bokstaven(e) som forekommer oftest er \"" + hoyestBokstav + "\" (" + hoyest + " ganger)";
    }
}
