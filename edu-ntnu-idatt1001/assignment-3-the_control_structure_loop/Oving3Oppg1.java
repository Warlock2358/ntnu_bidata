package Java.Oving3;

import java.util.Scanner;

public class Oving3Oppg1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Multiplikasjonstabellen");

        System.out.println("Skriv starttall her: ");
        int startTall = in.nextInt();
        System.out.println("Skriv sluttall her: ");
        int sluttTall = in.nextInt();

        if (sluttTall < startTall) {
            System.out.println("Sluttallet må være høyere en starttallet");
            System.exit(0);
        }

        System.out.println("Skriv hvor mange multiplikasjoner som skal vise per tall:");
        int antallMulti = in.nextInt();

        for (int i = startTall; i <= sluttTall; i++) {
            System.out.println(i + "-gangen");
            for (int g = 1; g <= antallMulti; g++) {
                int sum = g * i;
                System.out.println(i + " x " + g + " = " + sum);
            }
        }
        in.close();
    }
}
