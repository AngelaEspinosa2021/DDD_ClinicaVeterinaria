package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.events;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.TipoDeAtencion;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Estado;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.DomainEvent;

public class AtencionCreada extends DomainEvent {
    private final Fecha fechaDeAtencion;
    private final TipoDeAtencion tipoDeAtencion;
    private final UsuarioId usuarioId;
    private final Estado estado;

    public AtencionCreada(Fecha fechaDeAtencion, TipoDeAtencion tipoDeAtencion, UsuarioId usuarioId, Estado estado) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.AtencionCreada");
        this.fechaDeAtencion = fechaDeAtencion;
        this.tipoDeAtencion = tipoDeAtencion;
        this.usuarioId = usuarioId;
        this.estado = estado;
    }

    public Estado getEstado() { return estado; }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }

    public Fecha getFechaDeAtencion() {
        return fechaDeAtencion;
    }

    public TipoDeAtencion getTipoDeAtencion() {
        return tipoDeAtencion;
    }

}
