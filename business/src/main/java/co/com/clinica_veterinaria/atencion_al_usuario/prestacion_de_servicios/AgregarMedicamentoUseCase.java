package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicios;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.PrestacionDeServicio;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands.AgregarMedicamento;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands.SolicitarHospitalizacion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarMedicamentoUseCase extends UseCase<RequestCommand<AgregarMedicamento>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMedicamento> agregarMedicamentoRequestCommand) {
        var command = agregarMedicamentoRequestCommand.getCommand();
        var servicio = PrestacionDeServicio.from(command.getServicioId(), repository().getEventsBy(command.getServicioId().value()));
        servicio.agregarMedicamento(command.getMedicamentoId(), command.getNombre(), command.getFechaDeVencimiento());
        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));
    }
}
