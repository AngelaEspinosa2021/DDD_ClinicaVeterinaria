package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands.CrearAtencion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearAtencionUseCase extends UseCase<RequestCommand<CrearAtencion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearAtencion> crearAtencionRequestCommand) {
        var command = crearAtencionRequestCommand.getCommand();
        var atencion = new AtencionMedica(command.getAtencionId(), command.getUsuarioId(), command.getFechaDeAtencion(), command.getTipoDeAtencion());

        emit().onResponse(new ResponseEvents(atencion.getUncommittedChanges()));
    }
}
