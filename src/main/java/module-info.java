module com.example.lv1011 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.lv1011 to javafx.fxml;
    exports com.example.lv1011;
}