package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Prioridad;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
import co.com.sofka.domain.generic.Command;

public class ActualizarPrioridad extends Command {
    private final ServicioId servicioId;
    private final Prioridad prioridad;

    public ActualizarPrioridad(ServicioId servicioId, Prioridad prioridad) {
        this.servicioId = servicioId;
        this.prioridad = prioridad;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }
}
