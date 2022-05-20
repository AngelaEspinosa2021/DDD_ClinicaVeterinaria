package co.com.clinica_veterinaria.atencion_al_usuario.usuario.events;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.FechaDeCreacion;
import co.com.sofka.domain.generic.DomainEvent;

public class FechaDeCreacionActualizada extends DomainEvent {
    public FechaDeCreacionActualizada(FechaDeCreacion fechaDeCreacio) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.FechaDeCreacionActualizada");
    }
}
