package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.MedicoId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreDeMedicoActualizado extends DomainEvent {
    private final MedicoId medicoId;
    private final NombreCompleto nombreCompleto;

    public NombreDeMedicoActualizado(MedicoId medicoId, NombreCompleto nombreCompleto) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.NombreDeMedicoActualizado");
        this.medicoId = medicoId;
        this.nombreCompleto = nombreCompleto;
    }

    public MedicoId getMedicoId() {
        return medicoId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
