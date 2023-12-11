package ba.unsa.etf.rpr.lv78;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KorisniciTest {
    private KorisnikModel model;

    @BeforeEach
    public void setUp(){
        model = new KorisnikModel();
    }

    @Test
    public void dodajKorisnikaTest1() {
        Korisnik korisnik1 = new Korisnik("Hana", "Hodzic", "hhodzic1@etf.unsa.ba", "hhodzic1", "981");
        Korisnik korisnik2 = new Korisnik("Anida", "Duharkic", "aduharkic1@etf.unsa.ba", "aduharkic1", "111");
        model.dodajKorisnika(korisnik1);
        model.dodajKorisnika(korisnik2);
        ObservableList<Korisnik> korisnici = model.getKorisnici();
        assertEquals(2, korisnici.size());
    }

    @Test
    public void dodajKorisnikaTest2() {
        Korisnik korisnik1 = new Korisnik("Naida", "Pandur", "npandur1@etf.unsa.ba", "npandur1", "222");
        model.dodajKorisnika(korisnik1);
        ObservableList<Korisnik> korisnici = model.getKorisnici();
        assertEquals(korisnik1, korisnici.get(0));
    }

    @Test
    public void toStringTest(){
        Korisnik korisnik = new Korisnik("Nadza", "Poljo", "npoljo1@etf.unsa.ba", "npoljo1", "354");
        model.dodajKorisnika(korisnik);
        ObservableList<Korisnik> korisnici = model.getKorisnici();
        assertEquals(korisnik.toString(), korisnici.get(0).getIme() + " " + korisnici.get(0).getPrezime());
    }

}