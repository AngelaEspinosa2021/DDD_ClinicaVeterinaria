package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicios;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.PrestacionDeServicio;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands.SolicitarExamenDeLaboratorio;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class SolicitarExamenDeLaboratorioUseCase extends UseCase<RequestCommand<SolicitarExamenDeLaboratorio>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<SolicitarExamenDeLaboratorio> solicitarExamenDeLaboratorioRequestCommand) {
        var command = solicitarExamenDeLaboratorioRequestCommand.getCommand();
        var servicio = PrestacionDeServicio.from(command.getServicioId(), repository().getEventsBy(command.getServicioId().value()));
        servicio.solicitarExamenDeLaboratorio(command.getExamenId(), command.getNombre(),command.getEstadoExamen() );

        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));
    }

}
