package com.temp.sheduler;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

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
