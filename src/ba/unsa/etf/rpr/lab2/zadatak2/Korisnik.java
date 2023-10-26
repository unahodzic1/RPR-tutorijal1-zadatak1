package ba.unsa.etf.rpr.lab2.zadatak2;

import java.util.Objects;

public class Korisnik extends Osoba{

    protected Racun racun;

    public Korisnik(String ime, String prezime) {
        super(ime, prezime);
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public void dodajRacun(Racun racun){
        this.racun = racun;
    }

}
