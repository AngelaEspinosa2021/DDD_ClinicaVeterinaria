package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.Triage;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.UrgenciaId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Observacion;
import co.com.sofka.domain.generic.DomainEvent;

public class AtencionDeUrgenciaSolicitada extends DomainEvent {
    private final UrgenciaId urgenciaId;
    private final Observacion observacion;
    private final Triage triage;

    public AtencionDeUrgenciaSolicitada(UrgenciaId urgenciaId, Observacion observacion, Triage triage) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.AtencionDeUrgenciaSolicitada");
        this.urgenciaId = urgenciaId;
        this.observacion = observacion;
        this.triage = triage;
    }

    public UrgenciaId getUrgenciaId() {
        return urgenciaId;
    }

    public Observacion getObservacion() {
        return observacion;
    }

    public Triage getTriage() {
        return triage;
    }
}
