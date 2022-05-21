package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.ActualizarNombreCompletoDePaciente;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.events.NombreCompletoPacienteActualizado;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.events.PacienteCreado;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.events.UsuarioCreado;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.PacienteId;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
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
class ActualizarNombreCompletoDePacienteUseCaseTest {

    @InjectMocks
    private ActualizarNombreCompletoDePacienteUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarNombreCompletoDePacienteHappyPass(){
        var usuarioId = UsuarioId.of("001");
        var pacienteId = PacienteId.of("10");
        var nombre = new NombreCompleto("Peppa");
        var command = new ActualizarNombreCompletoDePaciente(usuarioId,pacienteId,nombre);

        when(repository.getEventsBy("001")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getUsuarioId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (NombreCompletoPacienteActualizado)events.get(0);
        Assertions.assertEquals("Peppa",event.getNombreCompleto().value());
    }

    public List<DomainEvent> history(){
        var fechaDeCreacion  = new Fecha(LocalDate.now());
        var event = new UsuarioCreado(
                fechaDeCreacion
        );
        var pacienteId = PacienteId.of("10");
        var nombre = new NombreCompleto("Sammy");
        var fechaDeNacimiento = new Fecha(LocalDate.now());
        var event2 = new PacienteCreado(
                pacienteId,
                nombre,
                fechaDeNacimiento
        );
        event.setAggregateRootId("001");
        return List.of(event,event2);
    }


}