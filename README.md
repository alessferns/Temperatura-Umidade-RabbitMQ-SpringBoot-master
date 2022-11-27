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

Há verificações se os inputs estão preenchidos corretamente, conforme abaixo:

![image](https://user-images.githubusercontent.com/100177921/204109196-421bc05b-20f6-45a3-8360-68987a835032.png)

Valores que não estão dentro dos intervalos não serão permitidos:

Exemplo - Tentativa de inserir manualmente uma temperatura >=40 graus
![image](https://user-images.githubusercontent.com/100177921/204109229-8018b76c-1619-4aa8-85a3-f3cd5e3be645.png)


Exemplo - Inserção de dados:

![image](https://user-images.githubusercontent.com/100177921/204111522-010a8fb2-eef0-4ed0-b6c0-f6942834276d.png)

Envio de mensagens a cada 10 segundos:

![image](https://user-images.githubusercontent.com/100177921/204111542-03db32c7-405a-41c7-af19-f84208363d74.png)

Após 1 minuto, temos o alerta do drone 5:

![image](https://user-images.githubusercontent.com/100177921/204111555-e4d0aee1-e300-411c-bd45-ae5d7a931329.png)

Para receber o alerta via email, você deverá preencher o application.properties da pasta CONSUMIDOR com email e senha:

![image](https://user-images.githubusercontent.com/100177921/204114847-251d6b86-393a-44fe-ab59-e12f34c55281.png)

Também será preciso alterar o email no EmailConfig.java:

![image](https://user-images.githubusercontent.com/100177921/204116066-cd1b6e60-2b62-4c45-81e8-c0cd0f9bba53.png)

No EmailController é possível mudar o destinatário:

![image](https://user-images.githubusercontent.com/100177921/204116513-be55b5c9-50f8-46c4-877c-7fce83a3589c.png)

Aqui temos o email recebido:

![image](https://user-images.githubusercontent.com/100177921/204116430-10c99d51-8ccc-4865-967d-e37f9f74e8b8.png)

Os drones 1, 2 e 3 são aleatórios, com finalidade de cumprir o requisito de vários drones mandando mensagens. 

O drone 5 foi exatamente o que foi colocado nos inputs, gerando um alerta e enviando os inputs por email. 

Não há uma ordem para o id_drone (não é preciso incluir o drone 4 após o 3, tanto faz. Por isso o exemplo foi com o drone 5). 

Em caso de dúvidas, fineza, entrar em contato. 
alessferns@gmail.com

