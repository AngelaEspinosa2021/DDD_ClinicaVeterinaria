package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.AtencionId;
import co.com.sofka.domain.generic.Command;

public class ActualizarFechaDeFinalizacionPrestacionDeServicio extends Command {
    private final AtencionId atencionId;

    public ActualizarFechaDeFinalizacionPrestacionDeServicio(AtencionId atencionId) {
        this.atencionId = atencionId;
    }

    public AtencionId getAtencionId() {
        return atencionId;
    }
}
