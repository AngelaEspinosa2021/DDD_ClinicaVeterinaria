package co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.DueñoId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.DatosDeContacto;
import co.com.sofka.domain.generic.Command;

public class ActualizarDatosDeContactoDeDueño extends Command {

    private final DueñoId dueñoId;
    private final DatosDeContacto datosDeContacto;

    public ActualizarDatosDeContactoDeDueño(DueñoId dueñoId, DatosDeContacto datosDeContacto) {
        this.dueñoId = dueñoId;
        this.datosDeContacto = datosDeContacto;
    }

    public DueñoId getDueñoId() {
        return dueñoId;
    }

    public DatosDeContacto getDatosDeContacto() {
        return datosDeContacto;
    }
}
