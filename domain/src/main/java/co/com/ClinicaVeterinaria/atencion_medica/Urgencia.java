package co.com.ClinicaVeterinaria.atencion_medica;

import co.com.ClinicaVeterinaria.atencion_medica.values.UrgenciaId;
import co.com.sofka.domain.generic.Entity;

public class Urgencia extends Entity<UrgenciaId> {
    public Urgencia(UrgenciaId entityId) {
        super(entityId);
    }
}
