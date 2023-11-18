package ba.unsa.etf.rpr.lv5;

public class InformacijeOStudentu extends LicneInformacije implements Predstavi {
    private String godinaStudija;
    private String brojIndexa;

    public InformacijeOStudentu(String ime, String prezime, String godinaStudija, String brojIndexa){
        super(ime, prezime);
        this.godinaStudija = godinaStudija;
        this.brojIndexa = brojIndexa;
    }

    public String getGodinaStudija() {
        return godinaStudija;
    }

    public String getBrojIndexa() {
        return brojIndexa;
    }


    public void setGodinaStudija(String godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    public void setBrojIndexa(String brojIndexa) {
        this.brojIndexa = brojIndexa;
    }

    public String predstavi(){
        return super.predstavi() + " Broj indeksa: " + getBrojIndexa() + " Godina studija: " + getGodinaStudija();
    }

}
