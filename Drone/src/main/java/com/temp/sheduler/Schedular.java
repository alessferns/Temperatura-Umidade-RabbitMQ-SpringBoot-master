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

	User user1 =  new User();
	User user2 =  new User();
	User user3 =  new User();

	@Scheduled(cron ="0/10 * * * * ?")
	void sendmessage() {

		//int id_drone = ThreadLocalRandom.current().nextInt(0, 5);;
		int latitude = ThreadLocalRandom.current().nextInt(0, 181) -90;
		int longitude = ThreadLocalRandom.current().nextInt(0, 361) -180;
		int umidade = ThreadLocalRandom.current().nextInt(0, 101);
		int temperatura= ThreadLocalRandom.current().nextInt(0, 66) - 25;


		user1.setId_drone(1);
		user1.setLatitude(latitude);
		user1.setLongitude(longitude);
		user1.setUmidade(umidade);
		user1.setTemperatura(temperatura);
		user1.setMyCheckbox("on");

		latitude = ThreadLocalRandom.current().nextInt(0, 181) -90;
		longitude = ThreadLocalRandom.current().nextInt(0, 361) -180;
		umidade = ThreadLocalRandom.current().nextInt(0, 101);
		temperatura= ThreadLocalRandom.current().nextInt(0, 66) - 25;

		user2.setId_drone(2);
		user2.setLatitude(latitude);
		user2.setLongitude(longitude);
		user2.setUmidade(umidade);
		user2.setTemperatura(temperatura);
		user2.setMyCheckbox("on");

		latitude = ThreadLocalRandom.current().nextInt(0, 181) -90;
		longitude = ThreadLocalRandom.current().nextInt(0, 361) -180;
		umidade = ThreadLocalRandom.current().nextInt(0, 101);
		temperatura= ThreadLocalRandom.current().nextInt(0, 66) - 25;

		user3.setId_drone(3);
		user3.setLatitude(latitude);
		user3.setLongitude(longitude);
		user3.setUmidade(umidade);
		user3.setTemperatura(temperatura);
		user3.setMyCheckbox("off");

		System.out.println("Rodando....");
		System.out.println("Enviando mensagem...");

		rabbitTemplate.convertAndSend("drone.ex","", user1);
		rabbitTemplate.convertAndSend("drone.ex","", user2);
		rabbitTemplate.convertAndSend("drone.ex","", user3);
	}

}