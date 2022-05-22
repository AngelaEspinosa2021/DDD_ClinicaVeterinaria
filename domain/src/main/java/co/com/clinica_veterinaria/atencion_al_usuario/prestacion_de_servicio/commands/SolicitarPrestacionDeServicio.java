package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Prioridad;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.Command;

public class SolicitarPrestacionDeServicio extends Command {
    private final ServicioId servicioId;
    private final Prioridad prioridad;
    private final Fecha fechaDeSolicitud;

    public SolicitarPrestacionDeServicio(ServicioId servicioId, Prioridad prioridad, Fecha fechaDeSolicitud) {
        this.servicioId = servicioId;
        this.prioridad = prioridad;
        this.fechaDeSolicitud = fechaDeSolicitud;
    }

    public ServicioId getServicioId() {return servicioId;}

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public Fecha getFechaDeSolicitud() {
        return fechaDeSolicitud;
    }
}
