package com.example.betterclock;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class ClockController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private ProgressBar hourProgressBar;
    @FXML
    private ProgressBar minuteProgressBar;

    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem closeMenuItem;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            hourProgressBar.setProgress(currentTime.getHour()/24.0);
            minuteProgressBar.setProgress(currentTime.getMinute()/60.0);
            String hour = currentTime.getHour() >= 10 ? currentTime.getHour() + "" : "0" + currentTime.getHour();
            String minute = currentTime.getMinute() >= 10 ? currentTime.getMinute() + "" : "0" + currentTime.getMinute();
            welcomeText.setText(hour + ":" + minute);
        }),
                new KeyFrame(Duration.millis(500))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    @FXML
    protected void onCloseMenuItemAction() {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    protected void onMenuEntered(){
        menuBar.setOpacity(1);
    }

    @FXML
    protected void onMenuExited(){
        menuBar.setOpacity(0);
    }
}