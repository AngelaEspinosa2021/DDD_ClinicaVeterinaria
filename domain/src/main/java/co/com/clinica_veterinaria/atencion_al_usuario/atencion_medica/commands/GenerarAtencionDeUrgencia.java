package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.Triage;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.UrgenciaId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Observacion;
import co.com.sofka.domain.generic.Command;

public class SolicitarAtencionDeUrgencia extends Command {
    private final UrgenciaId urgenciaId;
    private final Observacion observacion;
    private final Triage triage;

    public SolicitarAtencionDeUrgencia(UrgenciaId urgenciaId, Observacion observacion, Triage triage) {
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
