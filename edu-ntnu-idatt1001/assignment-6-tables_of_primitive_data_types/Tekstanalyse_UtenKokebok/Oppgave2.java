package Java.Oving6_v2.Tekstanalyse_UtenKokebok;

import java.util.*;

import Java.Oving6_v2.Tekstanalyse_UtenKokebok.Tekstanalyse;

public class Oppgave2 {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Tast 1 for å analysere teksten, tast 2 for å avslutte");
            int valg = in.nextInt();

            if (valg == 1) {
                start();
            } else if (valg == 2) {
                System.out.println("Programmet avsluttes");
                break;
            } else {
                System.out.println("Ugyldig valg, prøv igjen");
            }

        }
        in.close();
        System.exit(1);
    }

    public static void start() {
        System.out.println("Skriv inn en tekst");
        in.nextLine();
        String input = in.nextLine();

        Tekstanalyse tekstanalyse = new Tekstanalyse(input);
        analyser(tekstanalyse);
    }

    public static void analyser(Tekstanalyse tekstanalyse) {
        System.out.println("Antall forskjellige bokstaver: " + tekstanalyse.getAntallForskjellige());
        //System.out.println("Antall bokstaver: " + tekstanalyse.getAntallBokstaver());
        //System.out.println("Prosentandel som ikke er bokstaver: " + tekstanalyse.getAntallIkkeBokstaver() + "%");
        System.out.println(tekstanalyse.getFlestForekomster());

        // Hent antall forekomster av en spesifikk bokstav:
        // System.out.println(tekstanalyse.getAntallSpesifikkBokstav("o"));
    }
}
