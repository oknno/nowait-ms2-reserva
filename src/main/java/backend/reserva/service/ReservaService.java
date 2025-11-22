package backend.reserva.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import backend.reserva.entidades.Reserva;
import backend.reserva.persistencia.ReservaRepository;

@Service
public class ReservaService {

    private final ReservaRepository repository;

    public ReservaService(ReservaRepository repository) {
        this.repository = repository;
    }

    public Reserva criarReserva(Reserva reserva) {
        if (reserva.getCodigoReserva() == null || reserva.getCodigoReserva().isEmpty()) {
            reserva.setCodigoReserva(gerarCodigoReserva());
        }
        if (reserva.getStatus() == null || reserva.getStatus().isEmpty()) {
            reserva.setStatus("PENDENTE");
        }
        return repository.save(reserva);
    }

    public Optional<Reserva> buscarPorCodigo(String codigoReserva) {
        return repository.findById(codigoReserva);
    }

    public List<Reserva> listarPorCliente(String clienteId) {
        return repository.findByClienteId(clienteId);
    }

    public List<Reserva> listarPorRestaurante(String restauranteId) {
        return repository.findByRestauranteId(restauranteId);
    }

    public void cancelarReserva(String codigoReserva) {
        Optional<Reserva> opt = repository.findById(codigoReserva);
        if (opt.isPresent()) {
            Reserva r = opt.get();
            r.setStatus("CANCELADA");
            repository.save(r);
        }
    }

    private String gerarCodigoReserva() {
        return "RES-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
