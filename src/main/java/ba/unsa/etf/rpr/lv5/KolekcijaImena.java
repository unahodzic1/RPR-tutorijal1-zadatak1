package ba.unsa.etf.rpr.lv5;
import java.util.List;

public class KolekcijaImena {
    // Lista stringova sadrzi imena i prezimena u formatu "Ime Prezime"
    private List<String> imenaPrezimena;

    public KolekcijaImena(List<String> imenaPrezimena) {
        this.imenaPrezimena = imenaPrezimena;
    }

    // vraca najduzi string "Ime Prezime" iz liste
    public String getNajduzeIme() {
        String najduzeIme = "";
        for (String ime : imenaPrezimena) {
            if (ime.length() > najduzeIme.length()) {
                najduzeIme = ime;
            }
        }
        return najduzeIme;
    }

}
