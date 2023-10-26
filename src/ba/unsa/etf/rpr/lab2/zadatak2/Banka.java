package ba.unsa.etf.rpr.lab2.zadatak2;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class Banka {

    private Long brojRacuna;
    protected List<Korisnik> korisnici;
    protected List<Uposlenik> uposlenici;

    public Banka() {
        this.korisnici = new ArrayList<Korisnik>();
        this.uposlenici = new ArrayList<Uposlenik>();
    }

    public Korisnik kreirajNovogKorisnika(String ime, String prezime){
        Korisnik noviKorisnik = new Korisnik(ime, prezime);
        this.korisnici.add(noviKorisnik);

        return noviKorisnik;
    }

    public Uposlenik kreirajNovogUposlenika(String ime, String prezime){
        Uposlenik noviUposlenik = new Uposlenik(ime, prezime);
        this.uposlenici.add(noviUposlenik);

        return noviUposlenik;
    }

    public static String generatorBrojaRacuna(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public Racun kreirajRacunZaKorisnika(Korisnik korisnik){
        Racun kreiraniRacun = null;
        String brojRacuna1 = generatorBrojaRacuna();
        Long brojRacuna2 = Long.parseLong(brojRacuna1);

        for(int i = 0; i < this.korisnici.size(); i++) kreiraniRacun = new Racun(brojRacuna2, this.korisnici.get(i));

        return kreiraniRacun;
    }

}
