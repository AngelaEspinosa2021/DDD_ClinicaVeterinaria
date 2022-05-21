package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.AgregarObservacionAHistoriaMedica;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarObservacionAHistoriaMedicaUseCase extends UseCase<RequestCommand<AgregarObservacionAHistoriaMedica>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarObservacionAHistoriaMedica> agregarObservacionAHistoriaMedicaRequestCommand) {
        var command = agregarObservacionAHistoriaMedicaRequestCommand.getCommand();
        var usuario = Usuario.from(command.getUsuarioId(), repository().getEventsBy(command.getUsuarioId().value()));
        usuario.agregarObservacionAHistoriaMedica(command.getHistoriaMedicaId(), command.getObservacion());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
