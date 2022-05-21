package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.Triage;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.UrgenciaId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Observacion;
import co.com.sofka.domain.generic.DomainEvent;

public class AtencionDeUrgenciasGenerada extends DomainEvent {
    private final UrgenciaId urgenciaId;
    private final Observacion observacion;
    private final Triage triage;

    public AtencionDeUrgenciasGenerada(UrgenciaId urgenciaId,Observacion observacion, Triage triage) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.AtencionDeUrgenciasGenerada");
        this.observacion = observacion;
        this.triage = triage;
        this.urgenciaId=urgenciaId;
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
