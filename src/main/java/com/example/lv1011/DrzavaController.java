package com.example.lv1011;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.text.ChoiceFormat;

public class DrzavaController {

    private GeografijaDAO dao;

    private static int noviID = 3;

    @FXML
    private TextField fieldNaziv;

    @FXML
    private ChoiceBox<Grad> choiceGrad;

    @FXML
    private void initialize() {
        dao = GeografijaDAO.getInstance();
        choiceGrad.setItems(FXCollections.observableArrayList(dao.gradovi()));
    }

    @FXML
    public void cancelButtonAction(ActionEvent event){
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void okButtonAction(ActionEvent event) {
        String userInputNaziv = fieldNaziv.getText();
        Grad selectedGrad = choiceGrad.getValue();

        boolean validInput = validirajUnos(userInputNaziv, selectedGrad);

        if (validInput) {
            Drzava novaDrzava = new Drzava(noviID, userInputNaziv, selectedGrad.getGradID());
            dao.dodajDrzavu(novaDrzava);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.close();
        }

    }

    private boolean validirajUnos(String naziv, Grad selectedGrad) {
        boolean isValid = true;

        if (naziv.isEmpty()) {
            fieldNaziv.setStyle("-fx-border-color: red; -fx-background-color: #ffd4d4;");
            isValid = false;
        } else {
            fieldNaziv.setStyle("");
        }

        if (selectedGrad == null) {
            isValid = false;
        }

        return isValid;
    }

}
