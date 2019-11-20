package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, OLETUSKASVATUS = 5;
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukuJoukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        lukuJoukko = new int[kapasiteetti];
        for (int i = 0; i < lukuJoukko.length; i++) {
            lukuJoukko[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (!kuuluuJoukkoon(luku)) {
            lukuJoukko[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm == lukuJoukko.length) {
                lisaaJoukonKokoa();
            }
            return true;
        }
        return false;
    }

    public boolean kuuluuJoukkoon(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukuJoukko[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukuJoukko[i]) {
                lukuJoukko[i] = 0;
                siirraAlkioitaVasemmalle(i);
                alkioidenLkm --;
                return true;
            }
        }
        return false;
    }

    private void siirraAlkioitaVasemmalle(int kohta) {
        for ( ; kohta < alkioidenLkm - 1; kohta++) {
            int apu = lukuJoukko[kohta];
            lukuJoukko[kohta] = lukuJoukko[kohta + 1];
            lukuJoukko[kohta + 1] = apu;
        }
    }

    private void lisaaJoukonKokoa() {
        int[] vanhaJoukko = lukuJoukko;
        lukuJoukko = new int[alkioidenLkm + kasvatuskoko];
        for (int i = 0; i < vanhaJoukko.length; i++) {
            lukuJoukko[i] = vanhaJoukko[i];
        }
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + lukuJoukko[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += lukuJoukko[i] + ", ";
            }
            tuotos += lukuJoukko[alkioidenLkm - 1];
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulukko = new int[alkioidenLkm];
        for (int i = 0; i < taulukko.length; i++) {
            taulukko[i] = lukuJoukko[i];
        }
        return taulukko;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            yhdiste.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            yhdiste.lisaa(bTaulu[i]);
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    leikkaus.lisaa(bTaulu[j]);
                }
            }
        }
        return leikkaus;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            erotus.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            erotus.poista(bTaulu[i]);
        }

        return erotus;
    }

}
