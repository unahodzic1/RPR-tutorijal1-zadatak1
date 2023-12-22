public class Drzava {

    private int drzavaID;
    private String naziv;
    private int gradID;

    public Drzava(int drzavaID, String naziv, int gradID) {
        this.drzavaID = drzavaID;
        this.naziv = naziv;
        this.gradID = gradID;
    }

    public void setDrzavaID(int drzavaID) {
        this.drzavaID = drzavaID;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setGradID(int gradID) {
        this.gradID = gradID;
    }

    public int getDrzavaID() {
        return drzavaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getGradID() {
        return gradID;
    }

    @Override
    public String toString() {
        return naziv;
    }
}
