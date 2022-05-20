package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.UrgenciaId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Observacion;
import co.com.sofka.domain.generic.DomainEvent;

public class ObservacionDeUrgenciaActualizada extends DomainEvent {
    private final UrgenciaId urgenciaId;
    private final Observacion observacion;

    public ObservacionDeUrgenciaActualizada(UrgenciaId urgenciaId, Observacion observacion) {
        super("co.com.clinica_veterinaria.ObservacionDeUrgenciaActualizada");
        this.urgenciaId = urgenciaId;
        this.observacion = observacion;
    }

    public UrgenciaId getUrgenciaId() {
        return urgenciaId;
    }

    public Observacion getObservacion() {
        return observacion;
    }
}
