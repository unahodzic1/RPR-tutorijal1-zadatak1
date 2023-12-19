import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GeografijaDAO {
    private static GeografijaDAO singleton = null;
    private Connection konekcija;

    private GeografijaDAO() {
        try {
            File file = new File("baza1.db");
            if (file.exists()) {
                String url = "jdbc:sqlite:baza1.db";
                konekcija = DriverManager.getConnection(url);
            } else {
                String url = "jdbc:sqlite:baza1.db";
                konekcija = DriverManager.getConnection(url);
                regenerisiBazu();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static GeografijaDAO getInstance() {
        if (singleton == null) {
            singleton = new GeografijaDAO();
        }
        return singleton;
    }

    public static void removeInstance() throws SQLException { singleton.konekcija.close(); singleton = null; }

    // Zadatak 1
    public ArrayList<Grad> gradovi() {
        ArrayList<Grad> gradovi = new ArrayList<>();

        try {
            String sql = "SELECT naziv, broj_stanovnika FROM grad ORDER BY broj_stanovnika DESC";
            try (Statement statement = konekcija.createStatement();
                 ResultSet rs = statement.executeQuery(sql)) {

                while (rs.next()) {
                    String naziv = rs.getString("naziv");
                    int brojStanovnika = rs.getInt("broj_stanovnika");

                    Grad grad = new Grad(naziv, brojStanovnika);
                    gradovi.add(grad);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gradovi;
    }

    // Zadatak 2
    // metoda iz predavanja
    private void regenerisiBazu() {
        Scanner ulaz = null;
        try{
            ulaz = new Scanner(new FileInputStream("bazaRPR.db.sql")); // povezujemo se sa SQL dump datotekom
            String sqlUpit = "";
            while(ulaz.hasNext()){
                sqlUpit += ulaz.nextLine();
                if(sqlUpit.length() > 1 && sqlUpit.charAt(sqlUpit.length()-1) == ';'){
                    try{
                        Statement stmt = konekcija.createStatement();
                        stmt.execute(sqlUpit);
                        sqlUpit = "";
                    }
                    catch(SQLException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
