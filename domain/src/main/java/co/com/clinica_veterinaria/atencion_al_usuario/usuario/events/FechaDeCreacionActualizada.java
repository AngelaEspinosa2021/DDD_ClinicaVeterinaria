package co.com.clinica_veterinaria.atencion_al_usuario.usuario.events;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.FechaDeCreacion;
import co.com.sofka.domain.generic.DomainEvent;

public class FechaDeCreacionActualizada extends DomainEvent {
    private FechaDeCreacion fechaDeCreacion;

    public FechaDeCreacionActualizada(FechaDeCreacion fechaDeCreacion) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.FechaDeCreacionActualizada");
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public FechaDeCreacion getFechaDeCreacio() {
        return fechaDeCreacion;
    }
}
