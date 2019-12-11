package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class KPSpeli {

    protected Scanner scanner;
    protected Tuomari tuomari;
    protected Tekoaly tekoaly;

    public KPSpeli(Tekoaly tekoaly) {
        this.scanner = new Scanner(System.in);
        this.tuomari = new Tuomari();
        this.tekoaly = tekoaly;
        pelaa();
    }

    public KPSpeli() {
        this(null);
    }

    public void pelaa() {

        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");

        while (true) {

            System.out.println("Ensimmäisen pelaajan siirto: ");
            String ekanSiirto = scanner.nextLine();

            if (!onkoOkSiirto(ekanSiirto)) {
                break;
            }

            String tokanSiirto = tokaSiirto();

            if (!onkoOkSiirto(tokanSiirto)) {
                break;
            }

            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    protected abstract String tokaSiirto();

    private boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

}
