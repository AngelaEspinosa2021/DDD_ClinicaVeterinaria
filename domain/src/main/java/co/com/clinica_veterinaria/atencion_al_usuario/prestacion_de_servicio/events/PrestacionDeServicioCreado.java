package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.FechaDeSolicitud;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Prioridad;
import co.com.sofka.domain.generic.DomainEvent;

public class PrestacionDeServicioCreado extends DomainEvent {
    protected final Prioridad prioridad;
    protected final FechaDeSolicitud fechaDeSolicitud;

    public PrestacionDeServicioCreado(Prioridad prioridad, FechaDeSolicitud fechaDeSolicitud) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.PrestacionDeServicioCreado");
        this.prioridad = prioridad;
        this.fechaDeSolicitud = fechaDeSolicitud;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public FechaDeSolicitud getFechaDeSolicitud() {
        return fechaDeSolicitud;
    }
}
