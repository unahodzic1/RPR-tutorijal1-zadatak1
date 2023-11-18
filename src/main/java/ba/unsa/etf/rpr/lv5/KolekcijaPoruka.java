package ba.unsa.etf.rpr.lv5;
import java.util.ArrayList;
import java.util.List;

public class KolekcijaPoruka {
    private List<String> poruke;

    public KolekcijaPoruka(List<Predstavi> objekti) {
        this.poruke = new ArrayList<>();
        for (Predstavi x : objekti) {
            this.poruke.add(x.predstavi());
        }
    }

    public List<String> getPoruke(){
        return this.poruke;
    }

    // set metoda nije omogucena - necemo je implementirati

}
