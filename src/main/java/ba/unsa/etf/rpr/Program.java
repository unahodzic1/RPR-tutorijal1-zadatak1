package ba.unsa.etf.rpr;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Imenik imenik = new Imenik();

        imenik.dodaj("Una",new MobilniBroj(62,"111222"));
        imenik.dodaj("Hana",new MobilniBroj(62,"333444"));
        imenik.dodaj("Nadza",new FiksniBroj(Grad.SARAJEVO,"654567"));
        imenik.dodaj("Nadina",new MedunarodniBroj("+387","353555"));
        imenik.dodaj("Nerma",new FiksniBroj(Grad.BANOVICI,"324465"));
        imenik.dodaj("Amila",new FiksniBroj(Grad.BANOVICI,"777989"));
        imenik.dodaj("Amina",new FiksniBroj(Grad.KLJUC,"345644"));

        System.out.println("Odaberite zeljenu radnju: dodaj, dajBroj, dajIme, naSlovo" +
                ",izGrada, izGradaBrojevi, imenik, kraj");

        while(true){
            String s = scanner.nextLine();
            switch(s){
                case "dodaj":
                    System.out.println("Unesite ime");
                    String ime = scanner.nextLine();
                    TelefonskiBroj br = unosTelBr();
                    imenik.dodaj(ime,br);
                    break;
                case "dajBroj":
                    System.out.println("Unesite ime");
                    String i = scanner.nextLine();
                    String zeljenoIme = imenik.dajBroj(i);
                    System.out.println(zeljenoIme == null? "nema imena " : zeljenoIme);
                    break;
                case "dajIme":
                    System.out.println("Unesite broj");
                    TelefonskiBroj brTelefona = unosTelBr();
                    String imee = imenik.dajIme(brTelefona);
                    if (imee == null)System.out.println("Nije u imeniku!");
                    else System.out.println("Ime " + imee + " broj telefona "+ brTelefona.ispisi());
                    break;
                case "naSlovo":
                    System.out.println("Unesite slovo");
                    String unosSL = scanner.nextLine();
                    String rez = imenik.naSlovo(unosSL.toCharArray()[0]);
                    System.out.println(rez);
                    break;
                case "izGrada":
                    System.out.println("Unesite grad");
                    String unosG = scanner.nextLine();
                    try{
                        Grad g = Grad.valueOf(unosG);
                        Set<String> rezGR = imenik.izGrada(g);
                        System.out.println(rezGR);
                    } catch(Exception exc){
                        System.out.println("Neispravan unos!");
                    }
                    break;
                case "izGradaBrojevi":
                    System.out.println("Unesite grad");
                    String grad = scanner.nextLine();
                    try{
                        Grad g = Grad.valueOf(grad);
                        Set<TelefonskiBroj> t = imenik.izGradaBrojevi(g);
                        for(TelefonskiBroj tbr : t)
                            System.out.println(tbr.ispisi());
                    }catch(Exception exc){
                        System.out.println("Neispravan unos!");
                        return;
                    }
                    break;
                case "imenik":
                    System.out.println(imenik.toString());
                    break;
                case "kraj":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Neispravan unos, molimo ponovite!");

            }

        }
    }

    private static TelefonskiBroj unosTelBr() {
        System.out.println("Odaberite tip broja fiksni, mobilni, međunarodni, kraj");
        String s = scanner.nextLine();
        switch(s){
            case "fiksni":
                System.out.println("Unesite pozivni");
                String poz = scanner.nextLine();
                System.out.println("Unesite broj");
                String brT = scanner.nextLine();
                return new FiksniBroj(Grad.izPozivnog(poz),brT);
                // break;

            case "mobilni":
                System.out.println("Unesite mrezu");
                int mr = scanner.nextInt();
                System.out.println("Unesite broj");
                String brTl = scanner.nextLine();
                return new MobilniBroj(mr,brTl);
                // break;

            case "međunarodni":
                System.out.println("Unesite pozivni");
                String pz = scanner.nextLine();
                System.out.println("Unesite broj");
                String brTlf = scanner.nextLine();
                return new MedunarodniBroj(pz,brTlf);
                // break;

            case "kraj":
                return null;
        }
        return null;
    }
}