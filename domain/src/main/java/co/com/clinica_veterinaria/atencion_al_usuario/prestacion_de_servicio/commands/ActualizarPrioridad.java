package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Prioridad;
import co.com.sofka.domain.generic.Command;

public class ActualizarPrioridad extends Command {
    private final Prioridad prioridad;

    public ActualizarPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }
}
