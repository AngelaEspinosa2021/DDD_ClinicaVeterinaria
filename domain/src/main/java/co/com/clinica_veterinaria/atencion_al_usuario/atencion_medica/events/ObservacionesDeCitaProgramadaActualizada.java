package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.CitaId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Observacion;
import co.com.sofka.domain.generic.DomainEvent;

public class ObservacionesDeCitaProgramadaActualizada extends DomainEvent {
    private final CitaId citaId;
    private final Observacion observacion;

    public ObservacionesDeCitaProgramadaActualizada(CitaId citaId, Observacion observacion) {
        super("co.com.clinica_veterinaria.ObservacionesDeCitaProgramadaActualizada");
        this.citaId = citaId;
        this.observacion = observacion;
    }

    public CitaId getCitaId() {
        return citaId;
    }

    public Observacion getObservacion() {
        return observacion;
    }
}
