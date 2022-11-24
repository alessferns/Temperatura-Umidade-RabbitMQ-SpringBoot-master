package com.temp.sheduler;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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

public class Schedular {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	User user =  new User();

	@Scheduled(cron ="0/10 * * * * ?")
	void sendmessage() {

		int id_drone = ThreadLocalRandom.current().nextInt(0, 5);;
		int latitude = ThreadLocalRandom.current().nextInt(0, 10001);
		int longitude = ThreadLocalRandom.current().nextInt(0, 10001);
		int umidade = ThreadLocalRandom.current().nextInt(0, 101);
		int temperatura= ThreadLocalRandom.current().nextInt(0, 66) - 25;
		System.out.println("Rodando....");
	    System.out.println("Enviando mensagem...");

		user.setId_drone(id_drone);
		user.setLatitude(latitude);
		user.setLongitude(longitude);
		user.setUmidade(umidade);
		user.setTemperatura(temperatura);
		user.setMyCheckbox("on");

		rabbitTemplate.convertAndSend("drone.ex","", user);
	}

}