package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ExamenId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.FechaRealizacion;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Nombre;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Resultados;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Estado;
import co.com.sofka.domain.generic.DomainEvent;

public class ExamenDeLaborarioSolicitado extends DomainEvent {
    private final ExamenId examenId;
    private final Nombre nombre;
    private final FechaRealizacion fechaRealizacion;
    private final Resultados resultados;
    private final Estado estado;

    public ExamenDeLaborarioSolicitado(ExamenId examenId, Nombre nombre, FechaRealizacion fechaRealizacion, Resultados resultados, Estado estado) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.ExamenDeLaborarioSolicitado");
        this.examenId = examenId;
        this.nombre = nombre;
        this.fechaRealizacion = fechaRealizacion;
        this.resultados = resultados;
        this.estado = estado;
    }

    public ExamenId getExamenId() {
        return examenId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public FechaRealizacion getFechaRealizacion() {
        return fechaRealizacion;
    }

    public Resultados getResultados() {
        return resultados;
    }

    public Estado getEstado() {
        return estado;
    }
}
