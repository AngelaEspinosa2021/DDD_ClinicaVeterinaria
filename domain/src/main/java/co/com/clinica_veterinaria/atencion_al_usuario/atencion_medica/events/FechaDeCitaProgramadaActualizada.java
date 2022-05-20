package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.CitaId;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.FechaCita;
import co.com.sofka.domain.generic.DomainEvent;

public class FechaDeCitaProgramadaActualizada extends DomainEvent {
    private final CitaId citaId;
    private final FechaCita fechaCita;

    public FechaDeCitaProgramadaActualizada(CitaId citaId, FechaCita fechaCita) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.FechaDeCitaProgramadaActualizada");
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
