package ba.unsa.etf.rpr;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ImenikTest {

    private static Imenik imenik = new Imenik();

    @BeforeAll
    public static void setup(){
        imenik.dodaj("Una", new FiksniBroj(Grad.SARAJEVO,"111222"));
        imenik.dodaj("Hana", new MobilniBroj(61,"444555"));
        imenik.dodaj("Anida", new MedunarodniBroj("+44","223445"));
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
    public void dajBrojImeNePostoji() {
        imenik = new Imenik();
        String ime = "Eman";

        String provjera = imenik.dajBroj(ime);
        assertNull(provjera);
    }


    @Test
    public void testMockExternal(){
        Imenik imenik = Mockito.mock(Imenik.class);
        Mockito.when(imenik.dajBroj("Eman")).thenReturn("Nema rezultata");
        String test = imenik.dajBroj("Eman");
        assertEquals(test,"Nema rezultata");
    }

}