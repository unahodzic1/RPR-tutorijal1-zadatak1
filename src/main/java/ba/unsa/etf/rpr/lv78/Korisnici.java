package ba.unsa.etf.rpr.lv78;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Korisnici extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        KorisnikModel model = new KorisnikModel();
        model.napuni();
        FXMLLoader fxmlLoader = new FXMLLoader(Korisnici.class.getResource("korisnici-view.fxml"));
        fxmlLoader.setController(new Controller(model));
        Parent root = fxmlLoader.load();
        stage.setTitle("Korisnici");
        stage.setScene(new Scene(root, 500, 250));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}