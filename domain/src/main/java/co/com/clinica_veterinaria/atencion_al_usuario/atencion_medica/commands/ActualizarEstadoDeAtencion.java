package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.AtencionId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Estado;
import co.com.sofka.domain.generic.Command;

public class ActualizarEstadoDeAtencion extends Command {
    private final AtencionId atencionId;
    private final Estado estado;

    public ActualizarEstadoDeAtencion(AtencionId atencionId, Estado estado) {
        this.atencionId = atencionId;
        this.estado = estado;
    }

    public AtencionId getAtencionId() {
        return atencionId;
    }

    public Estado getEstado() {
        return estado;
    }
}
