package ba.unsa.etf.rpr.lv4;
import java.io.File;
import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {

        Laptop laptop1 = new Laptop("Asus", "...", 3000, 0, 0, 0, "...", "...", 12);
        Laptop laptop2 = new Laptop("Dell", "...", 1000, 0, 0, 0, "...", "...", 16);

        // JSON

        File file1 = new File("laptopi.json");
        LaptopDaoJSONFile laptopDao1 = new LaptopDaoJSONFile(file1);

        laptopDao1.dodajLaptopUListu(laptop1);
        laptopDao1.dodajLaptopUListu(laptop2);

        laptopDao1.dodajLaptopUFile(laptop1);
        laptopDao1.dodajLaptopUFile(laptop2);

        ArrayList<Laptop> listaIzDatoteke1 = laptopDao1.vratiPodatkeIzDatoteke();
        System.out.println("Podaci iz datoteke:");
        for (Laptop laptop : listaIzDatoteke1) {
            System.out.println(laptop);
        }

        try {
            Laptop trazeniLaptop1 = laptopDao1.getLaptop("Procesor1");
            System.out.println("Pronađeni laptop: " + trazeniLaptop1);
        } catch (NeodgovarajuciProcesorException e) {
            System.out.println(e.getMessage());
        }

        // XML

        File file2 = new File("laptopi.xml");
        LaptopDaoXMLFile laptopDao2 = new LaptopDaoXMLFile(file2);

        laptopDao2.dodajLaptopUListu(laptop1);
        laptopDao2.dodajLaptopUListu(laptop2);

        laptopDao2.dodajLaptopUFile(laptop1);
        laptopDao2.dodajLaptopUFile(laptop2);

        ArrayList<Laptop> listaIzDatoteke2 = laptopDao2.vratiPodatkeIzDatoteke();
        System.out.println("Podaci iz datoteke:");
        for (Laptop laptop : listaIzDatoteke2) {
            System.out.println(laptop);
        }

        try {
            Laptop trazeniLaptop2 = laptopDao2.getLaptop("Procesor1");
            System.out.println("Pronađeni laptop: " + trazeniLaptop2);
        } catch (NeodgovarajuciProcesorException e) {
            System.out.println(e.getMessage());
        }
    }
    }
