package backend.reserva.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import backend.reserva.entidades.Reserva;
import backend.reserva.persistencia.ReservaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "file:C:/Users/okn/Documents/noWait/Credenciais/application.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReservaTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservaTest.class);

    @Autowired
    private ReservaRepository repository;

    @Test
    public void teste1Criacao() {
        LOGGER.info("Criando reservas de teste...");

        Reserva r1 = new Reserva(
                "RES-TESTE-1",
                "CLI-123",
                "REST-001",
                "2025-11-22T19:30",
                "PENDENTE",
                Arrays.asList("PZ001", "REF001"),
                "Mesa perto da janela."
        );

        Reserva r2 = new Reserva(
                "RES-TESTE-2",
                "CLI-123",
                "REST-001",
                "2025-11-22T20:00",
                "PENDENTE",
                Arrays.asList("PZ001"),
                "Sem cebola."
        );

        repository.save(r1);
        repository.save(r2);

        List<Reserva> byCliente = repository.findByClienteId("CLI-123");
        assertNotNull(byCliente);
        assertEquals(2, byCliente.size());
    }

    @Test
    public void teste2Exclusao() {
        LOGGER.info("Excluindo reservas de teste...");

        Iterable<Reserva> todas = repository.findAll();
        assertNotNull(todas.iterator());

        for (Reserva r : todas) {
            if (r.getCodigoReserva() != null && r.getCodigoReserva().startsWith("RES-TESTE")) {
                LOGGER.info("Apagando {}", r);
                repository.delete(r);
            }
        }

        List<Reserva> byCliente = repository.findByClienteId("CLI-123");
        assertEquals(0, byCliente.size());
    }
}
