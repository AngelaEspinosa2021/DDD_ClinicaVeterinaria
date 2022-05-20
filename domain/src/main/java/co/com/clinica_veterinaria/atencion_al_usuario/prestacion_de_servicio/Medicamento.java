package co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio;

import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.FechaDeVencimiento;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.MedicamentoId;
import co.com.clinica_veterinaria.atencion_al_usuario.prestacion_de_servicio.values.Nombre;
import co.com.sofka.domain.generic.Entity;

public class Medicamento extends Entity<MedicamentoId> {
    protected Nombre nombre;
    protected FechaDeVencimiento fechaDeVencimiento;

    public Medicamento(MedicamentoId medicamentoId,Nombre nombre,FechaDeVencimiento fechaDeVencimiento){
        super(medicamentoId);
        this.nombre = nombre;
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public void actualizarNombre(Nombre nombre){
        this.nombre=nombre;
    }

    public void actualizarFechaDeVencimiento(FechaDeVencimiento fechaDeVencimiento){
        this.fechaDeVencimiento=fechaDeVencimiento;
    }

    public Nombre nombre() {
        return nombre;
    }

    public FechaDeVencimiento fechaDeVencimiento() {
        return fechaDeVencimiento;
    }
}
