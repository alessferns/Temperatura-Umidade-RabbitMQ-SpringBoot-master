# liveTemperature-RabbitMQ-SpringBoot

Trata-se de uma aplicação web que coleta dados via sensores de temperatura e umidade.

A cada 10 segundos são enviados para message broker os dados de temperatura e umidade capturado naquele instante.

O microsserviço envia um alerta quando em 1 minuto a Temperatura (>= 35 ou <=0) ou (Umidade <= 15%).

Você precisará instalar o RabbitMQ.

Após a instalação, é possível acessá-lo pelo link: http://localhost:15672/

Preferencialmente, utilize o IntelliJ IDEA para executar o projeto. 

Para gerar as mensagens, execute o RabbitmqApplication.java da pasta DRONE. 

Ao executar, uma exchange de nome "drone.ex" será criada:
![image](https://user-images.githubusercontent.com/100177921/204110996-a69a5aae-6861-443e-878c-90866d35a03b.png)

Também será criada uma queue de nome "drone":
![image](https://user-images.githubusercontent.com/100177921/204111007-9b22da3a-1760-44b6-a9de-e0874858297f.png)

Para acessar a dashboard, entre no link: http://localhost:9001/dashboard

Para ler as mensagens, execute o RabbitmqApplication.java da pasta CONSUMIDOR. 

Essa será a aparência da página:

![image](https://user-images.githubusercontent.com/100177921/204109015-ac24d462-5d7e-447e-9fa0-c2b9634b41bf.png)

Temos os seguintes inputs:

id_drone (Identificador do Drone); Latitude (-90º até +90º); Longitude (-180º até +180º); Temperatura (-25º até 40º); Umidade (0% - 100%); Ativar rastreamento (ligada-desligada).

Há verificações se os inputs estão inseridos corretamente, conforme abaixo:

![image](https://user-images.githubusercontent.com/100177921/204109196-421bc05b-20f6-45a3-8360-68987a835032.png)

Valores que não estão dentro dos intervalos não serão permitidos:

Exemplo - Tentativa de inserir manualmente uma temperatura >=40 graus
![image](https://user-images.githubusercontent.com/100177921/204109229-8018b76c-1619-4aa8-85a3-f3cd5e3be645.png)

Em caso de dúvidas, fineza, entrar em contato. 
alessferns@gmail.com

