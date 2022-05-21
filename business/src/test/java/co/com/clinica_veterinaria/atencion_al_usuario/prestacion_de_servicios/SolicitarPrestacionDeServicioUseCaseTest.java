package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicios;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.PrestacionDeServicio;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands.SolicitarPrestacionDeServicio;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.PrestacionDeServicioCreado;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Prioridad;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SolicitarPrestacionDeServicioUseCaseTest {

    private SolicitarPrestacionDeServicioUseCase useCase;

    @BeforeEach
    public void setup(){ useCase=new SolicitarPrestacionDeServicioUseCase();}

    @Test
    public void solicitarPrestacionDeServicioHappyPass(){
        ServicioId servicioId = ServicioId.of("001");
        Prioridad prioridad = new Prioridad(Prioridad.Prioridades.ALTA);
        Fecha fechaDeSolicitud = new Fecha(LocalDate.parse("2022-05-20"));
        var command = new SolicitarPrestacionDeServicio(servicioId,prioridad,fechaDeSolicitud);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (PrestacionDeServicioCreado)events.get(0);
        Assertions.assertEquals("001",event.aggregateRootId());
        Assertions.assertEquals(LocalDate.parse("2022-05-20"), event.getFechaDeSolicitud().value());
    }

}