import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static GeografijaDAO geografijaDAO = GeografijaDAO.getInstance();

    public static void main(String[] args) {

        // Zadatak 4

        System.out.println("Izaberite opciju: " +
                "1 - ispisiGradove(), " +
                "2 - glavniGrad(), " +
                "3 - izmijeniInfoGrad ili " +
                "0 - kraj ");

        Scanner unos = new Scanner(System.in);
        int izbor = unos.nextInt();

        switch(izbor){
            case 0:
                System.out.println("Kraj programa.");
                break;
            case 1:
                System.out.println(ispisiGradove());
                break;
            case 2:
                glavniGrad();
                break;
            case 3:
                izmijeniInfoGrad();
                break;
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
                vratiString = vratiString + gradovi.get(i).getNaziv() + " (" + drzave.get(j).getNaziv() + ") " + gradovi.get(i).getBrojStanovnika() + " ";
            }
        }

        return vratiString;
    }

    public static void glavniGrad(){
        System.out.println("Unesite naziv drzave: ");
        Scanner unos = new Scanner(System.in);
        String nazivDrzave = unos.nextLine();
        Grad glavniGr = geografijaDAO.glavniGrad(nazivDrzave);
        System.out.println("Glavni grad drzave " + nazivDrzave + " je " + glavniGr + ".");
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
                System.out.println("Unesite broj stanovnika: ");
                Scanner unos3 = new Scanner(System.in);
                int brojSt = unos3.nextInt();
                geografijaDAO.izmijeniGradBrojSt(gradIzmjena, brojSt);
                break;
            case 3:
                System.out.println("Unesite naziv drzave: ");
                String novaDrzava = unos.nextLine();
                geografijaDAO.izmijeniGradDrzava(gradIzmjena, novaDrzava);
                break;
        }

    }

}
