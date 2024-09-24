package Java.Oving4;

import java.util.*;

public class Oving4Oppg1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Tast 1 for å konvertere fra NOK");
        System.out.println("Tast 2 for å konvertere til NOK");
        System.out.println("Tast 3 for å stoppe");

        Valuta USD = new Valuta(9.9388f);
        Valuta EUR = new Valuta(9.9388f);
        Valuta SEK = new Valuta(0.9307f);

        int Valg = in.nextInt();
        if (Valg == 3) {
            System.out.println("Stopper");
            System.exit(0);
        }
        if (Valg != 1 && Valg != 2) {
            System.out.println("Vennligst tast et tall mellom 1 og 3");
            System.exit(0);
        }

        while (Valg != 3) {
            switch (Valg) {
                case 1:
                    System.out.println("Tast 1 for å konvertere til USD");
                    System.out.println("Tast 2 for å konvertere til EUR");
                    System.out.println("Tast 3 for å konvertere til SEK");
                    System.out.println("Tast 4 for å stoppe");

                    int Input1 = in.nextInt();

                    switch (Input1) {
                        case 1:
                            System.out.println("Hvor mange NOK vil du konvertere til USD?");

                            int antall1 = in.nextInt();
                            float sum1 = USD.fraNok(antall1);

                            System.out.println(antall1 + " NOK er lik " + sum1 + " USD");
                            break;

                        case 2:
                            System.out.println("Hvor mange NOK vil du konvertere til EUR?");

                            int antall2 = in.nextInt();
                            float sum2 = EUR.fraNok(antall2);

                            System.out.println(antall2 + " NOK er lik " + sum2 + " EUR");
                            break;

                        case 3:
                            System.out.println("Hvor mange NOK vil du konvertere til SEK?");

                            int antall3 = in.nextInt();
                            float sum3 = SEK.fraNok(antall3);

                            System.out.println(antall3 + " NOK er lik " + sum3 + " SEK");
                            break;

                        case 4:
                            System.out.println("Stopper");
                            System.exit(0);

                        default: // Dette blir kjørt vis inputet ikke stemmer med noen av casene
                            System.out.println("Vennligst kjør programmet igjen og tast et tall mellom 1 og 4.");
                            System.exit(0);
                    }
                    break;
                case 2:
                    System.out.println("Tast 1 for å konvertere fra USD");
                    System.out.println("Tast 2 for å konvertere fra EUR");
                    System.out.println("Tast 3 for å konvertere fra SEK");
                    System.out.println("Tast 4 for å stoppe");

                    int Input2 = in.nextInt();

                    switch (Input2) {
                        case 1:
                            System.out.println("Hvor mange USD vil du konvertere til NOK?");

                            int antall1 = in.nextInt();
                            float sum1 = USD.tilNok(antall1);

                            System.out.println(antall1 + " USD er lik " + sum1 + " NOK");
                            break;

                        case 2:
                            System.out.println("Hvor mange EUR vil du konvertere til NOK?");

                            int antall2 = in.nextInt();
                            float sum2 = EUR.tilNok(antall2);

                            System.out.println(antall2 + " EUR er lik " + sum2 + " NOK");
                            break;

                        case 3:
                            System.out.println("Hvor mange SEK vil du konvertere til NOK?");

                            int antall3 = in.nextInt();
                            float sum3 = SEK.tilNok(antall3);

                            System.out.println(antall3 + " SEK er lik " + sum3 + " NOK");
                            break;

                        case 4:
                            System.out.println("Stopper");
                            System.exit(0);

                        default: // Dette blir kjørt vis inputet ikke stemmer med noen av casene
                            System.out.println("Vennligst kjør programmet igjen og tast et tall mellom 1 og 4.");
                            System.exit(0);
                            break;
                    }
                    break;
            }
            in.reset();
            System.out.println("Tast 1 for å konvertere fra NOK");
            System.out.println("Tast 2 for å konvertere til NOK");
            System.out.println("Tast 3 for å stoppe");

            Valg = in.nextInt();
            if (Valg == 3) {
                System.out.println("Stopper");
                System.exit(0);
            }
            if (Valg != 1 && Valg != 2) {
                System.out.println("Vennligst tast et tall mellom 1 og 3");
                System.exit(0);
            }

        }
        in.close();
    }
}
