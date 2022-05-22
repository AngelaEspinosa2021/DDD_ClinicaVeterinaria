package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.EstadoExamen;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ExamenId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
import co.com.sofka.domain.generic.Command;

public class ActualizarEstadoDeExamenDeLaboratorio extends Command {
    private final ServicioId servicioId;
    private final ExamenId examenId;
    private final EstadoExamen estadoExamen;

    public ActualizarEstadoDeExamenDeLaboratorio(ServicioId servicioId,ExamenId examenId, EstadoExamen estadoExamen) {
        this.examenId = examenId;
        this.estadoExamen = estadoExamen;
        this.servicioId = servicioId;
    }

    public ServicioId getServicioId() {return servicioId;}

    public ExamenId getExamenId() {
        return examenId;
    }

    public EstadoExamen getEstadoExamen() {
        return estadoExamen;
    }
}
