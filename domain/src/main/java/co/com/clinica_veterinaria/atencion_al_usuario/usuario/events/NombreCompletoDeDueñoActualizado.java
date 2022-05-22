package co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands.events;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.DueñoId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreCompletoDeDueñoActualizado extends DomainEvent {
    private final DueñoId dueñoId;
    private final NombreCompleto nombreCompleto;

    public NombreCompletoDeDueñoActualizado(DueñoId dueñoId, NombreCompleto nombreCompleto) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.NombreCompletoDeDueñoActualizado");
        this.dueñoId = dueñoId;
        this.nombreCompleto = nombreCompleto;
    }
    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
