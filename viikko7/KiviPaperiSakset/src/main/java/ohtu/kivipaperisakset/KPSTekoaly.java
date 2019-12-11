package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KPSpeli {   

    public KPSTekoaly() {
        super(new Tekoaly());
    }

    @Override
    public String tokaSiirto() {
        String siirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + siirto);
        return siirto;
    }
    
    


}