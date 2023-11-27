package ba.unsa.etf.rpr.lv5;
import java.util.List;

public class Pobjednik {
    private String ime;
    private String prezime;
    private int brojZnakova;
    
    private List<String> kolekcijaImena;

    public Pobjednik(KolekcijaImena kolekcija){
        String razdvojeno = kolekcija.getNajduzeIme();
        String[] imePrezime = razdvojeno.split(" ");
        this.ime = imePrezime[0];
        this.prezime = imePrezime[1];
        this.brojZnakova = imePrezime.length;
    }

    public String getIme(){
        return this.ime;
    }

    public String getPrezime(){
        return this.prezime;
    }

}
