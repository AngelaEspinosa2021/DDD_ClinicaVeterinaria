package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.ActualizarNombreCompletoDeDueño;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.events.DueñoCreado;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.events.NombreCompletoDeDueñoActualizado;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.events.UsuarioCreado;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.DueñoId;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.DatosDeContacto;
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
class ActualizarNombreCompletoDeDueñoUseCaseTest {

    @InjectMocks
    private ActualizarNombreCompletoDeDueñoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarNombreCompletoDePacienteHappyPass(){
        var usuarioId = UsuarioId.of("001");
        var dueñoId = DueñoId.of("010");
        var nombre = new NombreCompleto("Angela Espinosa");
        var command = new ActualizarNombreCompletoDeDueño(usuarioId,dueñoId,nombre);

        when(repository.getEventsBy("001")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getUsuarioId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (NombreCompletoDeDueñoActualizado)events.get(0);
        Assertions.assertEquals("Angela Espinosa",event.getNombreCompleto().value());
    }

    public List<DomainEvent> history(){
        var fechaDeCreacion  = new Fecha(LocalDate.now());
        var event = new UsuarioCreado(
                fechaDeCreacion
        );
        var dueñoId = DueñoId.of("010");
        var nombre = new NombreCompleto("Pepito Perez");
        var datosDeContacto = new DatosDeContacto("cra 28","campin","789456","correo@correo.com");
        var fechaDeNacimiento = new Fecha(LocalDate.now());
        var event2 = new DueñoCreado(
                dueñoId,
                nombre,
                datosDeContacto,
                fechaDeNacimiento
        );
        event.setAggregateRootId("001");
        return List.of(event,event2);
    }

}