package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.CrearHistoriaMedica;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearHistoriaMedicaUseCase extends UseCase<RequestCommand<CrearHistoriaMedica>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearHistoriaMedica> crearHistoriaMedicaRequestCommand) {
        var command = crearHistoriaMedicaRequestCommand.getCommand();
        var usuario = Usuario.from(command.getUsuarioId(), repository().getEventsBy(command.getUsuarioId().value()));
        usuario.crearHistoriaMedica(command.getHistoriaMedicaId(), command.getFecha(),command.getDescripcion());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
