package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.CitaId;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.FechaCita;
import co.com.sofka.domain.generic.Command;

public class ActualizarFechaDeCitaProgramada extends Command {
    private final CitaId citaId;
    private final FechaCita fechaCita;

    public ActualizarFechaDeCitaProgramada(CitaId citaId, FechaCita fechaCita) {
        this.citaId = citaId;
        this.fechaCita = fechaCita;
    }

    public CitaId getCitaId() {
        return citaId;
    }

    public FechaCita getFechaCita() {
        return fechaCita;
    }
}
