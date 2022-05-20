package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Prioridad;
import co.com.sofka.domain.generic.DomainEvent;

public class PrioridadActualizada extends DomainEvent {
    private final Prioridad prioridad;

    public PrioridadActualizada(Prioridad prioridad) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.PrioridadActualizada");
        this.prioridad = prioridad;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }
}
