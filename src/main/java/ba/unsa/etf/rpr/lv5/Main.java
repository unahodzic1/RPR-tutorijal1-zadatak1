package ba.unsa.etf.rpr.lv5;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        LicneInformacije covjek = new LicneInformacije("Nadina","Miralem");
        InformacijeOStudentu student = new InformacijeOStudentu("Una", "Hodzic", "2", "19044");
        InformacijeONastavniku nastavnik = new InformacijeONastavniku("Amina","Cajic", "kraljica");
        Predmet predmet = new Predmet("Razvoj programskih rjesenja","Najbolji predmet ikada!",null);
        List<Predstavi> interfejs = new ArrayList<>();
        interfejs.add(predmet);
        interfejs.add(covjek);
        interfejs.add(student);
        interfejs.add(nastavnik);

        KolekcijaPoruka poruke = new KolekcijaPoruka(interfejs);

        List<String> dajPoruke = poruke.getPoruke();
        for(String x : dajPoruke){
            System.out.println(x);
        }

//        System.out.println(covjek.predstavi());
//        System.out.println(student.predstavi());
//        System.out.println(nastavnik.predstavi());
//        System.out.println(predmet.predstavi());
    }
}
