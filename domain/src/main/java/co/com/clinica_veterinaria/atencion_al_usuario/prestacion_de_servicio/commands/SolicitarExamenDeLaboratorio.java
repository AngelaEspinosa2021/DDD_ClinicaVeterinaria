package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ExamenId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Nombre;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Resultados;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Estado;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.Command;

public class SolicitarExamenDeLaboratorio extends Command {
    private final ExamenId examenId;
    private final Nombre nombre;
    private final Fecha fechaRealizacion;
    private final Resultados resultados;
    private final Estado estado;

    public SolicitarExamenDeLaboratorio(ExamenId examenId, Nombre nombre, Fecha fechaRealizacion, Resultados resultados, Estado estado) {
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

    public Fecha getFechaRealizacion() {
        return fechaRealizacion;
    }

    public Resultados getResultados() {
        return resultados;
    }

    public Estado getEstado() {
        return estado;
    }
}
