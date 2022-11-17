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

    @PostMapping("/")
    public String userRegistration(@ModelAttribute User user, Model model){
        System.out.println(user.toString());
        //validate
        System.out.println(user.getId_drone());
        System.out.println(user.getLatitude());
        System.out.println(user.getLongitude());
        System.out.println(user.getTemperatura());
        System.out.println(user.getUmidade());
        System.out.println(user.getMyCheckbox());
        return "home";
    }
}