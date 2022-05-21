package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events.AtencionFinalizada;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.events.ProximaCitaAgendada;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.events.UsuarioCreado;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgendarProximaCitaUseCaseTest {

    @InjectMocks
    private AgendarProximaCitaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agendarProximaCitaHappyPass(){
        UsuarioId usuarioId = UsuarioId.of("001");
        Fecha proximaCita = new Fecha(LocalDate.parse("2022-06-17"));
        var event = new AtencionFinalizada(usuarioId,proximaCita);

        when(repository.getEventsBy("001")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(usuarioId.value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var proximaCitaAgendada = (ProximaCitaAgendada)events.get(0);
        Assertions.assertEquals("2022-06-17",proximaCitaAgendada.getProximaCita().value());
        Mockito.verify(repository).getEventsBy(usuarioId.value());
    }

    public List<DomainEvent> history(){
        var fechaDeCreacion  = new Fecha(LocalDate.now());
        var event = new UsuarioCreado(
                fechaDeCreacion
        );
        event.setAggregateRootId("001");
        return List.of(event);
    }

}