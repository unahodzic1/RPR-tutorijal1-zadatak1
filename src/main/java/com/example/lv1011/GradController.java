package com.example.lv1011;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.ChoiceFormat;

public class GradController {

    @FXML
    private TextField fieldNaziv, fieldBrojStanovnika;

    @FXML
    private Label labelNaziv;

    @FXML
    private ChoiceBox<Drzava> choiceDrzava;

    @FXML
    private void initialize() {
        choiceDrzava.setItems(FXCollections.observableArrayList(GeografijaDAO.getInstance().drzave()));
    }

    @FXML
    public void cancelButtonAction(ActionEvent event){
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void validateInputGrad(){
        String userInput = fieldNaziv.getText();
        String userInput2 = fieldBrojStanovnika.getText();

        // naziv ne smije ostati prazan

        if(userInput.isEmpty()){
            fieldNaziv.setStyle("-fx-border-color: red; -fx-background-color: #ffd4d4;");
        }
        else{
            fieldNaziv.setStyle("");
        }

        // brojStanovnika mora biti cijeli pozitivni broj

        if(userInput2.contains("-") || userInput2.contains(",") || userInput2.contains(".")){
            fieldBrojStanovnika.setStyle("-fx-border-color: red; -fx-background-color: #ffd4d4;");
        }
        else{
            fieldBrojStanovnika.setStyle("");
        }

    }

}
