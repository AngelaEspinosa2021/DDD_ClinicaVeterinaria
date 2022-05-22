package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands.ActualizarFechaDeFinalizacionPrestacionDeServicio;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.services.ActualizarFechaDeFinalizacion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarFechaDeFinalizacionPrestacionDeServicioUseCase extends UseCase<RequestCommand<ActualizarFechaDeFinalizacionPrestacionDeServicio>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarFechaDeFinalizacionPrestacionDeServicio> actualizarFechaDeFinalizacionPrestacionDeServicioUseCaseRequestCommand) {
        var command = actualizarFechaDeFinalizacionPrestacionDeServicioUseCaseRequestCommand.getCommand();
        var fechaDeFinalizacionService = getService(ActualizarFechaDeFinalizacion.class).orElseThrow();
        var atencionMedica = AtencionMedica.from(command.getAtencionId(),repository().getEventsBy(command.getAtencionId().value()));
        atencionMedica.actualizarFechaDeFinalizacionPrestacionDeServicio(fechaDeFinalizacionService.consultarPorAtencionId(command.getAtencionId()));
         emit().onResponse(new ResponseEvents(atencionMedica.getUncommittedChanges()));
    }
}
