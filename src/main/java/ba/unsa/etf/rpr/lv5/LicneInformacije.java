package ba.unsa.etf.rpr.lv5;

public class LicneInformacije {
    private String ime;
    private String prezime;

    public LicneInformacije(String ime, String prezime){
        this.ime = ime;
        this.prezime = prezime;
    }

    public void setIme(String ime){
        this.ime = ime;
    }

    public void setPrezime(String prezime){
        this.prezime = prezime;
    }

    public String getIme(){
        return this.ime;
    }

    public String getPrezime(){
        return this.prezime;
    }

}
