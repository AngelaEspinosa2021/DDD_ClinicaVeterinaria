package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicios;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands.AgregarObservacionDeHospitalizacion;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.HospitalizacionSolicitada;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.ObservacionDeHospitalizacionAgregada;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.PrestacionDeServicioCreado;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.EstadoDeHospitalizacion;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.HospitalizacionId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Prioridad;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
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
class AgregarObservacionDeHospitalizacionUseCaseTest {
    @InjectMocks
    private AgregarObservacionDeHospitalizacionUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarObservacionDeHospitalizacionHappyPass(){
        var servicioId = ServicioId.of("001");
        var hospitalizacionId = HospitalizacionId.of("012");
        var observacion = new Observacion("Se inserta observacion sobre la hospitalizacion.");
        var command = new AgregarObservacionDeHospitalizacion(servicioId,hospitalizacionId,observacion);

        when(repository.getEventsBy("001")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getServicioId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ObservacionDeHospitalizacionAgregada)events.get(0);
        Assertions.assertEquals("Se inserta observacion sobre la hospitalizacion.", event.getObservacion().value());
    }
    public List<DomainEvent> history(){
        var prioridad = new Prioridad("ALTA");
        var fechaDeSolicitud = new Fecha(LocalDate.parse("2022-05-20"));
        var event = new PrestacionDeServicioCreado(
                prioridad,
                fechaDeSolicitud
        );
        var hospitalizacionId= HospitalizacionId.of("012");
        var estadoDeHospitalizacion = new EstadoDeHospitalizacion("INGRESADO");
        var fechaDeIngreso = new Fecha(LocalDate.parse("2022-05-15"));
        var event2 = new HospitalizacionSolicitada(
                hospitalizacionId,
                estadoDeHospitalizacion,
                fechaDeIngreso
        );
        event.setAggregateRootId("001");
        return List.of(event, event2);
    }

}