package co.com.clinica_veterinaria.atencion_al_usuario.usuario.events;

import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.DomainEvent;

public class ProximaCitaAgendada extends DomainEvent {
    private final Fecha proximaCita;

    public ProximaCitaAgendada(Fecha proximaCita) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.ProximaCitaAgendada");
        this.proximaCita = proximaCita;
    }

    public Fecha getProximaCita() {
        return proximaCita;
    }
}
