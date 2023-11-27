package ba.unsa.etf.rpr.lv5;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
//
//        List<Ocjena> ocjenePredmet = new ArrayList<>();
//        InformacijeOStudentu student = new InformacijeOStudentu("Una", "Hodzic", "2", "19044");
//        InformacijeONastavniku nastavnik = new InformacijeONastavniku("Hana", "Hodzic", "Profesorica");
//        Predmet predmet = new Predmet("Razvoj programskih rjesenja", "Najbolji predmet na svijetu", ocjenePredmet);
//        Object o = new Object();
//
//        if(o instanceof InformacijeONastavniku){
//            predmet.ocijeni(10);
//        }
//        else if(o instanceof InformacijeOStudentu){
//            predmet.ocijeni(10);
//            nastavnik.ocijeni(10);
//        }

        // unos informacija

        Scanner unos = new Scanner(System.in);
        System.out.println("Unesite ime: ");
        String ime = unos.nextLine();
        System.out.println("Unesite prezime: ");
        String prezime = unos.nextLine();
        System.out.println("Unesite 1 ako ste nastavnik ili 2 ako ste student: ");
        Scanner unos1 = new Scanner(System.in);Un
        int izbor = unos1.nextInt();

        LicneInformacije osobaKojaOcjenjuje= new LicneInformacije(ime, prezime);

        switch(izbor){
            case 1:
                System.out.println("Unesite titulu: ");
                String titula = unos.nextLine();
                InformacijeONastavniku nastavnik = new InformacijeONastavniku(ime, prezime, titula);
                break;
            case 2:
                System.out.println("Unesite godinu studija: ");
                String godinaStudija = unos.nextLine();
                System.out.println("Unesite broj indexa: ");
                String brojIndexa = unos.nextLine();
                InformacijeOStudentu student = new InformacijeOStudentu(ime, prezime, godinaStudija, brojIndexa);

                // samo student moze ocijeniti nastavnika
                System.out.println("Unesite ime nastavnika: ");
                String imeNastavnika = unos.nextLine();
                System.out.println("Unesite prezime nastavnika: ");
                String prezimeNastavnika = unos.nextLine();
                System.out.println("Unesite titulu nastavnika: ");
                String titulaNastavnika = unos.nextLine();
                InformacijeONastavniku nastavnikKojegOcjenjujem = new InformacijeONastavniku(imeNastavnika, prezimeNastavnika, titulaNastavnika);
                System.out.println("Unesite ocjenu za nastavnika: ");
                Scanner unos2 = new Scanner(System.in);
                int ocjenaNastavnikaBroj = unos2.nextInt();
                List<Ocjena> ocjeneNastavnika = new ArrayList<>();
                Ocjena ocjenaNastavnika = new Ocjena(osobaKojaOcjenjuje, ocjenaNastavnikaBroj);
                nastavnikKojegOcjenjujem.ocijeni(ocjenaNastavnikaBroj);
        }

        // svi mogu ocijeniti predmet

        System.out.println("Unesite naziv predmeta koji zelite ocijeniti: ");
        String predmetNaziv = unos.nextLine();
        System.out.println("Unesite ocjenu predmeta: ");
        int ocjena = unos.nextInt();
        List<Ocjena> ocjenePredmeta = new ArrayList<>();
        Ocjena ocjenaPredmeta = new Ocjena(osobaKojaOcjenjuje, ocjena);
        Predmet predmet = new Predmet(predmetNaziv, "Opis", ocjenePredmeta);

        predmet.ocijeni(ocjena);
        
    }
}
