import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GeografijaDAO {
    private static GeografijaDAO singleton = null;
    private Connection konekcija;

    private GeografijaDAO() {
        try {
            String url = "jdbc:sqlite:baza2.db";
            konekcija = DriverManager.getConnection(url);
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

//    public void closeConnection() {
//        try {
//            if (konekcija != null && !konekcija.isClosed()) {
//                konekcija.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

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

    private void regenerisiBazu() {

    }

}
