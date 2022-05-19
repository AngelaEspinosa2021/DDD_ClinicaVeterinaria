package co.com.ClinicaVeterinaria.prestacion_de_servicio;

import co.com.ClinicaVeterinaria.prestacion_de_servicio.values.MedicamentoId;
import co.com.sofka.domain.generic.Entity;

public class Medicamento extends Entity<MedicamentoId> {
    public Medicamento(MedicamentoId entityId) {
        super(entityId);
    }
}
