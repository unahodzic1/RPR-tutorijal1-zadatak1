package ba.unsa.etf.rpr;

public enum Grad {

    TRAVNIK("030"),
    ODZAK("031"),
    MAGLAJ("032"),
    SARAJEVO("033"),
    LIVNO("034"),
    BANOVICI("035"),
    MOSTAR("036"),
    GORAZDE("038"),
    KLJUC("037");

    private String pozivniBroj;

    Grad(String pozivniBroj){this.pozivniBroj = pozivniBroj;}

    public static Grad izPozivnog(String pozivni){
        for(Grad g : Grad.values())
            if(g.getPozivniBroj().equals(pozivni)) return g;
        return null;
    }

    public String getPozivniBroj() {
        return pozivniBroj;
    }
}