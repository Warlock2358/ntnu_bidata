package Java.Oving3;

import java.util.*;

public class Oving3Oppg2 {
    public static void main(String[] args) {
        check();
    }

    public static void check() {
        Scanner in = new Scanner(System.in);
        System.out.println("Skriv et tall for å sjekke om det er et primtall");
        int tall = in.nextInt();

        boolean primtall = true;

        for (int i = 2; i <= tall / 2; i++) {
            int mid = tall % i;
            if (mid == 0) {
                primtall = false;
                break;
            }
        }

        if (tall == 0 || tall == 1) {
            primtall = false;
        }
        if (primtall) {
            System.out.println(tall + " er et primtall");
        } else {
            System.out.println(tall + " er ikke et primtall");
        }

        System.out.println("---");
        check();
        in.close();
    }
}
