package Java.Oving2;

import java.util.Scanner;

class Oving2Oppg2_Scannner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(
                "For et eksempel av pris sammenligning per gram skriv tallet 0. For egne verdier skriv tallet 1");
        int out = in.nextInt(); // Here I am changing the type of the variable in to be an integer
        // in.close();
        double prisA = 35.9;
        int vektA = 450;
        double prisB = 39.5;
        int vektB = 500;

        double prisvektA = prisA / vektA; // Here I divide the price of the meat from brand A by the weight of the meat
                                          // from brand A
        double prisvektB = prisB / vektB; // Here I divide the price of the meat from brand B by the weight of the meat
                                          // from brand B
        String merkeA = "Merke A veier 450 gram og har en pris på 35,90 kroner. Det vil si at prisen per gram er: "
                + prisvektA;
        String merkeB = "Merke B veier 500 gram og har en pris på 39,50 kroner. Det vil si at prisen per gram er: "
                + prisvektB;

        if (out == 0) { // Here I am checking whether the user wants an example of a comparison between
                        // brands
            System.out.println(merkeA);
            System.out.println(merkeB);
            if (prisvektA > prisvektB) // This if else statement checks which brand has the best deal
                System.out.println(
                        "I forhold til antall kroner per gram er det merke B som har best forhold, med et forhold på "
                                + prisvektB + " kroner per gram.");
            else
                System.out.println(
                        "I forhold til antall kroner per gram er det merke A som har best forhold, med et forhold på "
                                + prisvektA + " kroner per gram.");
        } else if (out == 1) {
            // Scanner mpA = new Scanner(System.in);
            System.out.println("Skriv in vekten til kjøttdeigen til merke A her:");
            // mpA.nextLine();
            double avekt = in.nextDouble();
            // mpA.close();
            // Scanner mvA = new Scanner(System.in);
            System.out.println("Skriv in prisen til kjøttdeigen til merke A her: ");
            double apris = in.nextDouble();
            // mvA.close();
            double forholdA = apris / avekt;
            // System.out.println(forholdA);
            System.out.println("Skriv in vekten til kjøttdeigen til merke B her:");
            double bvekt = in.nextDouble();
            System.out.println("Skriv in prisen til kjøttdeigen til merke B her:");
            double bpris = in.nextDouble();
            double forholdB = bpris / bvekt;

            if (forholdA > forholdB) // This if else statement checks which brand has the best deal
                System.out.println(
                        "I forhold til antall kroner per gram er det merke B som har best forhold, med et forhold på "
                                + forholdB + " kroner per gram.");
            else if (forholdA < forholdB)
                System.out.println(
                        "I forhold til antall kroner per gram er det merke A som har best forhold, med et forhold på "
                                + forholdA + " kroner per gram.");
            else
                System.out.println("Det er ingen forskjell mellom merka A og merke B når det gjelder kroner per gram.");
        }
        in.close();
    }
}