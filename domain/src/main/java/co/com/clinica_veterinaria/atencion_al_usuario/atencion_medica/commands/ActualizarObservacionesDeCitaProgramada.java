package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.CitaId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Observacion;
import co.com.sofka.domain.generic.Command;

public class ActualizarObservacionesDeCitaProgramada extends Command {
    private final CitaId citaId;
    private final Observacion observacion;

    public ActualizarObservacionesDeCitaProgramada(CitaId citaId, Observacion observacion) {
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
