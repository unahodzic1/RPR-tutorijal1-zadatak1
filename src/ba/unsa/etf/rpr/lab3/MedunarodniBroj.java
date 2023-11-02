package ba.unsa.etf.rpr.lab3;
import java.util.Objects;

public class MedunarodniBroj extends TelefonskiBroj{

    private String drzava; // pozivni za drzavu
    private String broj;

    public MedunarodniBroj(String drzava, String broj) {
        this.drzava = drzava;
        this.broj = broj;
    }

    public String getDrzava() {
        return drzava;
    }

    public String getBroj() {
        return broj;
    }

    @Override
    public String ispisi() {
        if(drzava != null && broj != null) return drzava + " " + broj.substring(0,3) + "-" + broj.substring(3);
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MedunarodniBroj)) return false;
        MedunarodniBroj that = (MedunarodniBroj) o;
        return Objects.equals(getDrzava(), that.getDrzava()) && Objects.equals(getBroj(), that.getBroj());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDrzava(), getBroj());
    }

}
