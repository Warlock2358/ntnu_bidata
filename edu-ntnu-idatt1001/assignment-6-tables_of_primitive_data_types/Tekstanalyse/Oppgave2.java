package Java.Oving6_v2.Tekstanalyse;

import java.util.*;

public class Oppgave2 {
    public static void main(String[] args) {
        int k = 1;
        while (k == 1) {
            Scanner in = new Scanner(System.in);
            System.out.println("Tast 1 for å analysere en tekst, tast 2 for å avslutte");
            int a = in.nextInt();
            if (a == 1) {
                start();
            } else if (a == 2) {
                System.out.println("Programmet avsluttes");
                System.exit(1);
            } else {
                System.out.println("Ugyldig input");
            }
        }

    }

    public static void start() {
        Scanner in = new Scanner(System.in);
        System.out.println("Tast inn teksten du vil analysere:");
        String input = in.nextLine();
        Tekstanalyse tekstanalyse = new Tekstanalyse(input);
        analyser(tekstanalyse);
    }

    public static void analyser(Tekstanalyse tekstanalyse) {
        System.out.println("Antall forskjellige bokstaver: " + tekstanalyse.getAntallForskjellige());
        System.out.println("Antall bokstaver: " + tekstanalyse.getAntallBokstaver());
        System.out.println("Prosentandel som ikke er bokstaver: " + tekstanalyse.getAntallIkkeBokstaver() + "%");
        System.out.println(tekstanalyse.getFlestForekomster());
    }
}
