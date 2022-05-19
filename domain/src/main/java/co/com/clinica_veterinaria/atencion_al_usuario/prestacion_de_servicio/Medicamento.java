package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.MedicamentoId;
import co.com.sofka.domain.generic.Entity;

public class Medicamento extends Entity<MedicamentoId> {
    public Medicamento(MedicamentoId entityId) {
        super(entityId);
    }
}