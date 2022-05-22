package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.EstadoExamen;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Nombre;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Resultados;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ExamenId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class ExamenDeLaboratorio extends Entity<ExamenId> {
    protected Nombre nombre;
    protected Fecha fechaRealizacion;
    protected Resultados resultados;
    protected EstadoExamen estadoExamen;

    public ExamenDeLaboratorio(ExamenId examenId,Nombre nombre,EstadoExamen estadoExamen) {
        super(examenId);
        this.nombre = nombre;
        this.estadoExamen = estadoExamen;
    }

    public void actualizarEstado(EstadoExamen estadoExamen){
        this.estadoExamen= Objects.requireNonNull(estadoExamen);
    }

    public void actualizarResultados(Resultados resultados){
        this.resultados=resultados;
    }

    public Nombre nombre() {
        return nombre;
    }

    public EstadoExamen estadoExamen() {
        return estadoExamen;
    }
}
