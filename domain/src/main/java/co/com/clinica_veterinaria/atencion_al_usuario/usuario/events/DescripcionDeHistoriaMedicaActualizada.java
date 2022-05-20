package co.com.clinica_veterinaria.atencion_al_usuario.usuario.events;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.Descripcion;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.HistoriaMedicaId;
import co.com.sofka.domain.generic.DomainEvent;

public class DescripcionDeHistoriaMedicaActualizada extends DomainEvent {
    private final HistoriaMedicaId historiaMedicaId;
    private final Descripcion descripcion;

    public DescripcionDeHistoriaMedicaActualizada(HistoriaMedicaId historiaMedicaId, Descripcion descripcion) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.DescripcionDeHistoriMedicaActualizada");
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
