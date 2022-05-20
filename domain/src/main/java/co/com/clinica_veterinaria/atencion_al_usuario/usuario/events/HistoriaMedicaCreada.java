package co.com.clinica_veterinaria.atencion_al_usuario.usuario.events;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.Descripcion;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.Fecha;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.HistoriaMedicaId;
import co.com.sofka.domain.generic.DomainEvent;

public class HistoriaMedicaCreada extends DomainEvent {
    private HistoriaMedicaId historiaMedicaId;
    private Fecha fecha;
    private Descripcion descripcion;

    public HistoriaMedicaCreada(HistoriaMedicaId historiaMedicaId, Fecha fecha, Descripcion descripcion) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.HistoriaMedicaCreada");
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
