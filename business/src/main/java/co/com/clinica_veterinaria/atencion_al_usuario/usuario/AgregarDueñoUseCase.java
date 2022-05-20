package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.AgregarDueño;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarDueñoUseCase extends UseCase<RequestCommand<AgregarDueño>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarDueño> agregarDueñoRequestCommand) {
        var command = agregarDueñoRequestCommand.getCommand();
        var usuario = Usuario.from(command.getUsuarioId(), repository().getEventsBy(command.getUsuarioId().value()));
        usuario.agregarDueño(command.getDueñoId(),command.getNombreCompleto(), command.getDatosDeContacto(), command.getFechaDeNacimiento());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
