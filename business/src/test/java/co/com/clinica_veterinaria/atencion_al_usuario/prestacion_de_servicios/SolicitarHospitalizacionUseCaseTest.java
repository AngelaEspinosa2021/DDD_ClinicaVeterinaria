package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicios;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands.SolicitarHospitalizacion;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.HospitalizacionSolicitada;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.PrestacionDeServicioCreado;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.EstadoDeHospitalizacion;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.HospitalizacionId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Prioridad;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.events.HistoriaMedicaCreada;
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
class SolicitarHospitalizacionUseCaseTest{

    @InjectMocks
    private SolicitarHospitalizacionUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void solicitarHospitalizacionHappyPass(){
        var servicioId = ServicioId.of("001");
        var hospitalizacionId = HospitalizacionId.of("010");
        var estadoHospitalizacion = new EstadoDeHospitalizacion("INGRESADO");
        var fechaDeIngreso = new Fecha(LocalDate.parse("2022-05-21"));
        var command = new SolicitarHospitalizacion(servicioId,hospitalizacionId,estadoHospitalizacion,fechaDeIngreso);

        when(repository.getEventsBy("001")).thenReturn(history());

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getServicioId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (HospitalizacionSolicitada)events.get(0);
        Assertions.assertEquals("010",event.getHospitalizacionId().value());
        Assertions.assertEquals(LocalDate.parse("2022-05-21"), event.getFechaDeIngreso().value());
    }

    public List<DomainEvent> history(){
        Prioridad prioridad = new Prioridad("ALTA");
        Fecha fechaDeSolicitud = new Fecha(LocalDate.parse("2022-05-20"));
        var event = new PrestacionDeServicioCreado(
                prioridad,
                fechaDeSolicitud
        );
        event.setAggregateRootId("001");
        return List.of(event);
    }

}