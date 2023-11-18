package ba.unsa.etf.rpr.lv5;
import java.util.List;

public class KolekcijaImena {
    private List<String> imenaPrezimena;

    public KolekcijaImena(List<String> imenaPrezimena) {
        this.imenaPrezimena = imenaPrezimena;
    }

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
