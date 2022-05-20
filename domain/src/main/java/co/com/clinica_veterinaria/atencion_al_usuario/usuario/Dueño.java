package co.com.clinica_veterinaria.atencion_al_usuario.usuario;

import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.DatosDeContacto;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.DueñoId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.FechaDeNacimiento;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Dueño extends Entity<DueñoId> {

    private NombreCompleto nombreCompleto;
    private DatosDeContacto datosDeContacto;
    private FechaDeNacimiento fechaDeNacimiento;


    public Dueño(DueñoId dueñoId,NombreCompleto nombreCompleto,DatosDeContacto datosDeContacto,FechaDeNacimiento fechaDeNacimiento){
        super(dueñoId);
        this.nombreCompleto=nombreCompleto;
        this.datosDeContacto=datosDeContacto;
        this.fechaDeNacimiento=fechaDeNacimiento;
    }

    public void actualizarDatosDeContacto(DatosDeContacto datosDeContacto){
        this.datosDeContacto=Objects.requireNonNull(datosDeContacto);
    }

    public void actualizarNombreCompleto(NombreCompleto nombreCompleto){
        this.nombreCompleto=Objects.requireNonNull(nombreCompleto);
    }

    public NombreCompleto nombreCompleto() {
        return nombreCompleto;
    }

    public DatosDeContacto datosDeContacto() {
        return datosDeContacto;
    }

    public FechaDeNacimiento fechaDeNacimiento() {
        return fechaDeNacimiento;
    }
}
