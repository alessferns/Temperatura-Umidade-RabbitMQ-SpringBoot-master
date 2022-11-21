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

import java.util.concurrent.ThreadLocalRandom;

@Configuration
@Service
@EnableScheduling

public class User {

    public String getId_drone() {
        return id_drone;
    }

    public void setId_drone(String id_drone) {
        this.id_drone = id_drone;
    }

    public String id_drone;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String latitude;

    public String longitude;

    public static String getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }
    public static String temperatura;

    public static String umidade;
    public static String getUmidade() {
        return umidade;
    }
    public void setUmidade(String umidade) {
        this.umidade = umidade;
    }

    public String getMyCheckbox() {
        return myCheckbox;
    }

    public void setMyCheckbox(String myCheckbox) {
        this.myCheckbox = myCheckbox;
    }

    public String myCheckbox;
}

