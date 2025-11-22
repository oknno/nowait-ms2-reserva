package backend.reserva.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import backend.reserva.entidades.Reserva;
import backend.reserva.service.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservaController.class);

    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Reserva> criarReserva(@Valid @RequestBody Reserva reserva) {
        LOGGER.info("Criando reserva para cliente {} no restaurante {}", reserva.getClienteId(), reserva.getRestauranteId());
        Reserva criada = service.criarReserva(reserva);
        return ResponseEntity.ok(criada);
    }

    @GetMapping("/{codigoReserva}")
    public ResponseEntity<Reserva> buscarPorCodigo(@PathVariable String codigoReserva) {
        Optional<Reserva> opt = service.buscarPorCodigo(codigoReserva);
        return opt.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> listarPorClienteOuRestaurante(
            @RequestParam(required = false) String clienteId,
            @RequestParam(required = false) String restauranteId) {

        if (clienteId != null) {
            return ResponseEntity.ok(service.listarPorCliente(clienteId));
        } else if (restauranteId != null) {
            return ResponseEntity.ok(service.listarPorRestaurante(restauranteId));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{codigoReserva}/cancelar")
    public ResponseEntity<Void> cancelar(@PathVariable String codigoReserva) {
        service.cancelarReserva(codigoReserva);
        return ResponseEntity.noContent().build();
    }
}
