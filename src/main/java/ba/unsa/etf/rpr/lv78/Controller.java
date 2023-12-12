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

    private boolean updatePodatke = false;
    public Controller(KorisnikModel m){
        model = m;
    }

//    @FXML
//    public void initialize(){
//        imeKorisnika.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
//        prezimeKorisnika.textProperty().bindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
//        emailKorisnika.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
//        korisnickoIme.textProperty().bindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
//        passwordKorisnika.textProperty().bindBidirectional(model.getTrenutniKorisnik().passwordProperty());
//
//        listView.setItems(model.getKorisnici());
//
//        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldKorisnik, newKorisnik)-> {
//               model.setTrenutniKorisnik(newKorisnik);
//               imeKorisnika.setText(newKorisnik.getIme());
//               prezimeKorisnika.setText(newKorisnik.getPrezime());
//               emailKorisnika.setText(newKorisnik.getEmail());
//               korisnickoIme.setText(newKorisnik.getKorisnickoIme());
//               passwordKorisnika.setText(newKorisnik.getPassword());
//               listView.refresh();
//        });
//    }

    @FXML
    public void initialize() {
        imeKorisnika.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
        prezimeKorisnika.textProperty().bindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
        emailKorisnika.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
        korisnickoIme.textProperty().bindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
        passwordKorisnika.textProperty().bindBidirectional(model.getTrenutniKorisnik().passwordProperty());

        listView.setItems(model.getKorisnici());

        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldKorisnik, newKorisnik)-> {
            if (newKorisnik != null) {
                model.setTrenutniKorisnik(newKorisnik);
                imeKorisnika.setText(newKorisnik.getIme());
                prezimeKorisnika.setText(newKorisnik.getPrezime());
                emailKorisnika.setText(newKorisnik.getEmail());
                korisnickoIme.setText(newKorisnik.getKorisnickoIme());
                passwordKorisnika.setText(newKorisnik.getPassword());
                listView.refresh();
            }
        });

        imeKorisnika.textProperty().addListener((obs, oldText, newText) -> model.getTrenutniKorisnik().setIme(newText));
        prezimeKorisnika.textProperty().addListener((obs, oldText, newText) -> model.getTrenutniKorisnik().setPrezime(newText));
        emailKorisnika.textProperty().addListener((obs, oldText, newText) -> model.getTrenutniKorisnik().setEmail(newText));
        korisnickoIme.textProperty().addListener((obs, oldText, newText) -> model.getTrenutniKorisnik().setKorisnickoIme(newText));
        passwordKorisnika.textProperty().addListener((obs, oldText, newText) -> model.getTrenutniKorisnik().setPassword(newText));
    }


    public void dodajKorisnika(ActionEvent actionEvent){
        KorisnikModel model = new KorisnikModel();
        Korisnik uneseniKorisnik = new Korisnik();
        model.dodajKorisnika(uneseniKorisnik);
        listView.getItems().add(uneseniKorisnik);
        // clear();
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