package co.com.clinica_veterinaria.atencion_al_usuario.usuario.events;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.ProximaCita;
import co.com.sofka.domain.generic.DomainEvent;

public class ProximaCitaAgendada extends DomainEvent {
    private final ProximaCita proximaCita;

    public ProximaCitaAgendada(ProximaCita proximaCita) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.ProximaCitaAgendada");
        this.proximaCita = proximaCita;
    }

    public ProximaCita getProximaCita() {
        return proximaCita;
    }
}
