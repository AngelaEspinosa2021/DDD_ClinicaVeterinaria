package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicios;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.PrestacionDeServicio;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands.ActualizarEstadoDeExamenDeLaboratorio;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarEstadoDeExamenDeLaboratorioUseCase extends UseCase<RequestCommand<ActualizarEstadoDeExamenDeLaboratorio>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEstadoDeExamenDeLaboratorio> actualizarEstadoDeExamenDeLaboratorioRequestCommand) {
        var command = actualizarEstadoDeExamenDeLaboratorioRequestCommand.getCommand();
        var servicio = PrestacionDeServicio.from(command.getServicioId(), repository().getEventsBy(command.getServicioId().value()));
        servicio.actualizarEstadoDeExamenDeLaboratorio(command.getExamenId(), command.getEstadoExamen());
        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));
    }
}
