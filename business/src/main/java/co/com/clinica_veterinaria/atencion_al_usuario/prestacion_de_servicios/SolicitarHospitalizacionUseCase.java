package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicios;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.PrestacionDeServicio;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands.SolicitarHospitalizacion;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.HospitalizacionSolicitada;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class SolicitarHospitalizacionUseCase extends UseCase<RequestCommand<SolicitarHospitalizacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<SolicitarHospitalizacion> solicitarHospitalizacionRequestCommand) {
        var command = solicitarHospitalizacionRequestCommand.getCommand();
        var servicio = PrestacionDeServicio.from(command.getServicioId(), repository().getEventsBy(command.getServicioId().value()));
        servicio.solicitarHospitalizacion(command.getHospitalizacionId(), command.getEstadoDeHospitalizacion(), command.getFechaDeIngreso());

        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));
    }
}
