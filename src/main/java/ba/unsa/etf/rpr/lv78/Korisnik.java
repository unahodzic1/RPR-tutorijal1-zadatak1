package ba.unsa.etf.rpr.lv78;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.io.Serializable;

public class Korisnik implements Serializable {
    private final StringProperty ime;
    private final StringProperty prezime;
    private final StringProperty email;
    private final StringProperty korisnickoIme;
    private final StringProperty password;

    public Korisnik(StringProperty ime, StringProperty prezime, StringProperty email, StringProperty korisnickoIme, StringProperty password) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.korisnickoIme = korisnickoIme;
        this.password = password;
    }

    public Korisnik(){
        this.ime = new SimpleStringProperty("");
        this.prezime = new SimpleStringProperty("");
        this.email = new SimpleStringProperty("");
        this.korisnickoIme = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");
    }

    public String getIme() {
        return ime.get();
    }

    public StringProperty imeProperty() {
        return ime;
    }

    public String getPrezime() {
        return prezime.get();
    }

    public StringProperty prezimeProperty() {
        return prezime;
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getKorisnickoIme() {
        return korisnickoIme.get();
    }

    public StringProperty korisnickoImeProperty() {
        return korisnickoIme;
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme.set(korisnickoIme);
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
}
