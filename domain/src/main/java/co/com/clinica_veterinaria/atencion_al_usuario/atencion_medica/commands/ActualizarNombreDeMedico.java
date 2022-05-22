package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.AtencionId;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.MedicoId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombreDeMedico extends Command {
    private final AtencionId atencionId;
    private final MedicoId medicoId;
    private final NombreCompleto nombreCompleto;

    public ActualizarNombreDeMedico(AtencionId atencionId, MedicoId medicoId, NombreCompleto nombreCompleto) {
        this.atencionId = atencionId;
        this.medicoId = medicoId;
        this.nombreCompleto = nombreCompleto;
    }

    public AtencionId getAtencionId() {
        return atencionId;
    }

    public MedicoId getMedicoId() {
        return medicoId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
