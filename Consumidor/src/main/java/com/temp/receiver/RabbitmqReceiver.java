package com.temp.receiver;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Iterator;
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

	@Autowired
	EmailController email;
	public String encontrou = "N";

	ArrayList<UserDados> listaDrones =  new ArrayList<UserDados>();


	@RabbitListener(queues = "drone")
	public void recebeMensagem(@Payload User user) {

		UserDados drone = new UserDados();
		if ((user.umidade <= 15) || (user.temperatura>=35 || user.temperatura<=0)){
			drone.id_drone= user.id_drone;
			drone.addLatitude(user.latitude);
			drone.addLongitude(user.longitude);
			drone.addTemperatura(user.temperatura);
			drone.addUmidade(user.umidade);
			drone.setMyCheckbox(user.myCheckbox);
			drone.setEnviaEmail("S");

		}else{
			drone.id_drone= user.id_drone;
			drone.addLatitude(user.latitude);
			drone.addLongitude(user.longitude);
			drone.addTemperatura(user.temperatura);
			drone.addUmidade(user.umidade);
			drone.setMyCheckbox(user.myCheckbox);
			drone.setEnviaEmail("N");
		}

		if (listaDrones.size() == 0){
			listaDrones.add(drone);
		}else{
			encontrou = "N";
			listaDrones.forEach(elemento ->{
				if(elemento.id_drone == drone.id_drone){
					elemento.addUmidade(user.umidade);
					elemento.addTemperatura(user.temperatura);
					elemento.addLongitude(user.longitude);
					elemento.addLatitude(user.latitude);
					elemento.myCheckbox = user.myCheckbox;
					if (drone.enviaEmail.equals("S")){
						elemento.enviaEmail ="S";
					}
					encontrou = "S";
				}
			});
			if (encontrou.equals("N")){
				listaDrones.add(drone);
			}



		}
	}

	@Scheduled(cron ="0/60 * * * * ?")
	public void mandamsg(){

		String mensagem ="";
		System.out.println("Passou 60 segundos ");
		for(UserDados elemento : this.listaDrones){
			if(elemento.enviaEmail.equals("S")){

				//System.out.println(elemento.texto());
				mensagem = mensagem + elemento.texto();

				//elemento.imprime();
			}

		}
		if (!(mensagem.isEmpty() || mensagem.isBlank())){
			email.setTexto(mensagem);
			email.sendMail();

		}
		listaDrones.clear();
	}

}