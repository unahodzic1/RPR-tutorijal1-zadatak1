package com.example.lv1011;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GeografijaDAO dao = GeografijaDAO.getInstance();
//        dao.obrisiSveUnose();
//        dao.unosPredefinisanihPodataka();
        Parent root = FXMLLoader.load(getClass().getResource("glavna.fxml"));
        stage.setTitle("Gradovi svijeta");
        stage.setScene(new Scene(root, 500, 500));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
