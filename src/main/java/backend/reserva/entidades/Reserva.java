package backend.reserva.entidades;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Reserva")
public class Reserva {

    private String codigoReserva;     // chave principal
    private String clienteId;
    private String restauranteId;
    private String horarioReserva;    // ex: "2025-11-22T19:30"
    private String status;            // PENDENTE, CONFIRMADA, CANCELADA
    private List<String> itens;       // códigos dos itens do cardápio
    private String observacoes;

    public Reserva() {
    }

    public Reserva(String codigoReserva,
                   String clienteId,
                   String restauranteId,
                   String horarioReserva,
                   String status,
                   List<String> itens,
                   String observacoes) {
        this.codigoReserva = codigoReserva;
        this.clienteId = clienteId;
        this.restauranteId = restauranteId;
        this.horarioReserva = horarioReserva;
        this.status = status;
        this.itens = itens;
        this.observacoes = observacoes;
    }

    @DynamoDBHashKey(attributeName = "CodigoReserva")
    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    @DynamoDBAttribute(attributeName = "ClienteId")
    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    @DynamoDBAttribute(attributeName = "RestauranteId")
    public String getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(String restauranteId) {
        this.restauranteId = restauranteId;
    }

    @DynamoDBAttribute(attributeName = "HorarioReserva")
    public String getHorarioReserva() {
        return horarioReserva;
    }

    public void setHorarioReserva(String horarioReserva) {
        this.horarioReserva = horarioReserva;
    }

    @DynamoDBAttribute(attributeName = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @DynamoDBAttribute(attributeName = "Itens")
    public List<String> getItens() {
        return itens;
    }

    public void setItens(List<String> itens) {
        this.itens = itens;
    }

    @DynamoDBAttribute(attributeName = "Observacoes")
    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigoReserva='" + codigoReserva + '\'' +
                ", clienteId='" + clienteId + '\'' +
                ", restauranteId='" + restauranteId + '\'' +
                ", horarioReserva='" + horarioReserva + '\'' +
                ", status='" + status + '\'' +
                ", itens=" + itens +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}
