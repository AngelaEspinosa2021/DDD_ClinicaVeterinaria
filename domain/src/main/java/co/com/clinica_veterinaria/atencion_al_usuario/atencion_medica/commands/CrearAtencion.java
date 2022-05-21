package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.TipoDeAtencion;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Estado;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.Command;

public class CrearAtencion extends Command {
    private final UsuarioId usuarioId;
    private final Fecha fechaDeAtencion;
    private final TipoDeAtencion tipoDeAtencion;
    private final Estado estado;

    public CrearAtencion(Fecha fechaDeAtencion, TipoDeAtencion tipoDeAtencion, Estado estado, UsuarioId usuarioId) {
        this.fechaDeAtencion = fechaDeAtencion;
        this.tipoDeAtencion = tipoDeAtencion;
        this.estado = estado;
        this.usuarioId = usuarioId;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
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
}
