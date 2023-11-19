package ba.unsa.etf.rpr.lv5;
import java.util.List;

public class Predmet {
    private String naziv;
    private String opis;
    private List<Ocjena> ocjene;

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

}
