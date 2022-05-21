package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.CitaId;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.FechaCita;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Observacion;
import co.com.sofka.domain.generic.Command;

public class GenerarAtencionDeCitaProgramada extends Command {
    private final CitaId citaId;
    private final Observacion observacion;
    private final FechaCita fechaCita;

    public GenerarAtencionDeCitaProgramada(CitaId citaId, Observacion observacion, FechaCita fechaCita) {
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
