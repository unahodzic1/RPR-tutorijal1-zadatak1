package ba.unsa.etf.rpr.lv4;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LaptopDaoJSONFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoJSONFile() {
    }

    public LaptopDaoJSONFile(File file) {
        this.file = file;
        this.laptopi = new ArrayList<>();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(file, laptop);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException {
        for (Laptop laptop : laptopi) {
            if (laptop.getProcesor().equals(procesor)) {
                return laptop;
            }
        }
        throw new NeodgovarajuciProcesorException("Nema laptopa sa traženim procesorom: " + procesor);
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi.addAll(laptopi);
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Laptop[] laptopArray = mapper.readValue(file, Laptop[].class);
            laptopi.clear();
            for (Laptop laptop : laptopArray) {
                laptopi.add(laptop);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return laptopi;
    }
}
