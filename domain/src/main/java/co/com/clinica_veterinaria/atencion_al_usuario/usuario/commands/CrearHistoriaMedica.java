package co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.Descripcion;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.Fecha;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.HistoriaMedicaId;
import co.com.sofka.domain.generic.Command;

public class CrearHistoriaMedica extends Command {
    private HistoriaMedicaId historiaMedicaId;
    private Fecha fecha;
    private Descripcion descripcion;

    public CrearHistoriaMedica(HistoriaMedicaId historiaMedicaId, Fecha fecha, Descripcion descripcion) {
        this.historiaMedicaId = historiaMedicaId;
        this.fecha = fecha;
        this.descripcion = descripcion;
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
