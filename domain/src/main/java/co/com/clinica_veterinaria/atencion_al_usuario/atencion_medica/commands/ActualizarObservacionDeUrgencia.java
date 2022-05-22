package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.AtencionId;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.UrgenciaId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Observacion;
import co.com.sofka.domain.generic.Command;

public class ActualizarObservacionDeUrgencia extends Command {
    private final AtencionId atencionId;
    private final UrgenciaId urgenciaId;
    private final Observacion observacion;

    public ActualizarObservacionDeUrgencia(AtencionId atencionId, UrgenciaId urgenciaId, Observacion observacion) {
        this.atencionId = atencionId;
        this.urgenciaId = urgenciaId;
        this.observacion = observacion;
    }

    public AtencionId getAtencionId() {
        return atencionId;
    }

    public UrgenciaId getUrgenciaId() {
        return urgenciaId;
    }

    public Observacion getObservacion() {
        return observacion;
    }
}
