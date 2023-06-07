module com.example.fuelprice {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.fuelprice to javafx.fxml;
    exports com.example.fuelprice;
}