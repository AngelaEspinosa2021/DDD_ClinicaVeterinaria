package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicios;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.PrestacionDeServicio;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands.ActualizarNombreDeMedicamento;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import java.lang.module.ResolutionException;

public class ActualizarNombreDeMedicamentoUseCase extends UseCase<RequestCommand<ActualizarNombreDeMedicamento>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreDeMedicamento> actualizarNombreDeMedicamentoRequestCommand) {
        var command = actualizarNombreDeMedicamentoRequestCommand.getCommand();
        var servicio = PrestacionDeServicio.from(command.getServicioId(), repository().getEventsBy(command.getServicioId().value()));
        servicio.actualizarNombreDeMedicamento(command.getMedicamentoId(), command.getNombre());
        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));
    }
}
