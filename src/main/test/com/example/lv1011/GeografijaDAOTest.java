package com.example.lv1011;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.beans.Statement;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GeografijaDAOTest {

    private static GeografijaDAO dao;

    @BeforeAll
    public static void konekcija(){
        dao = GeografijaDAO.getInstance();
    }

    // testovi koji mijenjaju stanje baze

    @Test
    public void testDodajGrad() {
        Grad grad = new Grad(5, "Zenica", 150, 1);
        dao.dodajGrad(grad);
        assertNotNull(dao.nadjiGrad("Zenica"));
    }

    @Test
    public void testObrisiGrad() {
        dao.obrisiGrad("Zenica");
        assertNull(dao.nadjiGrad("Zenica"));
    }

    @Test
    public void testDodajDrzavu() {
        Drzava drzava = new Drzava(4, "Somalija", 1);
        dao.dodajDrzavu(drzava);
        assertNotNull(dao.nadjiDrzavu("Somalija"));
    }

    @Test
    public void testObrisiDrzavu() {
        dao.obrisiDrzavu("Somalija");
        assertNull(dao.nadjiDrzavu("Somalija"));
    }

    // testovi koji ne mijenjaju stanje baze

    @BeforeAll
    public static void resetuj() {
        GeografijaDAO.getInstance().obrisiSveUnose();
    }

    @Test
    public void testDodajObrisiDrzavu(){
        Drzava drzava = new Drzava(4, "Srbija", 2);
        dao.dodajDrzavu(drzava);
        assertEquals("Srbija", dao.nadjiDrzavu("Srbija").getNaziv());
    }

    @Test
    public void testProvjeri(){
        assertNull(dao.nadjiDrzavu("Srbija"));
    }

}