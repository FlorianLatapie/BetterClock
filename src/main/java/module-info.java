module com.example.betterclock {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.betterclock to javafx.fxml;
    exports com.example.betterclock;
}