package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.ActualizarNombreCompletoDePaciente;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarNombreCompletoDePacienteUseCase extends UseCase<RequestCommand<ActualizarNombreCompletoDePaciente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreCompletoDePaciente> actualizarNombreCompletoDePacienteRequestCommand) {
        var command = actualizarNombreCompletoDePacienteRequestCommand.getCommand();
        var usuario = Usuario.from(command.getUsuarioId(), repository().getEventsBy(command.getUsuarioId().value()));
        usuario.actualizarNombreCompletoDePaciente(command.getPacienteId(), command.getNombreCompleto());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
