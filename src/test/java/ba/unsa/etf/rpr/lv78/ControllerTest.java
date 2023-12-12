package ba.unsa.etf.rpr.lv78;
import static org.junit.jupiter.api.Assertions.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

@ExtendWith(ApplicationExtension.class)
class ControllerTest{
    
    @Start
    public void start(Stage stage) throws Exception{
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

    @Test
    public void dodajKorisnikaTest1(FxRobot robot){
        robot.clickOn("#imeKorisnika").write("Una");
        robot.clickOn("#prezimeKorisnika").write("Hodzic");
        robot.clickOn("#emailKorisnika").write("uhodzic1@etf.unsa.ba");
        robot.clickOn("#korisnickoIme").write("uhodzic1");
        robot.clickOn("#passwordKorisnika").write("123");

        robot.clickOn("#dodajBtn");

        assertEquals(6, robot.lookup("#listView").queryAs(ListView.class).getItems().size());
    }

    @Test
    public void dodajKorisnikaTest2(FxRobot robot){
        robot.clickOn("#imeKorisnika").write("Hana");
        robot.clickOn("#prezimeKorisnika").write("Hodzic");
        robot.clickOn("#emailKorisnika").write("hhodzic1@etf.unsa.ba");
        robot.clickOn("#korisnickoIme").write("hhodzic1");
        robot.clickOn("#passwordKorisnika").write("222");

        robot.clickOn("#dodajBtn");
        assertEquals("Hana", robot.lookup("#imeKorisnika").queryAs(TextField.class).getText());
        assertEquals("Hodzic", robot.lookup("#prezimeKorisnika").queryAs(TextField.class).getText());
        assertEquals("hhodzic1@etf.unsa.ba", robot.lookup("#emailKorisnika").queryAs(TextField.class).getText());
        assertEquals("hhodzic1", robot.lookup("#korisnickoIme").queryAs(TextField.class).getText());
        assertEquals("222", robot.lookup("#passwordKorisnika").queryAs(PasswordField.class).getText());
    }

    @Test
    public void test3(FxRobot robot) {
        robot.clickOn("#krajBtn");
        assertTrue(robot.lookup("#imeKorisnika").tryQuery().isEmpty());
    }

}