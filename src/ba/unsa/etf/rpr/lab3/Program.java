package ba.unsa.etf.rpr.lab3;
import java.util.Scanner;

// iskoristen vlastiti tip izuzetka

public class Program {

    public static void main(String[] args) throws Exception {

        Imenik imenik = new Imenik();

        System.out.println("Unesite zeljeni broj: " +
                "1 za dodaj, " +
                "2 za dajBroj, " +
                "3 za dajIme, " +
                "4 za naSlovo, " +
                "5 za izGrada, " +
                "6 za izGradaBrojevi" +
                "0 za kraj.");

        boolean ponovo;

        do {
            Scanner unos = new Scanner(System.in);
            int naredba = unos.nextInt();
            ponovo = false;

            if (naredba == 0) System.out.println("Zavrsili ste sa unosom.");
            else {
                switch (naredba) {
                    case 1:
                        // dodavanje osoba u imenik

                        System.out.println("Unesite zeljeno ime: ");
                        String ime1 = Program.unosStringa();
                        TelefonskiBroj broj1 = Program.unosBroja();
                        imenik.dodaj(ime1, broj1);

                        break;

                    case 2:
                        // ispis broja unesene osobe

                        System.out.println("Unesite zeljeno ime: ");
                        String ime2 = Program.unosStringa();
                        if(imenik.dajBroj(ime2) != null) System.out.println("Broj: " + imenik.dajBroj(ime2));
                        else System.out.println("U imeniku ne postoji osoba sa tim imenom!");
                        break;

                    case 3:
                        // ispis imena po broju

                        System.out.println("Unesite broj: ");
                        TelefonskiBroj broj3 = Program.unosBroja();
                        if(imenik.dajIme(broj3) != null) System.out.println("Ime: " + imenik.dajIme(broj3));
                        else System.out.println("U imeniku ne postoji osoba sa tim brojem!");
                        break;

                    case 4:
                        // naSlovo

                        System.out.println("Unesite slovo: ");
                        String unos4 = Program.unosStringa();
                        char slovo = unos4.charAt(0);
                        if(imenik.naSlovo(slovo) != null) imenik.naSlovo(slovo);
                        else System.out.println("U imeniku ne postoji osoba cije ime pocinje na to slovo!");
                        break;

                    case 5:
                        // izGrada
                        String grad = Program.unosStringa();

                        break;

                    case 6:
                        break;
                    default:
                        System.out.println("Unijeli ste nedozvoljeni broj! Unesite ponovo: ");
                        ponovo = true;
                }

            }
        }
        while(ponovo == true);

    }

    // pomocna funkcija za unos stringa

    public static String unosStringa() throws java.lang.Exception{

        Scanner unos = new Scanner(System.in);
        try {
            String uneseniString = unos.nextLine();
            if(uneseniString.contains("1")){
                throw new VlastitiTipIzuzetka();
            }
            else return uneseniString;
        }
        catch(VlastitiTipIzuzetka e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    // pomocna funkcija za unos broja telefona

    public static TelefonskiBroj unosBroja() throws Exception {
        System.out.println("Unesite broj za zeljeni tip: " +
                "1 za fiksni," +
                "2 za mobilni" +
                "3 za medjunarodni " +
                "0 za kraj.");

        boolean ponovo;

        do{
        Scanner unos = new Scanner(System.in);
        int tipBroja = unos.nextInt();
        ponovo = false;

        switch(tipBroja){
            case 0:
                // odustajanje od unosa
                System.out.println("Zavrsili ste s unosom.");
                return null;

            case 1:
                // fiksni broj
                System.out.println("Unesite pozivni broj: ");
                String pozivniBroj = Program.unosStringa();
                System.out.println("Unesite broj: ");
                String broj1 = Program.unosStringa();

                return new FiksniBroj(Grad.pomocnaFunkcija(pozivniBroj), broj1);
                // break;

            case 2:
                // mobilni broj

                System.out.println("Unesite oznaku mobilne mreze: ");
                Scanner unos2 = new Scanner(System.in);
                int oznakaMobilneMreze = unos2.nextInt();
                System.out.println("Unesite broj: ");
                String broj2 = Program.unosStringa();

                return new MobilniBroj(oznakaMobilneMreze, broj2);
                // break;

            case 3:
                // medjunarodni broj

                System.out.println("Unesite pozivni broj drzave: ");
                String pozivniBrojDrzave = Program.unosStringa();
                System.out.println("Unesite broj: ");
                String broj3 = Program.unosStringa();

                return new MedunarodniBroj(pozivniBrojDrzave, broj3);
                // break;

            default:
                System.out.println("Unijeli ste nedozvoljeni broj! Unesite ponovo: ");
                ponovo = true;

                }
        }
        while(ponovo == true);

        return null;
    }

}
