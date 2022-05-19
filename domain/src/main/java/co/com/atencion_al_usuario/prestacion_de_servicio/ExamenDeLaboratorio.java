package co.com.ClinicaVeterinaria.prestacion_de_servicio;

import co.com.ClinicaVeterinaria.prestacion_de_servicio.values.ExamenId;
import co.com.sofka.domain.generic.Entity;

public class ExamenDeLaboratorio extends Entity<ExamenId> {
    public ExamenDeLaboratorio(ExamenId entityId) {
        super(entityId);
    }
}
