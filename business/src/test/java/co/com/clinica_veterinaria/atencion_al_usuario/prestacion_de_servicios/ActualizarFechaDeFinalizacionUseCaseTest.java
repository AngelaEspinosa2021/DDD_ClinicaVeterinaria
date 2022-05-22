package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicios;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events.FechaDeFinalizacionPrestacionDeServicioActualizada;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.FechaDeFinalizacionActualizada;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.PrestacionDeServicioCreado;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Prioridad;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarFechaDeFinalizacionUseCaseTest {

    @InjectMocks
    private ActualizarFechaDeFinalizacionUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarFechaDeFinalizacionHappyPass(){
        ServicioId servicioId = ServicioId.of("002");
        Fecha fechaDeFinalizacion = new Fecha(LocalDate.parse("2022-06-17"));
        var event = new FechaDeFinalizacionPrestacionDeServicioActualizada(servicioId,fechaDeFinalizacion);

        when(repository.getEventsBy("002")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(servicioId.value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var fechaFinActualizada = (FechaDeFinalizacionActualizada)events.get(0);
        Assertions.assertEquals(LocalDate.parse("2022-06-17"), fechaFinActualizada.getFechaDeFinalizacion().value());
        Mockito.verify(repository).getEventsBy(servicioId.value());
    }

    public List<DomainEvent> history(){
        Prioridad prioridad = new Prioridad("ALTA");
        Fecha fechaDeSolicitud = new Fecha(LocalDate.parse("2022-05-20"));
        var event = new PrestacionDeServicioCreado(
                prioridad,
                fechaDeSolicitud
        );
        event.setAggregateRootId("002");
        return List.of(event);
    }



}