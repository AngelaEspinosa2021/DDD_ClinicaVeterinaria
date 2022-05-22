package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicios;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.PrestacionDeServicio;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands.ActualizarResultadosDeExamenDeLaboratorio;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarResultadosDeExamenDeLaboratorioUseCase extends UseCase<RequestCommand<ActualizarResultadosDeExamenDeLaboratorio>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarResultadosDeExamenDeLaboratorio> actualizarResultadosDeExamenDeLaboratorioRequestCommand) {
        var command = actualizarResultadosDeExamenDeLaboratorioRequestCommand.getCommand();
        var servicio = PrestacionDeServicio.from(command.getServicioId(), repository().getEventsBy(command.getServicioId().value()));
        servicio.actualizarResultadosDeExamenDeLaboratorio(command.getExamenId(), command.getResultados());
        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));
    }
}
