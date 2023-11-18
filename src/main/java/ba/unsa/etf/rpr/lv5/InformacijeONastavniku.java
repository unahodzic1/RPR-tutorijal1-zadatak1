package ba.unsa.etf.rpr.lv5;
import java.util.List;

public class InformacijeONastavniku extends LicneInformacije implements Predstavi, MozeOcijeniti{
    private String titula;
    private List<Ocjena> ocjene;

    public InformacijeONastavniku(String ime, String prezime, String titula){
        super(ime, prezime);
        this.titula = titula;
    }

    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }

    public Ocjena ocijeni(int x) {
        Ocjena novaOcjena = new Ocjena(null, x);
        ocjene.add(novaOcjena);
        return novaOcjena;
    }

    public String predstavi(){
        return super.predstavi() + " Titula: " + getTitula();
    }

}
