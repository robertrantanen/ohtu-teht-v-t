package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KPSpeli {

    public KPSParempiTekoaly() {
        super(new TekoalyParannettu(20));
    }

    @Override
    public String tokaSiirto() {
        String siirto = tekoaly.annaSiirto();
        tekoaly.asetaSiirto(siirto);
        System.out.println("Tietokone valitsi: " + siirto);
        return siirto;
    }

}
