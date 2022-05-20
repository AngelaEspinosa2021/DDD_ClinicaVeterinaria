package co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.Command;

public class ActualizarFechaDeCreacion extends Command {

    private final UsuarioId usuarioId;
    private final Fecha fechaDeCreacion;

    public ActualizarFechaDeCreacion(UsuarioId usuarioId, Fecha fechaDeCreacion) {
        this.usuarioId = usuarioId;
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public UsuarioId getUsuarioId() {return usuarioId;}

    public Fecha getFechaDeCreacion() {
        return fechaDeCreacion;
    }
}
