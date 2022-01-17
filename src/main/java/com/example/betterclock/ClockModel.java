package com.example.betterclock;

import java.time.LocalTime;

/**
 * @author Florian Latapie
 */
public class ClockModel {
    private LocalTime currentTime;

    public String getFormattedTime(){
        currentTime = LocalTime.now();
        String hour = currentTime.getHour() >= 10 ? currentTime.getHour() + "" : "0" + currentTime.getHour();
        String minute = currentTime.getMinute() >= 10 ? currentTime.getMinute() + "" : "0" + currentTime.getMinute();
        return hour + ":" + minute;
    }

    public Double getHourProgress(){
        currentTime = LocalTime.now();
        return currentTime.getHour()/24.0;
    }

    public Double getMinuteProgress(){
        currentTime = LocalTime.now();
        return currentTime.getMinute()/60.0;
    }
}
