package com.example.lv1011;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.beans.Statement;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GeografijaDAOTest {

    private GeografijaDAO dao;

    // testovi koji mijenjaju stanje baze

    @Test
    public void testDodajGrad() {
        dao = GeografijaDAO.getInstance();

    }

    // DOVRSITI
    @Test
    public void testDodajDrzavu() {
        dao = GeografijaDAO.getInstance();
        Drzava drzava = new Drzava(4, "Somalija", 2);
        dao.dodajDrzavu(drzava);
        assertEquals(dao.nadjiDrzavu(drzava.getNaziv()).getNaziv(), "Somalija");
    }

}