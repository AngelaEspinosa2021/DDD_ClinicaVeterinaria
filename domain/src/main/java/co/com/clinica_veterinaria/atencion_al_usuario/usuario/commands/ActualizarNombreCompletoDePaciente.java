package co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.PacienteId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombreCompletoDePaciente extends Command {

    private PacienteId pacienteId;
    private NombreCompleto nombreCompleto;

    public ActualizarNombreCompletoDePaciente(PacienteId pacienteId, NombreCompleto nombreCompleto) {
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
