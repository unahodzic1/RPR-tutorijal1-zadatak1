package ba.unsa.etf.rpr.lv5;
import java.util.List;

public class InformacijeONastavniku extends LicneInformacije implements IPredstavi, MozeOcijeniti{
    private String titula;
    private List<Ocjena> ocjene;

    public InformacijeONastavniku(String ime, String prezime, String titula){
        super(ime, prezime);
        this.titula = titula;
    }

    public void setTitula(String titula){
        this.titula = titula;
    }

    public String getTitula(){
        return this.titula;
    }

    // implementira interfejs IPredstavi

    public String predstavi(){
        return "Ime nastavnika: " + getIme() + " Prezime nastavnika: " + getPrezime() + " Titula nastavnika: " + getTitula();
    }

    // implementira interfejs MozeOcijeniti

    public Ocjena ocijeni(int x){
        LicneInformacije osobaKojaOcjenjuje = new InformacijeONastavniku(getIme(), getPrezime(), getTitula());
        Ocjena ocjena = new Ocjena(osobaKojaOcjenjuje, x);

        return ocjena;
    }

}
