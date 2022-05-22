package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.AtencionId;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.CitaId;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.FechaCita;
import co.com.sofka.domain.generic.Command;

public class ActualizarFechaDeCitaProgramada extends Command {
    private final AtencionId atencionId;
    private final CitaId citaId;
    private final FechaCita fechaCita;

    public ActualizarFechaDeCitaProgramada(AtencionId atencionId, CitaId citaId, FechaCita fechaCita) {
        this.atencionId = atencionId;
        this.citaId = citaId;
        this.fechaCita = fechaCita;
    }

    public AtencionId getAtencionId() {
        return atencionId;
    }

    public CitaId getCitaId() {
        return citaId;
    }

    public FechaCita getFechaCita() {
        return fechaCita;
    }
}
