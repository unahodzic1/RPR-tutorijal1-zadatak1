package ba.unsa.etf.rpr.lv5;

public class InformacijeOStudentu extends LicneInformacije implements IPredstavi, MozeOcijeniti{
    private String godinaStudija;
    private String brojIndexa;

    public InformacijeOStudentu(String ime, String prezime, String godinaStudija, String brojIndexa){
        super(ime, prezime);
        this.godinaStudija = godinaStudija;
        this.brojIndexa = brojIndexa;
    }

    public void setGodinaStudija(String godinaStudija){
        this.godinaStudija = godinaStudija;
    }

    public void setBrojIndexa(String brojIndexa){
        this.brojIndexa = brojIndexa;
    }

    public String getGodinaStudija(){
        return this.godinaStudija;
    }

    public String getBrojIndexa(){
        return this.brojIndexa;
    }

    // implementira interfejs IPredstavi

    public String predstavi(){
        return "Ime studenta: " + getIme() + " Prezime studenta: " + getPrezime() + " Broj indexa: " + getBrojIndexa();
    }

    // implementira interfejs MozeOcijeniti

    public Ocjena ocijeni(int x){
        LicneInformacije osobaKojaOcjenjuje = new InformacijeOStudentu(getIme(), getPrezime(), getGodinaStudija(), getBrojIndexa());
        Ocjena ocjena = new Ocjena(osobaKojaOcjenjuje, x);

        return ocjena;
    }

    // nkntm kako zna sta ocjenjuje

}
