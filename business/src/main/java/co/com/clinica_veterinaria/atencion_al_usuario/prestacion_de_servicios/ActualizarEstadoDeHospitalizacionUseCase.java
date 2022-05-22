package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicios;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.PrestacionDeServicio;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands.ActualizarEstadoDeHospitalizacion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarEstadoDeHospitalizacionUseCase extends UseCase<RequestCommand<ActualizarEstadoDeHospitalizacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEstadoDeHospitalizacion> actualizarEstadoDeHospitalizacionRequestCommand) {
        var command= actualizarEstadoDeHospitalizacionRequestCommand.getCommand();
        var servicio = PrestacionDeServicio.from(command.getServicioId(), repository().getEventsBy(command.getHospitalizacionId().value()));
        servicio.actualizarEstadoDeHospitalizacion(command.getHospitalizacionId(),command.getEstadoDeHospitalizacion());
        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));
    }
}
