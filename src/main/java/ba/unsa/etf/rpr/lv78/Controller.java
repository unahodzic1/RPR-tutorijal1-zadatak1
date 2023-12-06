package ba.unsa.etf.rpr.lv78;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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