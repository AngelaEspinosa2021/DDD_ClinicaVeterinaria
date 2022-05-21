package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.events;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.MedicamentoId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Nombre;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.DomainEvent;

public class MedicamentoAgregado extends DomainEvent {
    private final MedicamentoId medicamentoId;
    private final Nombre nombre;
    private final Fecha FechaDeVencimiento;

    public MedicamentoAgregado(MedicamentoId medicamentoId, Nombre nombre, Fecha fechaDeVencimiento) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.MedicamentoAgregado");
        this.medicamentoId = medicamentoId;
        this.nombre = nombre;
        FechaDeVencimiento = fechaDeVencimiento;
    }

    public MedicamentoId getMedicamentoId() {
        return medicamentoId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Fecha getFechaDeVencimiento() {return FechaDeVencimiento;}
}
