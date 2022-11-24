package com.temp.receiver;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
@Service
@EnableScheduling
@Controller

public class RabbitmqReceiver {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	Set<User> users =  new LinkedHashSet<User>();




	@RabbitListener(queues = "drone")
	public void recebeMensagem(@Payload User user) {
		String mensagem = """
                ID Drone: %s
                Umidade: %s
                Temperatura: %s
                """.formatted(user.getId_drone(),
				user.getUmidade(),
				user.getTemperatura());

		System.out.println("Recebi a mensagem " + mensagem);
	}

	@Scheduled(cron ="0/10 * * * * ?")
	public void mandamsg(){
		System.out.println("Passou 10 segundos ");
	}

}