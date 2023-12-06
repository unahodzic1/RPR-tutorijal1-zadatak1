package ba.unsa.etf.rpr.lv78;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ListView<String> listView;
    @FXML
    private TextField imeKorisnika;
    @FXML
    private TextField prezimeKorisnika;
    @FXML
    private TextField emailKorisnika;
    @FXML
    private TextField korisnickoIme;
    @FXML
    private PasswordField passwordKorisnika;

    public void dodajKorisnika(ActionEvent actionEvent){
        String uneseniKorisnik = imeKorisnika.getText() + " " + prezimeKorisnika.getText();
        listView.getItems().add(uneseniKorisnik);
        clear();
    }

    public void initialize(){
        listView.getItems().addAll("Una Hodzic", "Amina Cajic", "Amila Kukic", "Sara Kardas", "Lana Malinov", "Nadza Poljo", "Nadina Miralem",
                "Nerma Kadric", "Eman Boloban", "Hana Hodzic", "Anida Duharkic", "Naida Pandur");
        listView.setOnMouseClicked(this::klikNaPolje);
    }

    private void klikNaPolje(MouseEvent mouseEvent){
        String korisnik = listView.getSelectionModel().getSelectedItem();
        popuniPodatke(korisnik);
    }

    private void popuniPodatke(String korisnik){
        String[] imePrezime = korisnik.split(" ");
        imeKorisnika.setText(imePrezime[0]);
        prezimeKorisnika.setText(imePrezime[1]);
    }

    // ne razumijem bas tekst zadatka, jel se ovo trazi?

    public void krajPrograma(ActionEvent actionEvent){
        Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    private void clear(){
        imeKorisnika.clear();
        prezimeKorisnika.clear();
        emailKorisnika.clear();
        korisnickoIme.clear();
        passwordKorisnika.clear();
    }

}