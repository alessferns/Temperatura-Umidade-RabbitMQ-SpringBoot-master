package com.temp.receiver;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Configuration
@Service
@EnableScheduling

public class User implements Serializable {

    public int id_drone;
    public int latitude;
    public int longitude;
    public int temperatura;
    public int umidade;
    public String myCheckbox;

    public int getId_drone() {
        return id_drone;
    }

    public void setId_drone(int id_drone) {
        this.id_drone = id_drone;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getUmidade() {
        return umidade;
    }

    public void setUmidade(int umidade) {
        this.umidade = umidade;
    }

    public String getMyCheckbox() {
        return myCheckbox;
    }

    public void setMyCheckbox(String myCheckbox) {
        this.myCheckbox = myCheckbox;
    }

}
