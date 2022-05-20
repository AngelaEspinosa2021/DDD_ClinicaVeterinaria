package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.FechaRealizacion;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Nombre;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Resultados;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Estado;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ExamenId;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class ExamenDeLaboratorio extends Entity<ExamenId> {
    protected Nombre nombre;
    protected FechaRealizacion fechaRealizacion;
    protected Resultados resultados;
    protected Estado estado;

    public ExamenDeLaboratorio(ExamenId examenId,Nombre nombre,FechaRealizacion fechaRealizacion,Resultados resultados,Estado estado) {
        super(examenId);
        this.nombre = nombre;
        this.fechaRealizacion = fechaRealizacion;
        this.resultados = resultados;
        this.estado = estado;
    }

    public void actualizarEstado(Estado estado){
        this.estado= Objects.requireNonNull(estado);
    }

    public void actualizarResultados(Resultados resultados){
        this.resultados=resultados;
    }

    public Nombre nombre() {
        return nombre;
    }

    public FechaRealizacion fechaRealizacion() {
        return fechaRealizacion;
    }

    public Resultados resultados() {
        return resultados;
    }

    public Estado estado() {
        return estado;
    }
}
