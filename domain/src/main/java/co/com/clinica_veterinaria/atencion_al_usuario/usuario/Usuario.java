package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.events.UsuarioCreado;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.FechaDeCreacion;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.sofka.domain.generic.AggregateEvent;

public class Usuario extends AggregateEvent<UsuarioId> {
    protected FechaDeCreacion fechaDeCreacion;
    protected Dueño dueño;
    protected Paciente paciente;

    public Usuario(UsuarioId usuarioId, FechaDeCreacion fechaDeCreacion){
        super(usuarioId);
        appendChange( new UsuarioCreado(fechaDeCreacion)).apply();
    }
}
