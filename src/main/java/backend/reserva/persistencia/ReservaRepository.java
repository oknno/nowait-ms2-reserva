package backend.reserva.persistencia;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import backend.reserva.entidades.Reserva;

@EnableScan
public interface ReservaRepository extends CrudRepository<Reserva, String> {

    List<Reserva> findByClienteId(String clienteId);

    List<Reserva> findByRestauranteId(String restauranteId);
}
