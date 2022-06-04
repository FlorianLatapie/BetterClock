package github.florianlatapie.betterclock;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class ClockApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ClockApplication.class.getResource("clock-view.fxml"));

        Parent root = fxmlLoader.load();
        ClockController myController = fxmlLoader.getController();

        Scene scene = new Scene(root);

        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/style.css")).toExternalForm());

        myController.setScene(scene);
        myController.setStage(stage);

        stage.setScene(scene);
        stage.setTitle("Better Clock");
        stage.initStyle(StageStyle.UNDECORATED);

        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResource("/images/clock_icon.png")).toExternalForm()));

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}