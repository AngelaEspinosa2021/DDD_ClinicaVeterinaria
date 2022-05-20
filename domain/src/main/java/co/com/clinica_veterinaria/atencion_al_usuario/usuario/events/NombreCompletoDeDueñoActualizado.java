package co.com.clinica_veterinaria.atencion_al_usuario.usuario.events;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.DueñoId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreCompletoDeDueñoActualizado extends DomainEvent {
    private DueñoId dueñoId;
    private NombreCompleto nombreCompleto;

    public NombreCompletoDeDueñoActualizado(DueñoId dueñoId, NombreCompleto nombreCompleto) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.NombreCompletoDeDueñoActualizado");
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
