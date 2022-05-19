package co.com.atencion_al_usuario.usuario;

import co.com.atencion_al_usuario.usuario.values.PacienteId;
import co.com.sofka.domain.generic.Entity;

public class Paciente extends Entity<PacienteId> {
    public Paciente(PacienteId pacienteId) {
        super(pacienteId);
    }
}
