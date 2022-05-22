package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicios;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.PrestacionDeServicio;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands.AgregarMedicamento;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.ExamenDeLaborarioSolicitado;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.MedicamentoAgregado;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.MedicamentoId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Nombre;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.events.UsuarioCreado;
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
class AgregarMedicamentoUseCaseTest {
    @InjectMocks
    private AgregarMedicamentoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarMedicamentoHappyPass(){
        var servicioId = ServicioId.of("001");
        var medicamentoId = MedicamentoId.of("015");
        var nombre = new Nombre("Antibiotico");
        var fechaDeVencimiento = new Fecha(LocalDate.parse("2030-05-21"));
        var command = new AgregarMedicamento(servicioId,medicamentoId,nombre,fechaDeVencimiento);

        when(repository.getEventsBy("001")).thenReturn(history());

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getMedicamentoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (MedicamentoAgregado)events.get(0);
        Assertions.assertEquals("015", event.getMedicamentoId().value());
        Assertions.assertEquals("Antibiotico", event.getNombre().value());
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