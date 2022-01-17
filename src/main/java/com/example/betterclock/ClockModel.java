package com.example.betterclock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Florian Latapie
 */
public class ClockModel {
    private LocalTime currentTime;
    private static final DateTimeFormatter noSec = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter yesSec = DateTimeFormatter.ofPattern("HH:mm:ss");

    public String getFormattedTime() {
        currentTime = LocalTime.now();
        return noSec.format(currentTime);
    }

    public String getFormattedTimeWithSeconds() {
        currentTime = LocalTime.now();
        return yesSec.format(currentTime);
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
