package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.AtencionId;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.CitaId;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.FechaCita;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Observacion;
import co.com.sofka.domain.generic.Command;

public class GenerarAtencionDeCitaProgramada extends Command {
    private final AtencionId atencionId;
    private final CitaId citaId;
    private final Observacion observacion;
    private final FechaCita fechaCita;

    public GenerarAtencionDeCitaProgramada(AtencionId atencionId, CitaId citaId, Observacion observacion, FechaCita fechaCita) {
        this.atencionId = atencionId;
        this.citaId = citaId;
        this.observacion = observacion;
        this.fechaCita = fechaCita;
    }

    public AtencionId getAtencionId() {
        return atencionId;
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
