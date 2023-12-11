package ba.unsa.etf.rpr.lv78;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.io.Serializable;

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
