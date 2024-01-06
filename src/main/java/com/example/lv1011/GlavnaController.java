package com.example.lv1011;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlavnaController {

    private GeografijaDAO dao;

    @FXML
    private TableView<Grad> tableViewGradovi;

    @FXML
    private TableColumn<Grad, Integer> colGradId;

    @FXML
    private TableColumn<Grad, String> colGradNaziv;

    @FXML
    private TableColumn<Grad, Integer> colGradStanovnika;

    @FXML
    private TableColumn<Grad, String> colGradDrzava;

//    @FXML
//    public void initialize() {
//        dao = GeografijaDAO.getInstance();
//        tableViewGradovi.setItems(dao.sviGradovi());
//        colGradId.setCellValueFactory(new PropertyValueFactory<>("gradID"));
//        colGradNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
//        colGradStanovnika.setCellValueFactory(new PropertyValueFactory<>("brojStanovnika"));
//        colGradDrzava.setCellValueFactory(new PropertyValueFactory<>("drzavaID")); // log stavi ime grada a ne drzave, kako povezati te dvije tabele??
//    }

    @FXML
    public void initialize() {
        dao = GeografijaDAO.getInstance();

        colGradId.setCellValueFactory(new PropertyValueFactory<>("gradID"));
        colGradNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        colGradStanovnika.setCellValueFactory(new PropertyValueFactory<>("brojStanovnika"));

        colGradDrzava.setCellValueFactory(cellData -> {
            Grad grad = cellData.getValue();
            Drzava drzava = dao.nadjiDrzavu2(grad.getDrzavaID());
            if (drzava != null) {
                return new SimpleStringProperty(drzava.getNaziv());
            } else {
                return new SimpleStringProperty("Nema drzave u bazi");
            }

        });

        dao.sviGradovi().addListener((ListChangeListener<Grad>) change -> {
            while (change.next()) {
                if (change.wasAdded() || change.wasRemoved()) {
                    tableViewGradovi.setItems(dao.sviGradovi());
                }
            }
        });

        tableViewGradovi.setItems(dao.sviGradovi());

        dao.potrebnoAzuriranjeGlavnaControllerProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                tableViewGradovi.setItems(dao.sviGradovi());
                dao.setPotrebnoAzuriranjeGlavnaController(false);
            }
        });

        tableViewGradovi.setItems(dao.sviGradovi());
    }

    @FXML
    private void dodajGradButtonAction(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("grad.fxml"));
            Parent root = loader.load();
            GradController gradKontroler = loader.getController();
            Scene scene = new Scene(root, 300, 150);
            Stage stage = new Stage();
            stage.setTitle("Grad");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void dodajDrzavuButtonAction(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("drzava.fxml"));
            Parent root = loader.load();
            DrzavaController drzavaKontroler = loader.getController();
            Scene scene = new Scene(root, 300, 150);
            Stage stage = new Stage();
            stage.setTitle("Drzava");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void obrisiGradButtonAction() {
        Grad odabraniGrad = tableViewGradovi.getSelectionModel().getSelectedItem();

        if (odabraniGrad != null) {
            String grad = odabraniGrad.getNaziv();
            dao.obrisiGrad(grad);
            tableViewGradovi.getItems().remove(odabraniGrad);
        }
    }

}
