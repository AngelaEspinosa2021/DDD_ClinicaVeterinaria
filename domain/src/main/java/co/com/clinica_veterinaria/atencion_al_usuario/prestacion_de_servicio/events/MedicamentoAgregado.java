package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.MedicamentoId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Nombre;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.DomainEvent;

public class MedicamentoAgregado extends DomainEvent {
    private final MedicamentoId medicamentoId;
    private final Nombre nombre;

    public MedicamentoAgregado(MedicamentoId medicamentoId, Nombre nombre) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.MedicamentoAgregado");
        this.medicamentoId = medicamentoId;
        this.nombre = nombre;
    }

    public MedicamentoId getMedicamentoId() {
        return medicamentoId;
    }

    public Nombre getNombre() {
        return nombre;
    }

}
