package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands.FinalizarAtencion;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.services.ConsultarProximaCita;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Resultados;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class FinalizarAtencionUseCase extends UseCase<RequestCommand<FinalizarAtencion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<FinalizarAtencion> finalizarAtencionRequestCommand) {
        var command = finalizarAtencionRequestCommand.getCommand();
        var proximaCitaService=getService(ConsultarProximaCita.class).orElseThrow();
        var atencionMedica = AtencionMedica.from(command.getAtencionId(),repository().getEventsBy(command.getAtencionId().value()));
        atencionMedica.finalizarAtencion(proximaCitaService.consultarPorAtencionId(command.getAtencionId()));

        emit().onResponse(new ResponseEvents(atencionMedica.getUncommittedChanges()));
    }
}
