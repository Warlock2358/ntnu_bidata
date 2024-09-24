package Java.Oving6_v2.Tekstanalyse_UtenKokebok;

import java.util.*;

public class Tekstanalyse {
    private static int[] antallTegn = new int[30];
    private static String[] bokstaver = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
            "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "æ", "ø", "å" };
    private static String alf = "abcdefghijklmnopqrstuvwxyzæøå";
    private static int unikbokstav;
    private static String k;

    public Tekstanalyse(String input) {
        for (int i = 0; i < 29; i++) {
            antallTegn[i] = 0;
        }
        input = input.toLowerCase();
        int lengde = input.length();

        for (int a = 0; a < lengde; a++) {
            Character indeksTegn = input.charAt(a);
            int indeks = alf.indexOf(indeksTegn);

            if (indeks > 0) {
                antallTegn[indeks]++;
                k = Arrays.toString(antallTegn);
                System.out.println(k);
            } else {
                antallTegn[29]++;
                k = Arrays.toString(antallTegn);
                System.out.println(k);
            }
        }

        // Unike bokstaver
        for (int i = 0; i < antallTegn.length; i++) {
            if (antallTegn[i] != 0) {
                unikbokstav++;
            }
        }
    }

    public int getAntallForskjellige() {
        return unikbokstav;
    }

    public static int getAntallTegn() {
        int sum = 0;
        for (int i = 0; i < 29; i++) {
            sum = antallTegn[i] + sum;
        }
        return sum;
    }

    public double getProsentIkkeBokstaver() {
        int antallBokstaver = getAntallTegn();
        int antallAndre = antallTegn[29];
        double totalt = antallBokstaver + antallAndre;
        double prosent = (antallAndre / totalt) * 100;
        // Rund av
        prosent = Math.round(prosent * 100.0) / 100.0;
        return prosent;
    }

    public int getAntallSpesifikkBokstav(String bokstav) {
        int indeks = alf.indexOf(bokstav);
        int sum = 0;
        if (indeks > -1) {
            sum = antallTegn[indeks];
        }
        return sum;
    }

    public String getFlestForekomster() {
        int max = -1;
        String hoyestBokstav = "";
        for (int i = 0; i < antallTegn.length; i++) {
            if (antallTegn[i] > max) {
                max = antallTegn[i];
                hoyestBokstav = bokstaver[i];
            } else if (antallTegn[i] == max) {
                hoyestBokstav = hoyestBokstav + ", ";
            }
        }
        return "Bokstaven(e) " + hoyestBokstav + " forekommer flest ganger med " + max + " forekomster.";
    }
}

// public class Tekstanalyse {
// private static int[] antallTegn = new int[30];
// private static String[] bokstaver = { "a", "b", "c", "d", "e", "f", "g", "h",
// "i", "j", "k", "l", "m", "n", "o",
// "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "æ", "ø", "å" };
// private static String alf = "abcdefghijklmnopqrstuvwxyzæøå";
// private static String input = "Hallo på deg din gamle dust";
// private static int bokstav;
// private static String k;

// public static void main(String[] args) {
// for (int i = 0; i < 29; i++) {
// antallTegn[i] = 0;
// }
// input = input.toLowerCase();
// int lengde = input.length();

// for (int a = 0; a < lengde; a++) {
// Character indeksTegn = input.charAt(a);
// int indeks = alf.indexOf(indeksTegn);

// if (indeks > 0) {
// antallTegn[indeks]++;
// k = Arrays.toString(antallTegn);
// System.out.println(k);
// } else {
// antallTegn[29]++;
// k = Arrays.toString(antallTegn);
// System.out.println(k);
// }
// }

// for (int i = 0; i < antallTegn.length; i++) {
// if (antallTegn[i] != 0) {
// bokstav++;
// }
// }
// }
// }
