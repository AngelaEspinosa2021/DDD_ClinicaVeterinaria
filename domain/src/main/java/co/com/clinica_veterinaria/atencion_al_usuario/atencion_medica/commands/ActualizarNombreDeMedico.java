package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.MedicoId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombreDeMedico extends Command {
    private final MedicoId medicoId;
    private final NombreCompleto nombreCompleto;

    public ActualizarNombreDeMedico(MedicoId medicoId, NombreCompleto nombreCompleto) {
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
