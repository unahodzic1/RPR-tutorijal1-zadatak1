package ba.unsa.etf.rpr.lab2.zadatak2;

public class Racun {

    private Double prekoracenje; // potrebno zbog metode odobriPrekoracenje
    protected Long brojRacuna;
    protected Osoba korisnikRacuna;
    protected boolean odobrenjePrekoracenja;
    protected Double stanjeRacuna;

    public Racun(Long brojRacuna, Osoba korisnikRacuna) {
        this.brojRacuna = brojRacuna;
        this.korisnikRacuna = korisnikRacuna;
    }

    /*
    public boolean provjeriOdobrenjePrekoracenja(Double prekoracenje){

    }
    */

    public boolean izvrsiUplatu(Double iznos){
        if(this.stanjeRacuna < iznos) return false;
        else {
            this.stanjeRacuna = this.stanjeRacuna - iznos;
            return true;
        }
    }

    public boolean izvrsiIsplatu(Double iznos){
        this.stanjeRacuna = this.stanjeRacuna + iznos;
        return true;
    }

    public void odobriPrekoracenje(Double prekoracenje){
        this.prekoracenje = prekoracenje;
    }

}
