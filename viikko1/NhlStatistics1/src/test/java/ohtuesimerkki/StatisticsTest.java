package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };
    
    Statistics stats;
    Player testiPelaaja;
    ArrayList<Player> testiPelaajat;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
        testiPelaaja = new Player("Semenko", "EDM", 4, 12);            
        testiPelaajat = new ArrayList<>();
        testiPelaajat.add(new Player("Semenko", "EDM", 4, 12));
        testiPelaajat.add(new Player("Kurri", "EDM", 37, 53));
        testiPelaajat.add(new Player("Gretzky", "EDM", 35, 89));
    }  
    
    
    @Test
    public void searchTest() {
        assertEquals(testiPelaaja.toString(), stats.search("Semenko").toString());
    }

    @Test
    public void searchTestVirheellisellaSyotteellaPalauttaaNull() {
        assertEquals(null, stats.search("pekka"));
    }    
    
    @Test
    public void teamTest() {
        assertEquals(testiPelaajat.toString(), stats.team("EDM").toString());
    }

}
