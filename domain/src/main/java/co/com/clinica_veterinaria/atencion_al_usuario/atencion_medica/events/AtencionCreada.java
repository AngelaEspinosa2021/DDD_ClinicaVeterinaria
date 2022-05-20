package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.TipoDeAtencion;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Estado;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.DomainEvent;

public class AtencionCreada extends DomainEvent {
    private final Fecha fechaDeAtencion;
    private final TipoDeAtencion tipoDeAtencion;
    private final Estado estado;
    private final UsuarioId usuarioId;

    public AtencionCreada(UsuarioId usuarioId,Fecha fechaDeAtencion, TipoDeAtencion tipoDeAtencion, Estado estado) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.AtencionCreada");
        this.usuarioId=usuarioId;
        this.fechaDeAtencion = fechaDeAtencion;
        this.tipoDeAtencion = tipoDeAtencion;
        this.estado = estado;
    }

    public Fecha getFechaDeAtencion() {
        return fechaDeAtencion;
    }

    public TipoDeAtencion getTipoDeAtencion() {
        return tipoDeAtencion;
    }

    public Estado getEstado() {
        return estado;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }
}
