package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.EstadoExamen;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ExamenId;
import co.com.sofka.domain.generic.DomainEvent;

public class EstadoDeExamenDeLaboratorioActualizado extends DomainEvent {
    private final ExamenId examenId;
    private final EstadoExamen estadoExamen;

    public EstadoDeExamenDeLaboratorioActualizado(ExamenId examenId, EstadoExamen estadoExamen) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.EstadoDeExamenDeLaboratorioActualizado");
        this.examenId = examenId;
        this.estadoExamen = estadoExamen;
    }

    public EstadoExamen getEstadoExamen() {
        return estadoExamen;
    }
}
