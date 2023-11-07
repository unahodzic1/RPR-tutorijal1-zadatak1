package ba.unsa.etf.rpr;

import java.util.Objects;

public class MobilniBroj extends TelefonskiBroj{

    private int mobilnaMreza; // oznaka mobilne mreze predstavlja drugu i trecu cifru pozivnog broja
    private String broj;

    public MobilniBroj(int mobilnaMreza, String broj) {
        this.mobilnaMreza = mobilnaMreza;
        this.broj = broj;
    }

    public int getMobilnaMreza() {
        return mobilnaMreza;
    }

    public String getBroj() {
        return broj;
    }

    @Override
    public String ispisi() {
        if(broj != null) return "0" + mobilnaMreza + "/" + broj.substring(0,3) + "-" + broj.substring(3);
        else return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MobilniBroj)) return false;
        MobilniBroj that = (MobilniBroj) o;
        return getMobilnaMreza() == that.getMobilnaMreza() && Objects.equals(getBroj(), that.getBroj());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMobilnaMreza(), getBroj());
    }

}

