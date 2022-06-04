module com.example.betterclock {
    requires javafx.controls;
    requires javafx.fxml;


    opens github.florianlatapie.betterclock to javafx.fxml;
    exports github.florianlatapie.betterclock;
}