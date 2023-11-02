package ba.unsa.etf.rpr.lab3;

public enum Grad {

    TRAVNIK("030"),
    ODZAK("031"),
    MAGLAJ("032"),
    SARAJEVO("033"),
    LIVNO("034"),
    TUZLA("035"),
    MOSTAR("036"),
    BIHAC("037"),
    GORAZDE("038");

    private String pozivni;

    Grad(String broj) {
        this.pozivni = broj;
    }

    public String getPozivni() {
        return pozivni;
    }

}
