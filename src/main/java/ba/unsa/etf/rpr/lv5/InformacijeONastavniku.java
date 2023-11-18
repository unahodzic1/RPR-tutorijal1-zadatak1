package ba.unsa.etf.rpr.lv5;

public class InformacijeONastavniku extends LicneInformacije implements Predstavi{
    private String titula;

    public InformacijeONastavniku(String ime, String prezime, String titula){
        super(ime, prezime);
        this.titula = titula;
    }

    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }

    public String predstavi(){
        return super.predstavi() + " Titula: " + getTitula();
    }

}
