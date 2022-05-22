package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.CrearUsuario;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.events.UsuarioCreado;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class CrearUsuarioUseCaseTest {

    private CrearUsuarioUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase=new CrearUsuarioUseCase();
    }

    @Test
    public void crearUsuarioHappyPass(){
        //arrange
        UsuarioId usuarioId= UsuarioId.of("001");
        Fecha fechaDeCreacion = new Fecha(LocalDate.now());
        var command = new CrearUsuario(usuarioId, fechaDeCreacion);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var usuarioCreado = (UsuarioCreado)events.get(0);
        Assertions.assertEquals("001", usuarioCreado.aggregateRootId());
        Assertions.assertEquals(LocalDate.parse("2022-05-20"), usuarioCreado.getFechaDeCreacion().value());

    }

}