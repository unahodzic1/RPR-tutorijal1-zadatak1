import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static GeografijaDAO geografijaDAO = GeografijaDAO.getInstance();

    public static void main(String[] args) {

        // Zadatak 4

        Scanner unos = new Scanner(System.in);
        System.out.println("Izaberite opciju: " +
                "1 - ispisiGradove, " +
                "2 - glavniGrad, " +
                "3 - izmijeniInfoGrad, " +
                "4 - obrisiDrzavu, " +
                "5 - nadjiDrzavu, " +
                "6 - nadjiGrad ili " +
                "0 - kraj ");

        while(true) {

            int izbor = unos.nextInt();

            switch (izbor) {
                case 0:
                    System.out.println("Kraj programa.");
                    break;
                case 1:
                    System.out.println(ispisiGradove());
                    System.out.println("Izaberite sljedecu opciju: ");
                    break;
                case 2:
                    glavniGrad();
                    System.out.println("Izaberite sljedecu opciju: ");
                    break;
                case 3:
                    izmijeniInfoGrad();
                    System.out.println("Izaberite sljedecu opciju: ");
                    break;
                case 4:
                    obrisiDrzavu();
                    System.out.println("Izaberite sljedecu opciju: ");
                    break;
                case 5:
                    nadjiDrzavu();
                    System.out.println("Izaberite sljedecu opciju: ");
                    break;
                case 6:
                    nadjiGrad();
                    System.out.println("Izaberite sljedecu opciju: ");
                    break;
                default:
                    System.out.println("Opcija pod tim brojem ne postoji!");
            }

            if(izbor == 0) break;
        }

        // zatvaranje konekcije

        try{
            GeografijaDAO.removeInstance();
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }

    public static String ispisiGradove(){
        String vratiString = "";

//        ArrayList<Grad> gradovi = geografijaDAO.gradovi();
//        for(Grad x : gradovi){
//            vratiString = vratiString + x;
//        }

        ArrayList<Grad> gradovi = geografijaDAO.gradovi();
        ArrayList<Drzava> drzave = geografijaDAO.drzave();
        for(int i = 0; i < gradovi.size(); i++){
            for(int j = 0; j < drzave.size(); j++){
                if(gradovi.get(i).getDrzavaID() == drzave.get(j).getDrzavaID())
                vratiString = vratiString + gradovi.get(i).getNaziv() + " (" + drzave.get(j).getNaziv() + ") - " + gradovi.get(i).getBrojStanovnika() + " ";
            }
        }

        return vratiString;
    }

    public static void glavniGrad(){
        System.out.println("Unesite naziv drzave: ");
        Scanner unos = new Scanner(System.in);
        String nazivDrzave = unos.nextLine();
        Grad glavniGr = geografijaDAO.glavniGrad(nazivDrzave);
        Drzava drzava = geografijaDAO.nadjiDrzavu(nazivDrzave);
        if(drzava == null) System.out.println("Nepostojeca drzava.");
        else System.out.println("Glavni grad drzave " + nazivDrzave + " je " + glavniGr + ".");
    }

    public static void izmijeniInfoGrad(){
        Scanner unos = new Scanner(System.in);
        Scanner unos2 = new Scanner(System.in);
        System.out.println("Unesite naziv grada cije podatke zelite izmijeniti: ");
        String nazivGrada = unos.nextLine();
        Grad grad = geografijaDAO.nadjiGrad(nazivGrada);
        int brojStanovnika = grad.getBrojStanovnika();
        int gradID = grad.getGradID();
        int drzavaID = grad.getDrzavaID();
        Grad gradIzmjena = new Grad(gradID, nazivGrada, brojStanovnika, drzavaID);
        System.out.println("Izaberite sta zelite izmijeniti: " +
                "1 - naziv grada, " +
                "2 - broj stanovnika, " +
                "3 - drzavu ili " +
                "0 - kraj.");
        int izbor = unos2.nextInt();
        switch(izbor){
            case 0:
                System.out.println("Kraj.");
                break;
            case 1:
                System.out.println("Unesite novi naziv grada: ");
                String noviNazivGrada = unos.nextLine();
                geografijaDAO.izmijeniGradNaziv(gradIzmjena, noviNazivGrada);
                break;
            case 2:
                System.out.println("Unesite novi broj stanovnika: ");
                Scanner unos3 = new Scanner(System.in);
                int brojSt = unos3.nextInt();
                geografijaDAO.izmijeniGradBrojSt(gradIzmjena, brojSt);
                break;
            case 3:
                System.out.println("Unesite novi naziv drzave: ");
                String novaDrzava = unos.nextLine();
                geografijaDAO.izmijeniGradDrzava(gradIzmjena, novaDrzava);
                break;
        }

    }

    public static void obrisiDrzavu(){
        Scanner unos = new Scanner(System.in);
        System.out.println("Unesite naziv drzave koju zelite obrisati: ");
        String naziv = unos.nextLine();
        geografijaDAO.obrisiDrzavu(naziv);
    }

    public static void nadjiDrzavu(){
        Scanner unos = new Scanner(System.in);
        System.out.println("Unesite naziv drzave koju zelite provjeriti: ");
        String naziv = unos.nextLine();
        Drzava drzava = geografijaDAO.nadjiDrzavu(naziv);
        if(drzava == null) System.out.println("Drzava ne postoji u bazi!");
        else System.out.println("Drzava postoji u bazi.");
    }

    public static void nadjiGrad(){
        Scanner unos = new Scanner(System.in);
        System.out.println("Unesite naziv grada koji zelite provjeriti: ");
        String naziv = unos.nextLine();
        Grad grad = geografijaDAO.nadjiGrad(naziv);
        if(grad == null) System.out.println("Grad ne postoji u bazi!");
        else System.out.println("Grad postoji u bazi.");
    }

}
