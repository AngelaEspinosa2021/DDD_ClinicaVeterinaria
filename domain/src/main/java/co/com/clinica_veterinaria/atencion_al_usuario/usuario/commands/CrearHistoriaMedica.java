package co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.Descripcion;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.HistoriaMedicaId;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.Command;

public class CrearHistoriaMedica extends Command {
    private final UsuarioId usuarioId;
    private final HistoriaMedicaId historiaMedicaId;
    private final Fecha fecha;
    private final Descripcion descripcion;

    public CrearHistoriaMedica(UsuarioId usuarioId, HistoriaMedicaId historiaMedicaId, Fecha fecha, Descripcion descripcion) {
        this.usuarioId = usuarioId;
        this.historiaMedicaId = historiaMedicaId;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }

    public HistoriaMedicaId getHistoriaMedicaId() {
        return historiaMedicaId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
