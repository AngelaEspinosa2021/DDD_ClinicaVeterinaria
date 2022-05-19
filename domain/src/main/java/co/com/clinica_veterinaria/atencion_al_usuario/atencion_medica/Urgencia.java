package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.UrgenciaId;
import co.com.sofka.domain.generic.Entity;

public class Urgencia extends Entity<UrgenciaId> {
    public Urgencia(UrgenciaId entityId) {
        super(entityId);
    }
}