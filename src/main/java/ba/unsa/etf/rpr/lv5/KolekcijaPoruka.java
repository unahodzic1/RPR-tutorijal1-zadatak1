package ba.unsa.etf.rpr.lv5;
import java.util.ArrayList;
import java.util.List;

public class KolekcijaPoruka {
    private List<String> poruke;

    // BITNO!
    public KolekcijaPoruka(List<IPredstavi> objekti) {
        this.poruke = new ArrayList<>();
        for (IPredstavi x : objekti) {
            this.poruke.add(x.predstavi());
        }
    }

    public List<String> getPoruke(){
        return this.poruke;
    }

    // set metoda nije omogucena - necemo je implementirati

}
