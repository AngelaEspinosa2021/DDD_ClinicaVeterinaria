package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.EstadoExamen;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ExamenId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class ExamenDeLaborarioSolicitado extends DomainEvent {
    private final ExamenId examenId;
    private final Nombre nombre;
    private final EstadoExamen estadoExamen;

    public ExamenDeLaborarioSolicitado(ExamenId examenId, Nombre nombre, EstadoExamen estadoExamen) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.ExamenDeLaborarioSolicitado");
        this.examenId = examenId;
        this.nombre = nombre;
        this.estadoExamen = estadoExamen;
    }

    public ExamenId getExamenId() {
        return examenId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public EstadoExamen getEstadoExamen() {
        return estadoExamen;
    }
}
