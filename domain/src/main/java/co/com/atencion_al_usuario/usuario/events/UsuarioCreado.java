package co.com.ClinicaVeterinaria.usuario.events;

import co.com.sofka.domain.generic.DomainEvent;

public class UsuarioCreado extends DomainEvent {
    public UsuarioCreado(String type) {
        super(type);
    }
}
