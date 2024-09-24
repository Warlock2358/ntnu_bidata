package Java.Oving2;

import java.util.Scanner;

class Oving2Oppg1_Scanner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Skriv et årstall her");
        int årstall = Integer.parseInt(in.nextLine());
        in.close();
        if (årstall % 100 == 0)
            if (årstall % 400 == 0)
                System.out.println(årstall + " er et skuddår");
            else
                System.out.println(årstall + " er ikke et skuddår");
        else if (årstall % 4 == 0)
            System.out.println(årstall + " er et skuddår");
        else
            System.out.println(årstall + " er ikke et skuddår");
    }
}