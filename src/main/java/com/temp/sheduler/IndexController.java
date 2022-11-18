package com.temp.sheduler;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.ThreadLocalRandom;

@Configuration
@Service
@EnableScheduling
@Controller

public class IndexController{

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @PostMapping("/dashboard")
    public String userRegistration(@ModelAttribute User user, Model model){
        System.out.println(user.toString());
        //validate
        String drone;
        drone=user.getId_drone();
        String latitude;
        latitude = user.getLatitude();
        String longitude;
        longitude = user.getLongitude();
        String temperatura;
        temperatura = user.getTemperatura();
        String umidade;
        umidade = user.getUmidade();
        String rastreamento;
        rastreamento = user.getMyCheckbox();
        System.out.println(drone);
        System.out.println(latitude);
        System.out.println(longitude);
        System.out.println(temperatura);
        System.out.println(umidade);
        System.out.println(rastreamento);
        return "home";
    }
}