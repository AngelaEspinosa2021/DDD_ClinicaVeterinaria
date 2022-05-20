package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.CrearUsuario;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearUsuarioUseCase extends UseCase<RequestCommand<CrearUsuario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearUsuario> crearUsuarioRequestCommand) {
        var command = crearUsuarioRequestCommand.getCommand();
        var usuario = new Usuario(command.getUsuarioId(), command.getFechaDeCreacion());

        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
