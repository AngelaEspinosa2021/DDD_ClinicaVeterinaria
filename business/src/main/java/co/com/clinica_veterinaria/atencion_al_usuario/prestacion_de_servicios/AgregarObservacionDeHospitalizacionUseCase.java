package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicios;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.PrestacionDeServicio;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands.AgregarObservacionDeHospitalizacion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarObservacionDeHospitalizacionUseCase extends UseCase<RequestCommand<AgregarObservacionDeHospitalizacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarObservacionDeHospitalizacion> agregarObservacionDeHospitalizacionRequestCommand) {
        var command = agregarObservacionDeHospitalizacionRequestCommand.getCommand();
        var servicio = PrestacionDeServicio.from(command.getServicioId(), repository().getEventsBy(command.getServicioId().value()));
        servicio.agregarObservacionDeHospitalizacion(command.getHospitalizacionId(), command.getObservacion());
        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));
    }
}
