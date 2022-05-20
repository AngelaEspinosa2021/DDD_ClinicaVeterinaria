package co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.Descripcion;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.HistoriaMedicaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarDescripcionDeHistoriaMedica extends Command {

    private final HistoriaMedicaId historiaMedicaId;
    private final Descripcion descripcion;

    public ActualizarDescripcionDeHistoriaMedica(HistoriaMedicaId historiaMedicaId, Descripcion descripcion) {
        this.historiaMedicaId = historiaMedicaId;
        this.descripcion = descripcion;
    }

    public HistoriaMedicaId getHistoriaMedicaId() {
        return historiaMedicaId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
