package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Prioridad;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.Command;

public class SolicitarPrestacionDeServicio extends Command {
    protected final Prioridad prioridad;
    protected final Fecha fechaDeSolicitud;

    public SolicitarPrestacionDeServicio(Prioridad prioridad, Fecha fechaDeSolicitud) {
        this.prioridad = prioridad;
        this.fechaDeSolicitud = fechaDeSolicitud;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public Fecha getFechaDeSolicitud() {
        return fechaDeSolicitud;
    }
}
