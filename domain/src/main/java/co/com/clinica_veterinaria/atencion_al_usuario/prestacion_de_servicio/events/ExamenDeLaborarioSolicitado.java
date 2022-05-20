package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.ExamenId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Nombre;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Resultados;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Estado;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.DomainEvent;

public class ExamenDeLaborarioSolicitado extends DomainEvent {
    private final ExamenId examenId;
    private final Nombre nombre;
    private final Estado estado;

    public ExamenDeLaborarioSolicitado(ExamenId examenId, Nombre nombre, Estado estado) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.ExamenDeLaborarioSolicitado");
        this.examenId = examenId;
        this.nombre = nombre;
        this.estado = estado;
    }

    public ExamenId getExamenId() {
        return examenId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Estado getEstado() {
        return estado;
    }
}
