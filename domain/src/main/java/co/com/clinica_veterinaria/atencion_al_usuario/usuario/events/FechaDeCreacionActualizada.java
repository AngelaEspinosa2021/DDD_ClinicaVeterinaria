package co.com.clinica_veterinaria.atencion_al_usuario.usuario.events;

import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.DomainEvent;

public class FechaDeCreacionActualizada extends DomainEvent {
    private final Fecha fechaDeCreacion;

    public FechaDeCreacionActualizada(Fecha fechaDeCreacion) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.FechaDeCreacionActualizada");
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Fecha getFechaDeCreacio() {
        return fechaDeCreacion;
    }
}
