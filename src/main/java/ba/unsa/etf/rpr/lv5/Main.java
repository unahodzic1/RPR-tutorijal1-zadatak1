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

        List<String> kolekcijaImena = List.of("Una", "Amina", "Amila", "Sara", "Lana");
        List<String> kolekcijaPrezimena = List.of("Hodzic", "Cajic", "Kukic", "Kardas", "Malinov");

        KolekcijaImenaIPrezimena kolekcija = new KolekcijaImenaIPrezimena(kolekcijaImena, kolekcijaPrezimena);
        System.out.println("Index najduzeg para: " + kolekcija.getIndexNajduzegPara());
        System.out.println("Ime i prezime na pozicijii 0: " + kolekcija.getImeiPrezime(0));

        List<String> imena2 = new ArrayList<>();
        imena2.add("Nadza");
        imena2.add("Anida");
        imena2.add("Naida");
        imena2.add("Nadina");
        imena2.add("Nerma");
        imena2.add("Eman");

        List<String> prezimena2 = new ArrayList<>();
        prezimena2.add("Poljo");
        prezimena2.add("Duharkic");
        prezimena2.add("Pandur");
        prezimena2.add("Miralem");
        prezimena2.add("Kadric");
        prezimena2.add("Boloban");

        IKolekcijaImena kolekcija2 = new KolekcijaImenaIPrezimena(imena2, prezimena2);

        Pobjednik pobjednik2 = new Pobjednik(kolekcija2);
        System.out.println("Ime: " + pobjednik2.getIme());
        System.out.println("Prezime: " + pobjednik2.getPrezime());

    }
}
