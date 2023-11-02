package ba.unsa.etf.rpr.lab3;

public class VlastitiTipIzuzetka extends Exception{

    public VlastitiTipIzuzetka() {
    }

    public VlastitiTipIzuzetka(String poruka) {
        super(poruka);
    }

    public VlastitiTipIzuzetka(String poruka, Throwable uzrok) {
        super(poruka, uzrok);
    }

    public VlastitiTipIzuzetka(Throwable uzrok) {
        super(uzrok);
    }

}
