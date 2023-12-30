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
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("glavna.fxml"));
//        Parent root = fxmlLoader.load();
//        Scene scene = new Scene(root, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
//        stage.setTitle("Gradovi svijeta");
//        stage.setScene(scene);
//        stage.setResizable(false);
//        stage.show();
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
