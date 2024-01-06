package com.example.lv1011;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.text.ChoiceFormat;
import java.util.ArrayList;
import java.util.List;

public class GradController {

    private static int noviID = 6;

    private GeografijaDAO dao;

    @FXML
    private TextField fieldNaziv, fieldBrojStanovnika;

    @FXML
    private Label labelNaziv;

    @FXML
    private ChoiceBox<Drzava> choiceDrzava;

    @FXML
    private void initialize() {
        dao = GeografijaDAO.getInstance();
        choiceDrzava.setItems(FXCollections.observableArrayList(dao.drzave()));
    }

    @FXML
    public void cancelButtonAction(ActionEvent event){
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void okButtonAction(ActionEvent event) {
        String userInputNaziv = fieldNaziv.getText();
        String userInputBrojStanovnika = fieldBrojStanovnika.getText();
        Drzava selectedDrzava = choiceDrzava.getValue();

        boolean validInput = validateInput(userInputNaziv, userInputBrojStanovnika, selectedDrzava);

        if (validInput) {
            Grad noviGrad = new Grad(noviID, userInputNaziv, Integer.parseInt(userInputBrojStanovnika), selectedDrzava.getDrzavaID());

            // ako postoji grad onda se samo update podaci

            List<Grad> sviGradovi = dao.gradovi();
            boolean gradPostoji = false;

            for (Grad x : sviGradovi) {
                if (x.getNaziv().equals(noviGrad.getNaziv()) || x.getBrojStanovnika() == noviGrad.getBrojStanovnika()) {
                    gradPostoji = true;
                    // promjena naziva grada
                    if (!x.getNaziv().equals(noviGrad.getNaziv()) && (x.getBrojStanovnika() == Integer.parseInt(userInputBrojStanovnika)) && (x.getDrzavaID() == selectedDrzava.getDrzavaID())) {
                        dao.izmijeniGradNaziv(noviGrad, userInputNaziv);
                    }
                    // promjena broja stanovnika
                    if (x.getBrojStanovnika() != noviGrad.getBrojStanovnika() && x.getNaziv().equals(noviGrad.getNaziv()) && (x.getDrzavaID() == selectedDrzava.getDrzavaID())) {
                        dao.izmijeniGradBrojSt(x, Integer.parseInt(userInputBrojStanovnika));
                    }
                    // promjena drzave
                    if(x.getBrojStanovnika() == noviGrad.getBrojStanovnika() && x.getNaziv().equals(noviGrad.getNaziv()) && (x.getDrzavaID() != selectedDrzava.getDrzavaID())){
                        dao.izmijeniGradDrzava(x, selectedDrzava.getNaziv());
                    }
                    break;
                }
            }

            if (!gradPostoji) {
                dao.dodajGrad(noviGrad);
            }

            dao.setPotrebnoAzuriranjeGlavnaController(true);

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.close();

        }

    }

    private boolean validateInput(String naziv, String brojStanovnika, Drzava selectedDrzava) {
        boolean isValid = true;

        if (naziv.isEmpty()) {
            fieldNaziv.setStyle("-fx-border-color: red; -fx-background-color: #ffd4d4;");
            isValid = false;
        } else {
            fieldNaziv.setStyle("");
        }

        if (brojStanovnika.isEmpty() || brojStanovnika.contains("-") || brojStanovnika.contains(",") || brojStanovnika.contains(".")) {
            fieldBrojStanovnika.setStyle("-fx-border-color: red; -fx-background-color: #ffd4d4;");
            isValid = false;
        } else {
            fieldBrojStanovnika.setStyle("");
        }

        if (selectedDrzava == null) {
            isValid = false;
        }

        return isValid;
    }

}

