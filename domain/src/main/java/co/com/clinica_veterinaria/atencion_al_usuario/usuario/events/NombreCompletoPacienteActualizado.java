package co.com.clinica_veterinaria.atencion_al_usuario.usuario.events;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.PacienteId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreCompletoPacienteActualizado extends DomainEvent {
    private PacienteId pacienteId;
    private NombreCompleto nombreCompleto;

    public NombreCompletoPacienteActualizado(PacienteId pacienteId, NombreCompleto nombreCompleto) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.NombrePacienteActualizado");
        this.pacienteId = pacienteId;
        this.nombreCompleto = nombreCompleto;
    }

    public PacienteId getPacienteId() {
        return pacienteId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
