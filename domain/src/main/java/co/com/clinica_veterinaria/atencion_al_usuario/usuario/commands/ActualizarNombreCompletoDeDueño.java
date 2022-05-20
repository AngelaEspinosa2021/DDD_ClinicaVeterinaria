package co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.DueñoId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombreCompletoDeDueño extends Command {

    private DueñoId dueñoId;
    private NombreCompleto nombreCompleto;

    public ActualizarNombreCompletoDeDueño(DueñoId dueñoId, NombreCompleto nombreCompleto) {
        this.dueñoId = dueñoId;
        this.nombreCompleto = nombreCompleto;
    }

    public DueñoId getDueñoId() {
        return dueñoId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
