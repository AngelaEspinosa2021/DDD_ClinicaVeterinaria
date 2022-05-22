package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.MedicoId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.DatosDeContacto;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.Entity;

public class Medico extends Entity<MedicoId> {
    protected NombreCompleto nombreCompleto;
    protected DatosDeContacto datosDeContacto;
    protected Fecha fechaDeNacimiento;

    public Medico(MedicoId medicoId,NombreCompleto nombreCompleto,DatosDeContacto datosDeContacto,Fecha fechaDeNacimiento) {
        super(medicoId);
        this.nombreCompleto = nombreCompleto;
        this.datosDeContacto = datosDeContacto;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

   public void actualizarNombreCompleto(NombreCompleto nombreCompleto){
        this.nombreCompleto=nombreCompleto;
    }

    public NombreCompleto nombreCompleto() {
        return nombreCompleto;
    }

    public DatosDeContacto datosDeContacto() {
        return datosDeContacto;
    }

    public Fecha fechaDeNacimiento() {
        return fechaDeNacimiento;
    }
}
