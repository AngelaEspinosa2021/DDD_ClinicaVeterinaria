package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicios;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands.ActualizarNombreDeMedicamento;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.ExamenDeLaborarioSolicitado;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.MedicamentoAgregado;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.NombreDeMedicamentoActualizado;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.MedicamentoId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Nombre;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
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
class ActualizarNombreDeMedicamentoUseCaseTest {
    @InjectMocks
    private ActualizarNombreDeMedicamentoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarNombreDeMedicamentoHappyPass(){
        var servicioId = ServicioId.of("001");
        var medicamentoId = MedicamentoId.of("025");
        var nombreMedicamento = new Nombre("Anticoagulante");
        var command = new ActualizarNombreDeMedicamento(servicioId,medicamentoId,nombreMedicamento);

        when(repository.getEventsBy("001")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getMedicamentoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (NombreDeMedicamentoActualizado)events.get(0);
        Assertions.assertEquals("Anticoagulante", event.getNombre().value());

    }
    public List<DomainEvent> history(){
        var fechaDeCreacion  = new Fecha(LocalDate.now());
        var event = new UsuarioCreado(
                fechaDeCreacion
        );
        var medicamentoId= MedicamentoId.of("025");
        var nombreMedicamento = new Nombre("Antibiotico");
        var fechaDeVencimiento = new Fecha(LocalDate.parse("2030-05-21"));
        var event2 = new MedicamentoAgregado(
                medicamentoId,
                nombreMedicamento,
                fechaDeVencimiento
        );
        event.setAggregateRootId("001");
        return List.of(event,event2);
    }


}