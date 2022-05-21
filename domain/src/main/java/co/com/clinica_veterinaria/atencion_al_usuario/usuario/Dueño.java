package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.DatosDeContacto;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.DueñoId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Dueño extends Entity<DueñoId> {

    protected NombreCompleto nombreCompleto;
    protected DatosDeContacto datosDeContacto;
    protected Fecha fechaDeNacimiento;


    public Dueño(DueñoId dueñoId,NombreCompleto nombreCompleto,DatosDeContacto datosDeContacto,Fecha fechaDeNacimiento){
        super(dueñoId);
        this.nombreCompleto=nombreCompleto;
        this.datosDeContacto=datosDeContacto;
        this.fechaDeNacimiento=fechaDeNacimiento;
    }

    public void actualizarNombreCompleto(NombreCompleto nombreCompleto){
        this.nombreCompleto=Objects.requireNonNull(nombreCompleto);
    }

}
