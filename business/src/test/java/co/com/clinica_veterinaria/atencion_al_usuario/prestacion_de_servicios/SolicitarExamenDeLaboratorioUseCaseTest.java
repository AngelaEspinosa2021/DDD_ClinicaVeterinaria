package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicios;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands.SolicitarExamenDeLaboratorio;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.ExamenDeLaborarioSolicitado;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.EstadoExamen;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ExamenId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Nombre;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.events.HistoriaMedicaCreada;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.events.UsuarioCreado;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Estado;
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
class SolicitarExamenDeLaboratorioUseCaseTest {

    @InjectMocks
    private SolicitarExamenDeLaboratorioUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void solicitarExamenDeLaboratorioHappyPass(){
        var servicioId = ServicioId.of("001");
        var examenId = ExamenId.of("021");
        var nombre= new Nombre("Examen para Parvovirosis");
        var fechaDeRealizacion = new Fecha(LocalDate.parse("2022-05-21"));
        var estado = new EstadoExamen("EN ANALISIS");
        var command = new SolicitarExamenDeLaboratorio(servicioId,examenId,nombre,fechaDeRealizacion,estado);

        when(repository.getEventsBy("001")).thenReturn(history());

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getExamenId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ExamenDeLaborarioSolicitado)events.get(0);

        Assertions.assertEquals("021", event.getExamenId().value());
        Assertions.assertEquals("Examen para Parvovirosis", event.getNombre().value());
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