package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.AgregarObservacionAHistoriaMedica;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.events.HistoriaMedicaCreada;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.events.ObservacionDeHistoriaMedicaAgregada;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.events.UsuarioCreado;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.events.*;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.Descripcion;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.HistoriaMedicaId;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Observacion;
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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarObservacionAHistoriaMedicaUseCaseTest {

    @InjectMocks
    private AgregarObservacionAHistoriaMedicaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarObservacionAHistoriaMedicaHappyPass(){
        var usuarioId = UsuarioId.of("001");
        var historiaMedicaId = HistoriaMedicaId.of("010");
        var observacion = new Observacion("Logramos guardar una nueva observacion");
        var command = new AgregarObservacionAHistoriaMedica(usuarioId,historiaMedicaId,observacion);

        when(repository.getEventsBy("001")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getUsuarioId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ObservacionDeHistoriaMedicaAgregada)events.get(0);
        Assertions.assertEquals("Logramos guardar una nueva observacion", event.getObservacion().value());

    }

    public List<DomainEvent> history(){
        var fechaDeCreacion  = new Fecha(LocalDate.now());
        var event = new UsuarioCreado(
                fechaDeCreacion
        );
        var historiaMedicaId = HistoriaMedicaId.of("003");
        var fecha = new Fecha(LocalDate.parse("2022-05-20"));
        var descripcion = new Descripcion("Paciente ingresa por Urgencias por deshidratacion");
        var event2 = new HistoriaMedicaCreada(
                historiaMedicaId,
                fecha,
                descripcion
        );
        event.setAggregateRootId("001");
        return List.of(event,event2);
    }

}