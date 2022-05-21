package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.ActualizarNombreCompletoDeDueño;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarNombreCompletoDeDueñoUseCase extends UseCase<RequestCommand<ActualizarNombreCompletoDeDueño>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreCompletoDeDueño> actualizarNombreCompletoDeDueñoRequestCommand) {
        var command = actualizarNombreCompletoDeDueñoRequestCommand.getCommand();
        var usuario = Usuario.from(command.getUsuarioId(), repository().getEventsBy(command.getUsuarioId().value()));
        usuario.actualizarNombreCompletoDeDueño(command.getDueñoId(), command.getNombreCompleto());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
