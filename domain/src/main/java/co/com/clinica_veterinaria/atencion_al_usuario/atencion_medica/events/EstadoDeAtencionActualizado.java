package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events;

import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Estado;
import co.com.sofka.domain.generic.DomainEvent;

public class EstadoDeAtencionActualizado extends DomainEvent {
    private final Estado estado;

    public EstadoDeAtencionActualizado(Estado estado) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.EstadoDeAtencionActualizado");
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
