package co.com.ClinicaVeterinaria.usuario;

import co.com.ClinicaVeterinaria.usuario.values.PacienteId;
import co.com.sofka.domain.generic.Entity;

public class Paciente extends Entity<PacienteId> {
    public Paciente(PacienteId entityId) {
        super(entityId);
    }
}
