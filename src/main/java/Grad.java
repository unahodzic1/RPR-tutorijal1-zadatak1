public class Grad {

    private int gradID;
    private String naziv;
    private int brojStanovnika;

    private int drzavaID;

    public Grad(int gradID, String naziv, int brojStanovnika, int drzavaID) {
        this.gradID = gradID;
        this.naziv = naziv;
        this.brojStanovnika = brojStanovnika;
        this.drzavaID = drzavaID;
    }

    public Grad() {
    }

    public void setGradID(int gradID) {
        this.gradID = gradID;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    public void setDrzavaID(int drzavaID) {
        this.drzavaID = drzavaID;
    }

    public int getGradID() {
        return gradID;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public int getDrzavaID() {
        return drzavaID;
    }

    @Override
    public String toString() {
        return naziv;
    }

}
