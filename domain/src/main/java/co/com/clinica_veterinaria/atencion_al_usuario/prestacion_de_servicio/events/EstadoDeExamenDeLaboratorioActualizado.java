package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ExamenId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Estado;
import co.com.sofka.domain.generic.DomainEvent;

public class EstadoDeExamenDeLaboratorioActualizado extends DomainEvent {
    private final ExamenId examenId;
    private final Estado estado;

    public EstadoDeExamenDeLaboratorioActualizado(ExamenId examenId, Estado estado) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.EstadoDeExamenDeLaboratorioActualizado");
        this.examenId = examenId;
        this.estado = estado;
    }

    public ExamenId getExamenId() {
        return examenId;
    }

    public Estado getEstado() {
        return estado;
    }
}
