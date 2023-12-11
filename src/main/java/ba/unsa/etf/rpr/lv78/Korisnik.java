package ba.unsa.etf.rpr.lv78;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.io.Serializable;
import java.util.Objects;

public class Korisnik implements Serializable{
    private  SimpleStringProperty ime;
    private  SimpleStringProperty prezime;
    private  SimpleStringProperty email;
    private  SimpleStringProperty korisnickoIme;
    private  SimpleStringProperty password;

    // konstruktori

    public Korisnik(SimpleStringProperty ime, SimpleStringProperty prezime, SimpleStringProperty email, SimpleStringProperty korisnickoIme, SimpleStringProperty password) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.korisnickoIme = korisnickoIme;
        this.password = password;
    }

    public Korisnik(String ime, String prezime, String email, String korisnickoIme, String password) {
        this.ime = new SimpleStringProperty(ime);
        this.prezime = new SimpleStringProperty(prezime);
        this.email = new SimpleStringProperty(email);
        this.korisnickoIme = new SimpleStringProperty(korisnickoIme);
        this.password = new SimpleStringProperty(password);
    }

    public Korisnik(){
        this.ime = new SimpleStringProperty("");
        this.prezime = new SimpleStringProperty("");
        this.email = new SimpleStringProperty("");
        this.korisnickoIme = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");
    }

    // toString metoda

    @Override
    public String toString(){
        return ime.get() + " " + prezime.get();
    }

    // dodana equals metoda zbog testova

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Korisnik korisnik = (Korisnik) obj;

        return Objects.equals(ime.get(), korisnik.ime.get()) && Objects.equals(prezime.get(), korisnik.prezime.get()) && Objects.equals(email.get(), korisnik.email.get()) && Objects.equals(korisnickoIme.get(), korisnik.korisnickoIme.get()) && Objects.equals(password.get(), korisnik.password.get());
    }

    @Override
    public int hashCode() {
        return Objects.hash(ime.get(), prezime.get(), email.get(), korisnickoIme.get(), password.get());
    }

    // za svaki property imamo 3 metode

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

    public String getIme() {
        return ime.get();
    }

    public SimpleStringProperty imeProperty() {
        return ime;
    }

    public String getPrezime() {
        return prezime.get();
    }

    public SimpleStringProperty prezimeProperty() {
        return prezime;
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public String getKorisnickoIme() {
        return korisnickoIme.get();
    }

    public SimpleStringProperty korisnickoImeProperty() {
        return korisnickoIme;
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

}
