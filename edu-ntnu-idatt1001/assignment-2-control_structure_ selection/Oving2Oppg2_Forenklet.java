package Java.Oving2;

public class Oving2Oppg2_Forenklet {
        public static void main(String[] args) {
                double prisA = 35.9;
                int vektA = 450;
                double prisB = 39.5;
                int vektB = 500;
                double prisvektA = prisA / vektA;
                double prisvektB = prisB / vektB;
                String merkeA = "Merke A veier 450 gram og har en pris på 35,90 kroner. Det vil si at prisen per gram er: "
                                + prisvektA;
                String merkeB = "Merke B veier 500 gram og har en pris på 39,50 kroner. Det vil si at prisen per gram er: "
                                + prisvektB;
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
        }
}