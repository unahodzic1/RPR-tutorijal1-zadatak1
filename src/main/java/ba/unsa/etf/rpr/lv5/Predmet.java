package ba.unsa.etf.rpr.lv5;

public class Predmet implements Predstavi{
    private String naziv;
    private String opis;

    public Predmet(String naziv, String opis){
        this.naziv = naziv;
        this.opis = opis;
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

    public String predstavi(){
        return "Naziv predmeta: " + getNaziv() + " Opis predmeta: " + getOpis();
    }
}
