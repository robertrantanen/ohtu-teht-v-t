package ohtu.kivipaperisakset;

public class PeliTehdas {

    public KPSpeli luoKaksinPeli() {
        return new KPSPelaajaVsPelaaja();
    }

    public KPSpeli luoHelppoTekoaly() {
        return new KPSTekoaly();
    }

    public KPSpeli luoVaikeaTekoaly() {
        return new KPSParempiTekoaly();
    }

}
