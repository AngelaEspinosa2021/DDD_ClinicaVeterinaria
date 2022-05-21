package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicios;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events.FechaDeFinalizacionPrestacionDeServicioActualizada;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.PrestacionDeServicio;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events.FechaDeFinalizacionActualizada;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class ActualizarFechaDeFinalizacionUseCase extends UseCase<TriggeredEvent<FechaDeFinalizacionPrestacionDeServicioActualizada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<FechaDeFinalizacionPrestacionDeServicioActualizada> fechaDeFinalizacionPrestacionDeServicioActualizadaTriggeredEvent) {
        var event = fechaDeFinalizacionPrestacionDeServicioActualizadaTriggeredEvent.getDomainEvent();
        var prestacionDeServicio = PrestacionDeServicio.from(event.getServicioId(), repository().getEventsBy(event.getServicioId().value()));

        prestacionDeServicio.actualizarFechaDeFinalizacion(event.getFechaDeFinalizacion());

        emit().onResponse(new ResponseEvents(prestacionDeServicio.getUncommittedChanges()));
    }
}
