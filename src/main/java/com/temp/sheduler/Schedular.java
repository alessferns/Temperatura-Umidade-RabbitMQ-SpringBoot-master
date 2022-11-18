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

public class Schedular {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${livetemperature.rabbitmq.exchange}")
	private String exchange;
		
	@Value("${livetemperature.rabbitmq.routingkey}")
	private String routingkey;

	@Scheduled(cron ="0/10 * * * * ?")
	void sendmessage() {

		String temperatura;
		temperatura = User.getTemperatura();
		System.out.println("Rodando....");
	    System.out.println("Enviando mensagem...");
		int randomNum = ThreadLocalRandom.current().nextInt(0, 35 + 1);
		amqpTemplate.convertAndSend(exchange, routingkey, temperatura);
	}

}