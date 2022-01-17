package com.example.betterclock;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ClockController implements Initializable {
    // FXML attributes
    @FXML
    private BorderPane borderPaneRoot;

    @FXML
    private Label time;
    @FXML
    private ProgressBar hourProgressBar;
    @FXML
    private ProgressBar minuteProgressBar;
    @FXML
    private ProgressBar secondProgressBar;

    @FXML
    private MenuBar menuBar;

    // Java attributes
    private boolean isBlackTheme = true;
    private boolean areSecondsDisplayed = false;

    private ClockModel clockModel;

    private Scene scene;
    private Stage stage;

    private double x = 0;
    private double y = 0;

    // Creation and Initialisation
    public ClockController() {
        clockModel = new ClockModel();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            hourProgressBar.setProgress(clockModel.getHourProgress());
            minuteProgressBar.setProgress(clockModel.getMinuteProgress());
            secondProgressBar.setProgress(clockModel.getSecondProgress());

            String timeText = areSecondsDisplayed ? clockModel.getFormattedTimeWithSeconds() : clockModel.getFormattedTime();
            time.setText(timeText);
            stage.setTitle(timeText + " - Better Clock");
        }),
                new KeyFrame(Duration.millis(10))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    // FXML methods
    @FXML
    protected void onCloseMenuItemAction() {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    protected void changeTheme() {
        scene.getStylesheets().clear();
        if (isBlackTheme) {
            scene.getStylesheets().add(getClass().getResource("/style-white.css").toExternalForm());
            isBlackTheme = false;
        } else {
            scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
            isBlackTheme = true;
        }
    }

    @FXML
    protected void onMenuEntered() {
        menuBar.setOpacity(1);
    }

    @FXML
    protected void onMenuExited() {
        menuBar.setOpacity(0);
    }

    @FXML
    protected void toggleSeconds() {
        if (areSecondsDisplayed) {
            secondProgressBar.setMaxSize(0, 0);
            secondProgressBar.setVisible(false);
            areSecondsDisplayed = false;
        } else {
            secondProgressBar.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
            secondProgressBar.setVisible(true);
            areSecondsDisplayed = true;
        }
    }

    @FXML
    private void borderpane_dragged(MouseEvent event) {
        Stage stage = (Stage) borderPaneRoot.getScene().getWindow();
        stage.setY(event.getScreenY() - y);
        stage.setX(event.getScreenX() - x);
    }

    @FXML
    private void borderpane_pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    // Java methods

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}