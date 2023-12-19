import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        GeografijaDAO geografijaDAO = GeografijaDAO.getInstance();

        ArrayList<Grad> gradovi = geografijaDAO.gradovi();

        System.out.println("Gradovi u opadajućem redoslijedu po broju stanovnika:");
        for (Grad grad : gradovi) {
            System.out.println(grad.getNaziv() + " (" + grad.getBrojStanovnika() + ")");
        }

        // zatvaranje konekcije

        try{
            GeografijaDAO.removeInstance();
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }
}
