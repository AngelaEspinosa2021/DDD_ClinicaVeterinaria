package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events.AtencionFinalizada;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class AgendarProximaCitaUseCase extends UseCase<TriggeredEvent<AtencionFinalizada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<AtencionFinalizada> atencionFinalizadaTriggeredEvent) {
        var event = atencionFinalizadaTriggeredEvent.getDomainEvent();
        var usuario = Usuario.from(event.getUsuarioId(), repository().getEventsBy(event.getUsuarioId().value()));

        usuario.agendarProximaCita(event.getProximaCita());

        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
