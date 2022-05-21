package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.AgregarPaciente;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarPacienteUseCase extends UseCase<RequestCommand<AgregarPaciente>, ResponseEvents>{
    @Override
    public void executeUseCase(RequestCommand<AgregarPaciente> agregarPacienteRequestCommand) {
        var command = agregarPacienteRequestCommand.getCommand();
        var usuario = Usuario.from(command.getUsuarioId(), repository().getEventsBy(command.getUsuarioId().value()));
        usuario.agregarPaciente(command.getPacienteId(),command.getNombreCompleto(), command.getFechaDeNacimiento());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
