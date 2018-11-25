package ru.tinkoff.ru.seminar;


import android.support.annotation.NonNull;

public class Weather {
    public String description;
    public long time;
    public float temp;
    public float speedWind;

    public Weather(@NonNull String description, long time, float temp, float speedWind) {
        this.description = description;
        this.time = time;
        this.temp = temp;
        this.speedWind = speedWind;
    }

    public Weather() {
        //stub
    }

    @Override
    public String toString() {
        return "Weather{" +
                "description='" + description + '\'' +
                ", time='" + time + '\'' +
                ", temp=" + temp +
                ", speedWind=" + speedWind +
                '}';
    }
}