package ba.unsa.etf.rpr.lab3;

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

    private String pozivni;

    Grad(String broj) {
        this.pozivni = broj;
    }

    public String getPozivni() {
        return pozivni;
    }

    public static Grad pomocnaFunkcija(String phoneNumber){
        for(Grad g: Grad.values()){
            if (g.getPozivni().equals(phoneNumber)){
                return g;
            }
        }

        return null;

    }

}
