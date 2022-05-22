package co.com.clinica_veterinaria.atencion_al_usuario.usuario.events;

import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.DomainEvent;

public class UsuarioCreado extends DomainEvent {

    private final Fecha fechaDeCreacion;

    public UsuarioCreado(Fecha fechaDeCreacion) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.UsuarioCreado");
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Fecha getFechaDeCreacion() {
        return fechaDeCreacion;
    }
}
