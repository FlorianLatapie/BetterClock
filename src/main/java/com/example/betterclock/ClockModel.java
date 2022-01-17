package com.example.betterclock;

import java.time.LocalTime;

/**
 * @author Florian Latapie
 */
public class ClockModel {
    private LocalTime currentTime;

    public String getFormattedTime() {
        currentTime = LocalTime.now();
        String hour = currentTime.getHour() >= 10 ? currentTime.getHour() + "" : "0" + currentTime.getHour();
        String minute = currentTime.getMinute() >= 10 ? currentTime.getMinute() + "" : "0" + currentTime.getMinute();
        return hour + ":" + minute;
    }

    public Double getHourProgress() {
        Double unit = 24.0;
        currentTime = LocalTime.now();
        return getMinuteProgress() / unit + currentTime.getHour() / unit;
    }

    public Double getMinuteProgress() {
        Double unit = 60.0;
        currentTime = LocalTime.now();
        return getSecondProgress() / unit + currentTime.getMinute() / unit;
    }

    public Double getSecondProgress() {
        Double unit = 60.0;
        currentTime = LocalTime.now();
        return currentTime.getSecond() / unit;
    }
}
