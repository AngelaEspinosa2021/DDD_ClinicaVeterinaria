package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicios;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.PrestacionDeServicio;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands.ActualizarFechaDeAltaDeHospitalizacion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarFechaDeAltaDeHospitalizacionUseCase extends UseCase<RequestCommand<ActualizarFechaDeAltaDeHospitalizacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarFechaDeAltaDeHospitalizacion> actualizarFechaDeAltaDeHospitalizacionRequestCommand) {
        var command = actualizarFechaDeAltaDeHospitalizacionRequestCommand.getCommand();
        var servicio = PrestacionDeServicio.from(command.getServicioId(), repository().getEventsBy(command.getServicioId().value()));
        servicio.actualizarFechaDeAltaDeHospitalizacion(command.getHospitalizacionId(), command.getFechaDeAlta());
        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));
    }
}
