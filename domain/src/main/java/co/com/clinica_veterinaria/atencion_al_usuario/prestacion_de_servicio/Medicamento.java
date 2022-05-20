package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.MedicamentoId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Nombre;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.sofka.domain.generic.Entity;

public class Medicamento extends Entity<MedicamentoId> {
    protected Nombre nombre;
    protected Fecha fechaDeVencimiento;

    public Medicamento(MedicamentoId medicamentoId, Nombre nombre) {
        super(medicamentoId);
        this.nombre = nombre;
    }

    public void actualizarNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public Nombre nombre() {
        return nombre;
    }

}
