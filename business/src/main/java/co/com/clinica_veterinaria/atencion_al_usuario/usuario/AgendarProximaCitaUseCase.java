package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events.AtencionFinalizada;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.events.ProximaCitaAgendada;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class AgendarProximaCitaUseCase extends UseCase<TriggeredEvent<AtencionFinalizada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<AtencionFinalizada> atencionFinalizadaTriggeredEvent) {
        
    }
}
