package ba.unsa.etf.rpr.lab3;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ImenikTest {

    private static Imenik imenik = new Imenik();

    @Test
    public void dodaj() {
        TelefonskiBroj broj = new MobilniBroj(61,"019982");
        imenik.dodaj("Sabina",broj);

        String broj1 = imenik.dajBroj("Sabina");
        assertEquals(broj1, "061/019-982");
    }

    @Test
    public void dajBrojImeNePostoji() {
        imenik = new Imenik();
        String ime = "Eman";

        String provjera = imenik.dajBroj(ime);
        assertNull(provjera);
    }

    @Test
    public void dajBrojImePostoji() {
        imenik = new Imenik();
        String ime = "Una";
        TelefonskiBroj broj = new MobilniBroj(62,"111222");
        imenik.dodaj(ime, broj);
        String provjera = imenik.dajBroj(ime);

        assertEquals(broj.ispisi(),provjera);
    }

    @Test
    void dajIme() {
    }

    @Test
    void naSlovo() {
    }

    @Test
    void izGrada() {
    }

    @Test
    void izGradaBrojevi() {
    }
}