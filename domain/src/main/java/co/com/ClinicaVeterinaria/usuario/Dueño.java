package co.com.ClinicaVeterinaria.usuario;

import co.com.ClinicaVeterinaria.usuario.values.DueñoId;
import co.com.sofka.domain.generic.Entity;

public class Dueño extends Entity<DueñoId> {
    public Dueño(DueñoId entityId) {
        super(entityId);
    }
}
