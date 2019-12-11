package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        PeliTehdas tehdas = new PeliTehdas();

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            if (vastaus.endsWith("a")) {
                tehdas.luoKaksinPeli();
            } else if (vastaus.endsWith("b")) {
                tehdas.luoHelppoTekoaly();
            } else if (vastaus.endsWith("c")) {
                tehdas.luoVaikeaTekoaly();
            } else {
                break;
            }

        }

    }
}
