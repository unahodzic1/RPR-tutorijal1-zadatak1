package ba.unsa.etf.rpr.lv5;
import java.util.List;

public class Predmet implements MozeOcijeniti{
    private String naziv;
    private String opis;
    private List<Ocjena> ocjene;

    public Predmet(String naziv, String opis, List<Ocjena> ocjene) {
        this.naziv = naziv;
        this.opis = opis;
        this.ocjene = ocjene;
    }

    public void setNaziv(String naziv){
        this.naziv = naziv;
    }

    public void setOpis(String opis){
        this.opis = opis;
    }

    public String getNaziv(){
        return this.naziv;
    }

    public String getOpis(){
        return this.opis;
    }

    public Ocjena ocijeni(LicneInformacije ocjenjuje, int ocjena) {
        // svi mogu ocijeniti predmet
        Ocjena novaOcjena = new Ocjena(ocjenjuje, ocjena);
        ocjene.add(novaOcjena);

        return novaOcjena;
    }

}
