package ba.unsa.etf.rpr.lv78;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller {

    private KorisnikModel model;
    @FXML
    private ListView<Korisnik> listView;
    @FXML
    public TextField imeKorisnika;
    @FXML
    public TextField prezimeKorisnika;
    @FXML
    public TextField emailKorisnika;
    @FXML
    public TextField korisnickoIme;
    @FXML
    public PasswordField passwordKorisnika;
    public Controller(KorisnikModel m){
        model = m;
    }

    @FXML
    public void initialize(){
        imeKorisnika.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
        prezimeKorisnika.textProperty().bindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
        emailKorisnika.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
        korisnickoIme.textProperty().bindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
        passwordKorisnika.textProperty().bindBidirectional(model.getTrenutniKorisnik().passwordProperty());

        listView.setItems(model.getKorisnici());

        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldKorisnik, newKorisnik)-> {
               model.setTrenutniKorisnik(newKorisnik);
               imeKorisnika.setText(newKorisnik.getIme());
               prezimeKorisnika.setText(newKorisnik.getPrezime());
               emailKorisnika.setText(newKorisnik.getEmail());
               korisnickoIme.setText(newKorisnik.getKorisnickoIme());
               passwordKorisnika.setText(newKorisnik.getPassword());
               listView.refresh();
        });
    }

    public void dodajKorisnika(ActionEvent actionEvent){
        KorisnikModel model = new KorisnikModel();
        Korisnik uneseniKorisnik = new Korisnik(imeKorisnika.getText(), prezimeKorisnika.getText(), emailKorisnika.getText(), korisnickoIme.getText(), passwordKorisnika.getText());
        model.dodajKorisnika(uneseniKorisnik);
        listView.getItems().add(uneseniKorisnik);
        clear();
    }

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