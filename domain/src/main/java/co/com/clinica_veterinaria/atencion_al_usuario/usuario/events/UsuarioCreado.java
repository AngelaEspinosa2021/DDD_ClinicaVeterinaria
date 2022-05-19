package co.com.clinica_veterinaria.atencion_al_usuario.usuario.events;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.FechaDeCreacion;
import co.com.sofka.domain.generic.DomainEvent;

public class UsuarioCreado extends DomainEvent {

    private FechaDeCreacion fechaDeCreacion;

    public UsuarioCreado(FechaDeCreacion fechaDeCreacion) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.UsuarioCreado");
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public FechaDeCreacion getFechaDeCreacion() {
        return fechaDeCreacion;
    }
}
