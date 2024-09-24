package Java.Oving6_v2.Matriser;

import java.util.*;

// Fjern static i Matrise.java
// Kall på objektene sin metode
// Lag objektene

// Aldri bruk static utenom klientprogrammet og main-metoden

public class Oppgave3 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        double[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        Matrise A = new Matrise(a);
        double[][] b = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        Matrise B = new Matrise(b);

        int k = 1;
        while (k == 1) {
            System.out.println("Velkommen til matrisekalkulatoren!");
            System.out.println("Tast 1 for starte, tast 2 for å avslutte");
            int valg = in.nextInt();

            if (valg == 1) {
                A = new Matrise(lagMatrise());
                System.out.println("Lag den første matrisen.");
                skrivUtMatrise(A);
                visMeny(A, B);
            } else if (valg == 2) {
                System.out.println("Programmet avsluttes");
                System.exit(1);
            } else {
                System.out.println("Ugyldig valg, prøv igjen");
            }
        }
    }

    public static void visMeny(Matrise A, Matrise B) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Tast 1 for å addere en matrise til den første matrisen");
            System.out.println("Tast 2 for å multiplisere den første matrisen med en annen matrisen");
            System.out.println("Tast 3 for å transponere den første matrisen");

            int menyInput = in.nextInt();
            switch (menyInput) {
                case 1:
                    B = new Matrise(lagMatrise(A.getAntallRader(), A.getAntallKolonner()));
                    System.out.println("Matrise nr. 2:");
                    skrivUtMatrise(B);
                    Matrise c = A.addereMatriser(B);
                    System.out.println("Resultat:");
                    skrivUtMatrise(c);
                    break;
                case 2:
                    System.out.println(
                            "Lag matrise nr. 2 (antall rader må være lik " + A.getAntallKolonner() + "):");
                    B = new Matrise(lagMatrise());
                    System.out.println("Matrise nr. 2:");
                    skrivUtMatrise(B);
                    Matrise d = A.multiplisereMatriser(B);
                    if (d != null) {
                        System.out.println("Resultat:");
                        skrivUtMatrise(d);
                    } else {
                        System.out
                                .println(
                                        "Noe gikk galt, antall kolonner i matrise 1 må være lik antall rader i matrise 2");
                    }
                    break;
                case 3:
                    Matrise e = A.transponereMatrise();
                    System.out.println("Resultat:");
                    skrivUtMatrise(e);
                    break;
            }
        }
    }

    public static double[][] lagMatrise() {
        System.out.print("Tast inn antall rader: ");
        int antallRader = in.nextInt();
        System.out.print("Tast inn antall kolonner: ");
        int antallKolonner = in.nextInt();
        double[][] m = new double[antallRader][antallKolonner];

        System.out.println("Tast inn tallene i matrisen: ");
        for (int i = 0; i < antallRader; i++) {
            for (int j = 0; j < antallKolonner; j++) {
                System.out.print("[" + i + "][" + j + "]: ");
                m[i][j] = in.nextDouble();
            }
        }
        return m;
    }

    public static double[][] lagMatrise(int rader, int kolonner) {
        double[][] m = new double[rader][kolonner];

        System.out.println("Fyll inn matrisen: ");
        for (int i = 0; i < rader; i++) {
            for (int j = 0; j < kolonner; j++) {
                System.out.print("[" + i + "]" + "[" + j + "]: ");
                m[i][j] = in.nextDouble();
            }
        }
        return m;
    }

    public static void skrivUtMatrise(Matrise m) {
        int rader = m.getAntallRader();
        int kolonner = m.getAntallKolonner();
        double[][] t = m.getMatrise();
        for (int i = 0; i < rader; i++) {
            String rad = "";
            for (int j = 0; j < kolonner; j++) {
                rad += t[i][j] + " ";
            }
            System.out.println(rad);
        }
    }
}
