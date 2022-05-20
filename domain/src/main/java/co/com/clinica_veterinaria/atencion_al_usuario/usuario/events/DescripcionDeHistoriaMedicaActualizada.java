package co.com.clinica_veterinaria.atencion_al_usuario.usuario.events;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.Descripcion;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.HistoriaMedicaId;
import co.com.sofka.domain.generic.DomainEvent;

public class DescripcionDeHistoriMedicaActualizada extends DomainEvent {
    public DescripcionDeHistoriMedicaActualizada(HistoriaMedicaId historiaMedicaId, Descripcion descripcion) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.DescripcionDeHistoriMedicaActualizada");
    }
}
