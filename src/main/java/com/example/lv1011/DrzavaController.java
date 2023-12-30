package com.example.lv1011;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.text.ChoiceFormat;

public class DrzavaController {

    @FXML
    private ChoiceBox<Grad> choiceGrad;

    @FXML
    public void cancelButtonAction(ActionEvent event){
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void initialize() {
        choiceGrad.setItems(FXCollections.observableArrayList(GeografijaDAO.getInstance().gradovi()));
    }
}
