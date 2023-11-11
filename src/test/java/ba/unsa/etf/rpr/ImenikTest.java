package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ImenikTest {

    private static Imenik imenik= new Imenik();

    @BeforeAll
    public static void popuniImenik(){
        imenik.dodaj("Una",new MobilniBroj(62,"111222"));
        imenik.dodaj("Hana",new MobilniBroj(62,"333444"));
        imenik.dodaj("Nadza",new FiksniBroj(Grad.SARAJEVO,"654567"));
        imenik.dodaj("Nadina",new MedunarodniBroj("+387","353555"));
        imenik.dodaj("Nerma",new FiksniBroj(Grad.BANOVICI,"324465"));
        imenik.dodaj("Amila",new FiksniBroj(Grad.BANOVICI,"777989"));
        imenik.dodaj("Amina",new FiksniBroj(Grad.KLJUC,"345644"));
    }
    @Test
    void dodajIspravo() {
        TelefonskiBroj b = new MobilniBroj(65,"258-741");
        imenik.dodaj("Amela",b);

        String br = imenik.dajBroj("Amela");
        assertEquals(br,"065/258-741");
    }

    @Test
    void dajBrojIma() {
        String s = imenik.dajBroj("Amila");
        assertEquals(s,"035/123-456");
    }
    @Test
    void dajBrojNema() {
        String s = imenik.dajBroj("Amela");
        assertNull(s);
    }

    @Test
    public void testMockExternal(){
        Imenik i = Mockito.mock(Imenik.class);
        Mockito.when(i.dajBroj("Amila")).thenReturn("Nije oke");

        String s = i.dajBroj("Amila");
        assertEquals(s,"Nije oke");
    }

    @Test
    public void testMocking(){
        Map<String, TelefonskiBroj> m = Mockito.mock(Map.class);
        Mockito.when(m.get("Amila")).thenReturn(new FiksniBroj(Grad.BANOVICI,"123-456"));
        imenik.setBrojevi(m);

        String s = imenik.dajBroj("Amila");
        assertNotEquals(s,"033/123-456");
        assertEquals(s,"035/123-456");
    }
}