package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.CitaId;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.FechaCita;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Observacion;
import co.com.sofka.domain.generic.DomainEvent;

public class AtencionDeCitaProgramadaSolicitada extends DomainEvent {
    private final CitaId citaId;
    private final Observacion observacion;
    private final FechaCita fechaCita;

    public AtencionDeCitaProgramadaSolicitada(CitaId citaId, Observacion observacion, FechaCita fechaCita) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.AtencionDeCitaProgramadaSolicitada");
        this.citaId = citaId;
        this.observacion = observacion;
        this.fechaCita = fechaCita;
    }

    public CitaId getCitaId() {
        return citaId;
    }

    public Observacion getObservacion() {
        return observacion;
    }

    public FechaCita getFechaCita() {
        return fechaCita;
    }
}
