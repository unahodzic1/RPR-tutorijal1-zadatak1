import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GeografijaDAO {
    private static GeografijaDAO singleton = null;
    private Connection konekcija;

    // pripremljeni upiti

    private PreparedStatement izmijeniGradNaziv;
    private PreparedStatement izmijeniGradBrojStanovnika;
    private PreparedStatement izmijeniGradDrzavaID;
    private PreparedStatement gradoviIspis;
    private PreparedStatement glavniGrad;
    private PreparedStatement obrisiDrzavu1;
    private PreparedStatement obrisiDrzavu2;
    private PreparedStatement dodajGrad;
    private PreparedStatement dodajDrzavu;
    private PreparedStatement nadjiDrzavu;
    private PreparedStatement drzaveIspis;
    private PreparedStatement nadjiGrad;

    private GeografijaDAO() {
        try {
            konekcija = DriverManager.getConnection("jdbc:sqlite:baza.db");
            izmijeniGradNaziv = konekcija.prepareStatement("UPDATE grad SET naziv = ? WHERE id = ?");
            gradoviIspis = konekcija.prepareStatement("SELECT id, naziv, broj_stanovnika, drzava FROM grad ORDER BY broj_stanovnika DESC");
            glavniGrad = konekcija.prepareStatement("SELECT g.id, g.naziv, g.broj_stanovnika, g.drzava FROM grad g, drzava d WHERE d.glavni_grad = g.id AND d.naziv = ?");
            izmijeniGradBrojStanovnika = konekcija.prepareStatement("UPDATE grad SET broj_stanovnika = ? WHERE id = ?");
            izmijeniGradDrzavaID = konekcija.prepareStatement("UPDATE grad SET drzava = ? WHERE id = ?");
            obrisiDrzavu1 = konekcija.prepareStatement("DELETE FROM grad WHERE drzava IN (SELECT id FROM drzava WHERE naziv = ? )");
            obrisiDrzavu2 = konekcija.prepareStatement("DELETE FROM drzava WHERE naziv = ? ");
            dodajGrad = konekcija.prepareStatement("INSERT INTO grad (naziv, broj_stanovnika, drzava) VALUES (?, ?, ?)");
            dodajDrzavu = konekcija.prepareStatement("INSERT INTO drzava (naziv, glavni_grad) VALUES (?, ?)");
            nadjiDrzavu = konekcija.prepareStatement("SELECT * FROM drzava WHERE naziv = ?");
            drzaveIspis = konekcija.prepareStatement("SELECT * FROM drzava");
            nadjiGrad = konekcija.prepareStatement("SELECT * FROM grad WHERE naziv = ?");
            // File file = new File("baza2.db");
//            if (file.exists()) {
//                String url = "jdbc:sqlite:baza2.db";
//                konekcija = DriverManager.getConnection(url);
//            } else {
//                String url = "jdbc:sqlite:baza2.db";
//                konekcija = DriverManager.getConnection(url);
//                regenerisiBazu();
//            }

//            izmijeniGradNaziv = konekcija.prepareStatement("UPDATE grad SET naziv = ? WHERE id = ?");
//            gradoviIspis = konekcija.prepareStatement("SELECT id, naziv, broj_stanovnika, drzava FROM grad ORDER BY broj_stanovnika DESC");
//            glavniGrad = konekcija.prepareStatement("SELECT g.id, g.naziv, g.broj_stanovnika, g.drzava FROM grad g, drzava d WHERE d.glavni_grad = g.id AND d.naziv = ?");
//            izmijeniGradBrojStanovnika = konekcija.prepareStatement("UPDATE grad SET broj_stanovnika = ? WHERE id = ?");
//            izmijeniGradDrzavaID = konekcija.prepareStatement("UPDATE grad SET drzava = ? WHERE id = ?");
//            obrisiDrzavu1 = konekcija.prepareStatement("DELETE FROM grad WHERE drzava IN (SELECT id FROM drzava WHERE naziv = ? )");
//            obrisiDrzavu2 = konekcija.prepareStatement("DELETE FROM drzava WHERE naziv = ? ");
//            dodajGrad = konekcija.prepareStatement("INSERT INTO grad (naziv, broj_stanovnika, drzava) VALUES (?, ?, ?)");
//            dodajDrzavu = konekcija.prepareStatement("INSERT INTO drzava (naziv, glavni_grad) VALUES (?, ?)");
//            nadjiDrzavu = konekcija.prepareStatement("SELECT * FROM drzava WHERE naziv = ?");
//            drzaveIspis = konekcija.prepareStatement("SELECT * FROM drzava");
//            nadjiGrad = konekcija.prepareStatement("SELECT * FROM grad WHERE naziv = ?");
        } catch (SQLException e) {
            regenerisiBazu();
            try {
                izmijeniGradNaziv = konekcija.prepareStatement("UPDATE grad SET naziv = ? WHERE id = ?");
                gradoviIspis = konekcija.prepareStatement("SELECT id, naziv, broj_stanovnika, drzava FROM grad ORDER BY broj_stanovnika DESC");
                glavniGrad = konekcija.prepareStatement("SELECT g.id, g.naziv, g.broj_stanovnika, g.drzava FROM grad g, drzava d WHERE d.glavni_grad = g.id AND d.naziv = ?");
                izmijeniGradBrojStanovnika = konekcija.prepareStatement("UPDATE grad SET broj_stanovnika = ? WHERE id = ?");
                izmijeniGradDrzavaID = konekcija.prepareStatement("UPDATE grad SET drzava = ? WHERE id = ?");
                obrisiDrzavu1 = konekcija.prepareStatement("DELETE FROM grad WHERE drzava IN (SELECT id FROM drzava WHERE naziv = ? )");
                obrisiDrzavu2 = konekcija.prepareStatement("DELETE FROM drzava WHERE naziv = ? ");
                dodajGrad = konekcija.prepareStatement("INSERT INTO grad (naziv, broj_stanovnika, drzava) VALUES (?, ?, ?)");
                dodajDrzavu = konekcija.prepareStatement("INSERT INTO drzava (naziv, glavni_grad) VALUES (?, ?)");
                nadjiDrzavu = konekcija.prepareStatement("SELECT * FROM drzava WHERE naziv = ?");
                drzaveIspis = konekcija.prepareStatement("SELECT * FROM drzava");
                nadjiGrad = konekcija.prepareStatement("SELECT * FROM grad WHERE naziv = ?");
            }
            catch (SQLException e1){
                e1.printStackTrace();
            }
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
            try (ResultSet rs = gradoviIspis.executeQuery()) {
                while (rs.next()) {
                    int gradID = rs.getInt("id");
                    String naziv = rs.getString("naziv");
                    int brojStanovnika = rs.getInt("broj_stanovnika");
                    int drzavaID = rs.getInt("drzava");

                    Grad grad = new Grad(gradID, naziv, brojStanovnika, drzavaID);
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

    // Zadatak 3
    // CRUD operacije
    public Grad glavniGrad(String drzava){
        Grad vratiGlavni = null;
        try {
            glavniGrad.setString(1, drzava);
            try (ResultSet rs = glavniGrad.executeQuery()) {
                while (rs.next()) {
                    int gradID = rs.getInt("id");
                    String naziv = rs.getString("naziv");
                    int brojStanovnika = rs.getInt("broj_stanovnika");
                    int drzavaID = rs.getInt("drzava");

                    vratiGlavni = new Grad(gradID, naziv, brojStanovnika, drzavaID);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vratiGlavni;
    }

    public void obrisiDrzavu(String drzava) {
        try {
            obrisiDrzavu1.setString(1, drzava);
            obrisiDrzavu1.executeUpdate();
            obrisiDrzavu2.setString(1,drzava);
            obrisiDrzavu2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dodajGrad(Grad grad){
        String naziv = grad.getNaziv();
        int brojStanovnika = grad.getBrojStanovnika();
        int drzavaID = grad.getDrzavaID();
        try{
            dodajGrad.setString(1, naziv);
            dodajGrad.setInt(2, brojStanovnika);
            dodajGrad.setInt(3, drzavaID);
            dodajGrad.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void dodajDrzavu(Drzava drzava){
        String naziv = drzava.getNaziv();
        int gradID = drzava.getGradID();
        try{
            dodajDrzavu.setString(1, naziv);
            dodajDrzavu.setInt(2, gradID);
            dodajDrzavu.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void izmijeniGradNaziv(Grad grad, String noviNaziv){
        int gradID = grad.getGradID();
        String naziv = grad.getNaziv();
        int brojStanovnika = grad.getBrojStanovnika();
        int drzavaID = grad.getDrzavaID();
        try{
            izmijeniGradNaziv.setString(1, noviNaziv);
            izmijeniGradNaziv.setInt(2, gradID);
            izmijeniGradNaziv.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void izmijeniGradBrojSt(Grad grad, int brojSt){
        int gradID = grad.getGradID();
        String naziv = grad.getNaziv();
        int brojStanovnika = grad.getBrojStanovnika();
        int drzavaID = grad.getDrzavaID();
        try{
            izmijeniGradBrojStanovnika.setInt(1, brojSt);
            izmijeniGradBrojStanovnika.setInt(2, gradID);
            izmijeniGradBrojStanovnika.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void izmijeniGradDrzava(Grad grad, String drzava){
        int gradID = grad.getGradID();
        String naziv = grad.getNaziv();
        int brojStanovnika = grad.getBrojStanovnika();
        int drzavaID = grad.getDrzavaID();
        try{
            Drzava drzavaIzmjena = nadjiDrzavu(drzava);
            int noviID = drzavaIzmjena.getDrzavaID();
            izmijeniGradDrzavaID.setInt(1, noviID);
            izmijeniGradDrzavaID.setInt(2, gradID);
            izmijeniGradDrzavaID.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Drzava nadjiDrzavu(String drzava){
        Drzava vratiDrzavu = null;
        try{
            nadjiDrzavu.setString(1, drzava);
            try(ResultSet rs = nadjiDrzavu.executeQuery()){
                while (rs.next()) {
                    int drzavaID = rs.getInt("id");
                    String naziv = rs.getString("naziv");
                    int gradID = rs.getInt("glavni_grad");

                    vratiDrzavu = new Drzava(drzavaID, drzava, gradID);
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return vratiDrzavu;
    }

    // dodatak (zbog main-a)

    public ArrayList<Drzava> drzave() {
        ArrayList<Drzava> drzave = new ArrayList<>();

        try {
            try (ResultSet rs = drzaveIspis.executeQuery()) {
                while (rs.next()) {
                    int drzavaID = rs.getInt("id");
                    String naziv = rs.getString("naziv");
                    int gradID = rs.getInt("glavni_grad");

                    Drzava drzava = new Drzava(drzavaID, naziv, gradID);
                    drzave.add(drzava);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drzave;
    }

    public Grad nadjiGrad(String grad){
        Grad vratiGrad = null;
        try{
            nadjiGrad.setString(1, grad);
            try(ResultSet rs = nadjiGrad.executeQuery()){
                while (rs.next()) {
                    int gradID = rs.getInt("id");
                    String naziv = rs.getString("naziv");
                    int brojStanovnika = rs.getInt("broj_stanovnika");
                    int drzavaID = rs.getInt("drzava");

                    vratiGrad = new Grad(gradID, grad, brojStanovnika, drzavaID);
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return vratiGrad;
    }

}
