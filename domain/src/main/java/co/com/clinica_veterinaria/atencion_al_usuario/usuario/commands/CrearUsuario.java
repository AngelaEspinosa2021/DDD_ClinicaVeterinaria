package co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.Command;

public class CrearUsuario extends Command {
    private final UsuarioId usuarioId;
    private final Fecha fechaDeCreacion;

    public CrearUsuario(UsuarioId usuarioId,Fecha fechaDeCreacion) {
        this.usuarioId = usuarioId;
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Fecha getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }
}
