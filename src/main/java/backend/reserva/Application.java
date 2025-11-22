package backend.reserva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "NoWait - API de Reservas (MS2)",
                version = "1.0",
                description = "Microserviço de reservas de mesa e pedido antecipado para o app NoWait."
        )
)
public class Application {

    public static void main(String[] args) {
        // Mesmo padrão do MS1
        System.setProperty("server.servlet.context-path", "/nowait-api");
        SpringApplication.run(Application.class, args);
    }
}
