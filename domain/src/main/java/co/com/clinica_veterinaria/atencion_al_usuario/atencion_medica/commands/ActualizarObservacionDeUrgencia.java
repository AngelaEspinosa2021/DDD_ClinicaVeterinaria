package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.UrgenciaId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Observacion;
import co.com.sofka.domain.generic.Command;

public class ActualizarObservacionDeUrgencia extends Command {
    private final UrgenciaId urgenciaId;
    private final Observacion observacion;

    public ActualizarObservacionDeUrgencia(UrgenciaId urgenciaId, Observacion observacion) {
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
