package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.MedicoId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.DatosDeContacto;
import co.com.sofka.domain.generic.Command;

public class ActualizarDatosDeContactoDeMedico extends Command {
    private final MedicoId medicoId;
    private final DatosDeContacto datosDeContacto;

    public ActualizarDatosDeContactoDeMedico(MedicoId medicoId, DatosDeContacto datosDeContacto) {
        this.medicoId = medicoId;
        this.datosDeContacto = datosDeContacto;
    }

    public MedicoId getMedicoId() {
        return medicoId;
    }

    public DatosDeContacto getDatosDeContacto() {
        return datosDeContacto;
    }
}
