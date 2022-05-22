package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands.CrearAtencion;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events.AtencionCreada;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.AtencionId;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.TipoDeAtencion;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.CrearUsuarioUseCase;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.events.UsuarioCreado;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Estado;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CrearAtencionUseCaseTest {

    private CrearAtencionUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase=new CrearAtencionUseCase();
    }

    @Test
    public void crearAtencionMedicaHappyPass(){
        AtencionId atencionId = AtencionId.of("001");
        UsuarioId usuarioId = UsuarioId.of("002");
        Fecha fechaDeAtencion = new Fecha(LocalDate.parse("2022-05-22"));
        TipoDeAtencion tipodeAtencion = new TipoDeAtencion("URGENCIA");
        Estado estado = new Estado(Estado.Estados.POR_INICIAR);
        var command = new CrearAtencion(atencionId,fechaDeAtencion,tipodeAtencion,estado,usuarioId);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var atencionCreada = (AtencionCreada)events.get(0);
        Assertions.assertEquals("001", atencionCreada.aggregateRootId());
        Assertions.assertEquals(LocalDate.parse("2022-05-22"), atencionCreada.getFechaDeAtencion().value());
    }

}