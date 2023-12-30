package com.example.lv1011;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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
    private TableColumn<Drzava, String> colGradDrzava;

    @FXML
    public void initialize() {
        dao = GeografijaDAO.getInstance();
        tableViewGradovi.setItems(dao.sviGradovi());
        colGradId.setCellValueFactory(new PropertyValueFactory<>("gradID"));
        colGradNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        colGradStanovnika.setCellValueFactory(new PropertyValueFactory<>("brojStanovnika"));
        colGradDrzava.setCellValueFactory(new PropertyValueFactory<>("drzavaID")); // log stavi ime grada a ne drzave, kako povezati te dvije tabele??
    }

    @FXML
    private void dodajGradButtonAction(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("grad.fxml"));
            Parent root = loader.load();
            GradController gradKontroler = loader.getController();
            Scene scene = new Scene(root, 300, 150);
            Stage stage = new Stage();
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
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
