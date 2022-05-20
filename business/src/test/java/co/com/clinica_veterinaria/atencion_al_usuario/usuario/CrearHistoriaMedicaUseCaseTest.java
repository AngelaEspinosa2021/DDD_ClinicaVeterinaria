package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.CrearHistoriaMedica;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.events.DueñoCreado;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.events.HistoriaMedicaCreada;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.events.UsuarioCreado;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.Descripcion;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.HistoriaMedicaId;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
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
class CrearHistoriaMedicaUseCaseTest{

    @InjectMocks
    private CrearHistoriaMedicaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearHistoriaMedica(){
        var usuarioId= UsuarioId.of("001");
        var historiaMedicaId = HistoriaMedicaId.of("012");
        var fecha = new Fecha(LocalDate.now());
        var descripcion = new Descripcion("Paciente ingresa por Urgencias por deshidratacion");
        var command = new CrearHistoriaMedica(usuarioId,historiaMedicaId,fecha,descripcion);

        when(repository.getEventsBy("001")).thenReturn(history());

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getUsuarioId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (HistoriaMedicaCreada)events.get(0);
        Assertions.assertEquals("012", event.getHistoriaMedicaId().value());
        Assertions.assertEquals(LocalDate.parse("2022-05-20"), event.getFecha().value());
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