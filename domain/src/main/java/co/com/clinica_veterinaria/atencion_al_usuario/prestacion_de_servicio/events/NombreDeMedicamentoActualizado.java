package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.MedicamentoId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreDeMedicamentoActualizado extends DomainEvent {
    private final MedicamentoId medicamentoId;
    private final Nombre nombre;

    public NombreDeMedicamentoActualizado(MedicamentoId medicamentoId, Nombre nombre) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.NombreDeMedicamentoActualizado");
        this.medicamentoId = medicamentoId;
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
