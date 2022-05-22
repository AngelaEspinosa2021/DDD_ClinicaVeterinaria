package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.EstadoExamen;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ExamenId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Nombre;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ServicioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.Command;

public class SolicitarExamenDeLaboratorio extends Command {
    private final ServicioId servicioId;
    private final ExamenId examenId;
    private final Nombre nombre;
    private final Fecha fechaRealizacion;
   private final EstadoExamen estadoExamen;

    public SolicitarExamenDeLaboratorio(ServicioId servicioId, ExamenId examenId, Nombre nombre, Fecha fechaRealizacion,EstadoExamen estadoExamen) {
        this.servicioId = servicioId;
        this.examenId = examenId;
        this.nombre = nombre;
        this.fechaRealizacion = fechaRealizacion;
        this.estadoExamen = estadoExamen;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public ExamenId getExamenId() {
        return examenId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Fecha getFechaRealizacion() {
        return fechaRealizacion;
    }

    public EstadoExamen getEstadoExamen() {
        return estadoExamen;
    }
}
