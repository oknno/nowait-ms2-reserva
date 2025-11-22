📅 MS2 – Reserva
1️⃣ JUnit – Testes Automatizados
▶️ Rodar testes
mvn test

✔️ Resultado esperado

Testes OK

Mensagem BUILD SUCCESS

2️⃣ Swagger – Documentação da API
▶️ Rodar aplicação
mvn spring-boot:run

▶️ Abrir no navegador
http://localhost:8080/nowait-api/swagger-ui/index.html

✔️ Verificar

Endpoints /reservas

Formulário para criar reservas

3️⃣ Postman – Testes Manuais
▶️ Rodar aplicação
mvn spring-boot:run

▶️ Criar requisições

POST http://localhost:8080/nowait-api/reservas

GET http://localhost:8080/nowait-api/reservas/{codigo}

GET http://localhost:8080/nowait-api/reservas?clienteId=CLI-123

PATCH http://localhost:8080/nowait-api/reservas/{codigo}/cancelar

✔️ Verificar

JSON retornado corretamente

Código da reserva

Status atualizado

4️⃣ FatJar – Geração
▶️ Gerar JAR
mvn clean package

📁 Arquivo gerado
target/nowait-ms2-reserva-1.0.0-SNAPSHOT.jar

▶️ Executar JAR
java -jar target/nowait-ms2-reserva-1.0.0-SNAPSHOT.jar

5️⃣ Docker – Containerização
▶️ Build da imagem
docker build -t nowait-ms2-reserva:1.0.0 .

▶️ Rodar container (8081 local)
docker run --rm -p 8081:8080 ^
-v "C:/Users/okn/Documents/noWait/Credenciais/application.properties:/config/application.properties" ^
-e SPRING_CONFIG_ADDITIONAL_LOCATION="file:/config/application.properties" ^
nowait-ms2-reserva:1.0.0

6️⃣ ECR – Publicação da Imagem
▶️ Taguear imagem
docker tag nowait-ms2-reserva:1.0.0 <ID>.dkr.ecr.<REGIAO>.amazonaws.com/nowait-ms2-reserva:1.0.0

▶️ Enviar imagem
docker push <ID>.dkr.ecr.<REGIAO>.amazonaws.com/nowait-ms2-reserva:1.0.0

7️⃣ ECS – Task Definition

Configurar:

Imagem: nowait-ms2-reserva:1.0.0

Porta: 8080

8️⃣ ECS – Service

Criar serviço usando:

A Task Definition do MS2

Desired count = 1

9️⃣ Load Balancer
▶️ Acessar via ALB
http://<DNS-ALB>/nowait-api/reservas
