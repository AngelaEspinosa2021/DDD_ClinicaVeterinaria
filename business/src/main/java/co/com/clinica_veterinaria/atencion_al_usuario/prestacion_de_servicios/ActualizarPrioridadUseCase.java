package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicios;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.PrestacionDeServicio;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands.ActualizarPrioridad;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarPrioridadUseCase extends UseCase<RequestCommand<ActualizarPrioridad>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarPrioridad> actualizarPrioridadRequestCommand) {
        var command = actualizarPrioridadRequestCommand.getCommand();
        var servicio = PrestacionDeServicio.from(command.getServicioId(), repository().getEventsBy(command.getServicioId().value()));
        servicio.actualizarPrioridad(command.getPrioridad());
        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));
    }
}
