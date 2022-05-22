package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.AtencionId;
import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.TipoDeAtencion;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Estado;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.Command;

public class CrearAtencion extends Command {
    private final AtencionId atencionId;
    private final UsuarioId usuarioId;
    private final Fecha fechaDeAtencion;
    private final TipoDeAtencion tipoDeAtencion;
    private final Estado estado;

    public CrearAtencion(AtencionId atencionId, Fecha fechaDeAtencion, TipoDeAtencion tipoDeAtencion, Estado estado, UsuarioId usuarioId) {
        this.atencionId = atencionId;
        this.fechaDeAtencion = fechaDeAtencion;
        this.tipoDeAtencion = tipoDeAtencion;
        this.estado = estado;
        this.usuarioId = usuarioId;
    }

    public AtencionId getAtencionId() {
        return atencionId;
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
