package ba.unsa.etf.rpr.lv4;
import java.io.File;
import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {

        File file = new File("laptopi.json");
        LaptopDaoJSONFile laptopDao = new LaptopDaoJSONFile(file);
        
        Laptop laptop1 = new Laptop("Asus", "...", 0, 0, 0, 0, "...", "...", 0);
        Laptop laptop2 = new Laptop("Dell", "...", 1000, 0, 0, 0, "...", "...", 0);

        laptopDao.dodajLaptopUListu(laptop1);
        laptopDao.dodajLaptopUListu(laptop2);

        laptopDao.dodajLaptopUFile(laptop1);
        laptopDao.dodajLaptopUFile(laptop2);

        ArrayList<Laptop> listaIzDatoteke = laptopDao.vratiPodatkeIzDatoteke();
        System.out.println("Podaci iz datoteke:");
        for (Laptop laptop : listaIzDatoteke) {
            System.out.println(laptop);
        }

        // Pretraživanje laptopa po procesoru
        try {
            Laptop trazeniLaptop = laptopDao.getLaptop("Procesor1");
            System.out.println("Pronađeni laptop: " + trazeniLaptop);
        } catch (NeodgovarajuciProcesorException e) {
            System.out.println(e.getMessage());
        }
    }
}
