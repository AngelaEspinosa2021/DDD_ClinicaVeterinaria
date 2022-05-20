package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.ActualizarFechaDeCreacion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarFechaDeCreacionUseCase extends UseCase<RequestCommand<ActualizarFechaDeCreacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarFechaDeCreacion> actualizarFechaDeCreacionRequestCommand) {
        var command = actualizarFechaDeCreacionRequestCommand.getCommand();
        var usuario = Usuario.from(command.getUsuarioId(), repository().getEventsBy(command.getUsuarioId().value()));
        usuario.actualizarFechaDeCreacion(command.getFechaDeCreacion());
        emit().onResponse(new ResponseEvents((usuario.getUncommittedChanges())));
    }
}
