package ba.unsa.etf.rpr.lv5;

public class LicneInformacije implements Predstavi {
    private String ime;
    private String prezime;

    public LicneInformacije(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String predstavi(){
        return "Ime: " + getIme() + " Prezime: " + getPrezime();
    }

}
