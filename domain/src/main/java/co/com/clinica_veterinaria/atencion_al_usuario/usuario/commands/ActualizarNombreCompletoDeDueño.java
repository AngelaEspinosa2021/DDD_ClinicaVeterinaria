package co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.DueñoId;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombreCompletoDeDueño extends Command {
    private final UsuarioId usuarioId;
    private final DueñoId dueñoId;
    private final NombreCompleto nombreCompleto;

    public ActualizarNombreCompletoDeDueño(UsuarioId usuarioId, DueñoId dueñoId, NombreCompleto nombreCompleto) {
        this.usuarioId = usuarioId;
        this.dueñoId = dueñoId;
        this.nombreCompleto = nombreCompleto;
    }

    public UsuarioId getUsuarioId() {return usuarioId;}

    public DueñoId getDueñoId() {
        return dueñoId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
