package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KPSpeli {

    public KPSPelaajaVsPelaaja() {
    }

    @Override
    public String tokaSiirto() {
        System.out.println("Toisen pelaajan siirto: ");
        return scanner.nextLine();
    }

}
