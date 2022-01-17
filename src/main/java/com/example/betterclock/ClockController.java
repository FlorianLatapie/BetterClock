package com.example.betterclock;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class ClockController implements Initializable {
    @FXML
    private Label welcomeText;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            String hour = currentTime.getHour() >= 10 ? currentTime.getHour() + "" : "0" + currentTime.getHour();
            String minute = currentTime.getMinute() >= 10 ? currentTime.getMinute() + "" : "0" + currentTime.getMinute();
            String second = currentTime.getSecond() >= 10 ? currentTime.getSecond() + "" : "0" + currentTime.getSecond();
            welcomeText.setText(hour + ":" + minute + ":" + second);
        }),
                new KeyFrame(Duration.millis(500))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
}