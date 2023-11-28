module com.example.probasamo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lv6 to javafx.fxml;
    exports com.example.lv6;
}