package ba.unsa.etf.rpr.lv5;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<String> imena = new ArrayList<>();
        imena.add("Una Hodzic");
        imena.add("Amina Cajic");
        imena.add("Amila Kukic");
        imena.add("Sara Kardas");
        imena.add("Lana Malinov");
        KolekcijaImena kolImena = new KolekcijaImena(imena);

        System.out.println("Najduze ime: " + kolImena.getNajduzeIme());

        Pobjednik pobjednik = new Pobjednik(kolImena);
        System.out.println("Ime: " + pobjednik.getIme());
        System.out.println("Prezime: " + pobjednik.getPrezime());
    }
}
