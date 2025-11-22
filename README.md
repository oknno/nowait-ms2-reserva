# ✅ **README – MS2 (Reserva)**

**Copie e cole inteiro no projeto MS2.**

````markdown
# NoWait – MS2 Reserva

## 1. JUnit

### Rodar testes

```bash
mvn test
Resultado esperado
Todos os testes OK

Mensagem BUILD SUCCESS

2. Swagger
Rodar aplicação
bash
Copiar código
mvn spring-boot:run
Abrir no navegador
bash
Copiar código
http://localhost:8080/nowait-api/swagger-ui/index.html
O que visualizar
Endpoints /reservas

Campo para enviar JSON e criar reserva

3. Postman
Rodar aplicação
bash
Copiar código
mvn spring-boot:run
Criar requisições
POST http://localhost:8080/nowait-api/reservas

GET http://localhost:8080/nowait-api/reservas/{codigo}

GET http://localhost:8080/nowait-api/reservas?clienteId=CLI-123

PATCH http://localhost:8080/nowait-api/reservas/{codigo}/cancelar

Enviar e visualizar JSON
4. FatJar
Gerar JAR
bash
Copiar código
mvn clean package
Arquivo gerado
pgsql
Copiar código
target/nowait-ms2-reserva-1.0.0-SNAPSHOT.jar
Rodar JAR
bash
Copiar código
java -jar target/nowait-ms2-reserva-1.0.0-SNAPSHOT.jar
5. Docker
Buildar imagem
bash
Copiar código
docker build -t nowait-ms2-reserva:1.0.0 .
Rodar container (porta 8081 local)
bash
Copiar código
docker run --rm -p 8081:8080 ^
  -v "C:/Users/okn/Documents/noWait/Credenciais/application.properties:/config/application.properties" ^
  -e SPRING_CONFIG_ADDITIONAL_LOCATION="file:/config/application.properties" ^
  nowait-ms2-reserva:1.0.0
6. Imagem ECR
Taguear imagem
bash
Copiar código
docker tag nowait-ms2-reserva:1.0.0 <ID>.dkr.ecr.<REGIAO>.amazonaws.com/nowait-ms2-reserva:1.0.0
Enviar imagem
bash
Copiar código
docker push <ID>.dkr.ecr.<REGIAO>.amazonaws.com/nowait-ms2-reserva:1.0.0
7. Tarefa ECS
Criar Task Definition
Imagem: nowait-ms2-reserva:1.0.0

Porta container: 8080

8. Serviço ECS
Criar serviço
Usar Task Definition do MS2

Desired count = 1

9. Load Balancer
Acessar via ALB
perl
Copiar código
http://<DNS-ALB>/nowait-api/reservas
```
````
