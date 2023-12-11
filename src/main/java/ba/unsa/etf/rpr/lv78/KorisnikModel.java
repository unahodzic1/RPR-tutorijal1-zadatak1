package ba.unsa.etf.rpr.lv78;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisnikModel {

    // atributi
    private ObservableList<Korisnik> korisnici = FXCollections.observableArrayList();
    private ObjectProperty<Korisnik> trenutniKorisnik = new SimpleObjectProperty<>();

    public KorisnikModel(){
        trenutniKorisnik.set(new Korisnik());
    }

    // getteri i setteri


    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik.set(trenutniKorisnik);
    }

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public ObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }

    public void napuni(){
        korisnici.add(new Korisnik("Una", "Hodzic", "uhodzic1@etf.unsa.ba", "uhodzic1", "123"));
        korisnici.add(new Korisnik("Amina", "Cajic", "acajic1@etf.unsa.ba", "acajic1", "234"));
        korisnici.add(new Korisnik("Amila", "Kukic", "akukic1@etf.unsa.ba", "akukic1", "567"));
        korisnici.add(new Korisnik("Sara", "Kardas", "skardas1@etf.unsa.ba", "skardas1", "765"));
        korisnici.add(new Korisnik("Lana", "Malinov", "lmalinov1@etf.unsa.ba", "lmalinov1", "897"));
    }

    public void dodajKorisnika(Korisnik korisnik){
        korisnici.add(new Korisnik(korisnik.getIme(), korisnik.getPrezime(), korisnik.getEmail(), korisnik.getKorisnickoIme(), korisnik.getPassword()));
    }

}
