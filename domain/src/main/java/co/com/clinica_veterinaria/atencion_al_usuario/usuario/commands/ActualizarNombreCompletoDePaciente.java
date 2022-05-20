package co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.PacienteId;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombreCompletoDePaciente extends Command {
    private final UsuarioId usuarioId;
    private final PacienteId pacienteId;
    private final NombreCompleto nombreCompleto;

    public ActualizarNombreCompletoDePaciente(UsuarioId usuarioId, PacienteId pacienteId, NombreCompleto nombreCompleto) {
        this.usuarioId = usuarioId;
        this.pacienteId = pacienteId;
        this.nombreCompleto = nombreCompleto;
    }

    public UsuarioId getUsuarioId() { return usuarioId; }

    public PacienteId getPacienteId() {
        return pacienteId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
