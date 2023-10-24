package ba.unsa.etf.rpr.lab2.zadatak2;

import java.util.Objects;

public class Korisnik extends Osoba{

    private Racun racun;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Korisnik)) return false;
        if (!super.equals(o)) return false;
        Korisnik korisnik = (Korisnik) o;
        return Objects.equals(getRacun(), korisnik.getRacun());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRacun());
    }
}
