package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicios;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.PrestacionDeServicio;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands.SolicitarPrestacionDeServicio;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.Usuario;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class SolicitarPrestacionDeServicioUseCase extends UseCase<RequestCommand<SolicitarPrestacionDeServicio>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<SolicitarPrestacionDeServicio> solicitarPrestacionDeServicioRequestCommand) {
        var command = solicitarPrestacionDeServicioRequestCommand.getCommand();
        var servicio = new PrestacionDeServicio(command.getServicioId(), command.getPrioridad(), command.getFechaDeSolicitud());

        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));
    }
}
