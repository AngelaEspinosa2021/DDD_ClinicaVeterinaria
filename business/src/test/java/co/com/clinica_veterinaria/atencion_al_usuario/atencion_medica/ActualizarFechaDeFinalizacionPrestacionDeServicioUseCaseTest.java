package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands.ActualizarFechaDeFinalizacionPrestacionDeServicio;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events.AtencionCreada;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events.FechaDeFinalizacionPrestacionDeServicioActualizada;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.services.ActualizarFechaDeFinalizacion;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.AtencionId;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.TipoDeAtencion;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.PrestacionDeServicioCreado;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Prioridad;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.business.generic.ServiceBuilder;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarFechaDeFinalizacionPrestacionDeServicioUseCaseTest {

    @InjectMocks
    private ActualizarFechaDeFinalizacionPrestacionDeServicioUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Mock
    private ActualizarFechaDeFinalizacion service;

    @Test
    void actualizarFechaDeAtencionPrestacionDeServiciosHappyPass(){
        var command = new ActualizarFechaDeFinalizacionPrestacionDeServicio(AtencionId.of("001"));

        when(repository.getEventsBy("001")).thenReturn(history());
        useCase.addRepository(repository);

        when(service.consultarPorAtencionId(any(AtencionId.class))).thenReturn(new Fecha(LocalDate.parse("2022-06-25")));
        useCase.addServiceBuilder(new ServiceBuilder().addService(service));

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (FechaDeFinalizacionPrestacionDeServicioActualizada)events.get(0);
        Assertions.assertEquals(LocalDate.parse("2022-06-25"), event.getFechaDeFinalizacion().value());
    }

    public List<DomainEvent> history(){
        var usuarioId = new UsuarioId("002");
        var fechaDeAtencion  = new Fecha(LocalDate.now());
        var tipodeAtencion = new TipoDeAtencion("URGENCIA");
        var event = new AtencionCreada(
                fechaDeAtencion,
                tipodeAtencion,
                usuarioId);
        event.setAggregateRootId("001");
        return List.of(event);
    }

}