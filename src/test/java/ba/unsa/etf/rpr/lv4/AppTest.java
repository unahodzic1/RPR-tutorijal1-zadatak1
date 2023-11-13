package ba.unsa.etf.rpr.lv4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LaptopDaoTest {

    @Test
    void getLaptopTest() throws NeodgovarajuciProcesorException {
        LaptopDao dao = mock(LaptopDao.class);
        Laptop laptop1 = new Laptop();
        laptop1.setProcesor("Intel i3");

        when(dao.getLaptop("Intel i3")).thenReturn(laptop1);

        Laptop laptop2 = dao.getLaptop("Intel i3");

        assertSame(laptop1, laptop2);
    }

    @Test
    void dodajLaptopeTest() throws IOException {
        Laptop l1 = new Laptop("Asus", "...", 0, 0, 0, 0, "...", "...", 0);
        Laptop l2 = new Laptop("HP", "...", 0, 0, 0, 0, "...", "...", 0);
        Laptop l3 = new Laptop("Lenovo", "...", 0, 0, 0, 0, "...", "...", 0);

        LaptopDaoJSONFile ldao = Mockito.mock(LaptopDaoJSONFile.class);

        ArrayList<Laptop> laptops = new ArrayList<>();
        laptops.add(l1);
        laptops.add(l2);
        laptops.add(l3);
        Mockito.when(ldao.vratiPodatkeIzDatoteke()).thenReturn(laptops);

        Assertions.assertEquals("Asus", ldao.vratiPodatkeIzDatoteke().get(0).getBrend());
        Assertions.assertEquals("HP", ldao.vratiPodatkeIzDatoteke().get(1).getBrend());
        Assertions.assertEquals("Lenovo", ldao.vratiPodatkeIzDatoteke().get(2).getBrend());
    }

}
