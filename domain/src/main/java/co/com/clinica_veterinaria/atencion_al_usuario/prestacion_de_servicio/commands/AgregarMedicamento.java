package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.MedicamentoId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Nombre;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.Command;

public class AgregarMedicamento extends Command {
    private final MedicamentoId medicamentoId;
    private final Nombre nombre;
    private final Fecha fechaDeVencimiento;

    public AgregarMedicamento(MedicamentoId medicamentoId, Nombre nombre, Fecha fechaDeVencimiento) {
        this.medicamentoId = medicamentoId;
        this.nombre = nombre;
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public MedicamentoId getMedicamentoId() {
        return medicamentoId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Fecha getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }
}
