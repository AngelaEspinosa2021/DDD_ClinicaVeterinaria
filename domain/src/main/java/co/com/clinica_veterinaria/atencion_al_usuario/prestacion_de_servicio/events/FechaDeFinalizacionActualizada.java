package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events;

import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.DomainEvent;

public class FechaDeFinalizacionActualizada extends DomainEvent {
    private final Fecha fechaDeFinalizacion;

    public FechaDeFinalizacionActualizada(Fecha fechaDeFinalizacion) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.FechaDeFinalizacionActualizada");
        this.fechaDeFinalizacion = fechaDeFinalizacion;
    }

    public Fecha getFechaDeFinalizacion() {
        return fechaDeFinalizacion;
    }
}
