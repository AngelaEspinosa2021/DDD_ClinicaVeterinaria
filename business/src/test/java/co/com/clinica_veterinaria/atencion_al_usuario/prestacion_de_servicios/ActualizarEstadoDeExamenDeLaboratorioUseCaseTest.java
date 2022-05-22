package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicios;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands.ActualizarEstadoDeExamenDeLaboratorio;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.EstadoDeExamenDeLaboratorioActualizado;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.ExamenDeLaborarioSolicitado;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.MedicamentoAgregado;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.NombreDeMedicamentoActualizado;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.*;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.events.UsuarioCreado;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarEstadoDeExamenDeLaboratorioUseCaseTest {
    @InjectMocks
    private ActualizarEstadoDeExamenDeLaboratorioUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarEstadoDeExamenDeLaboratorioHappyPass(){
        var servicioId = ServicioId.of("001");
        var examenId = ExamenId.of("035");
        var estadoExamen = new EstadoExamen("ENTREGADO");
        var command = new ActualizarEstadoDeExamenDeLaboratorio(servicioId,examenId,estadoExamen);

        when(repository.getEventsBy("001")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getExamenId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (EstadoDeExamenDeLaboratorioActualizado)events.get(0);
        Assertions.assertEquals("ENTREGADO", event.getEstadoExamen().value());
    }

    public List<DomainEvent> history(){
        var fechaDeCreacion  = new Fecha(LocalDate.now());
        var event = new UsuarioCreado(
                fechaDeCreacion
        );
        var examenId= ExamenId.of("035");
        var nombreExamen = new Nombre("Parvovirosis");
        var estadoExamen = new EstadoExamen("Pendiente entrega resultados");
        var event2 = new ExamenDeLaborarioSolicitado(
                examenId,
                nombreExamen,
                estadoExamen
        );
        event.setAggregateRootId("001");
        return List.of(event,event2);
    }

}