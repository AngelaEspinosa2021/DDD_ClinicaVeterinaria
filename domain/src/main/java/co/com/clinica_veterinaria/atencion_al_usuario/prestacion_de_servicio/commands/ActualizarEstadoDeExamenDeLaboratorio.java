package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ExamenId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Estado;
import co.com.sofka.domain.generic.Command;

public class ActualizarEstadoDeExamenDeLaboratorio extends Command {
    private final ExamenId examenId;
    private final Estado estado;

    public ActualizarEstadoDeExamenDeLaboratorio(ExamenId examenId, Estado estado) {
        this.examenId = examenId;
        this.estado = estado;
    }

    public ExamenId getExamenId() {
        return examenId;
    }

    public Estado getEstado() {
        return estado;
    }
}
