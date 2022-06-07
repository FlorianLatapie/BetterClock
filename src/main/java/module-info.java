module fr.florianlatapie.betterclock {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.florianlatapie.betterclock to javafx.fxml;
    exports fr.florianlatapie.betterclock;
}