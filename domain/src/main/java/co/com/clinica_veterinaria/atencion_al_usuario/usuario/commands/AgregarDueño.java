package co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.DueñoId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.DatosDeContacto;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.Command;

public class AgregarDueño extends Command {

    private DueñoId dueñoId;
    private NombreCompleto nombreCompleto;
    private DatosDeContacto datosDeContacto;
    private Fecha fechaDeNacimiento;

    public AgregarDueño(DueñoId dueñoId, NombreCompleto nombreCompleto, DatosDeContacto datosDeContacto, Fecha fechaDeNacimiento) {
        this.dueñoId = dueñoId;
        this.nombreCompleto = nombreCompleto;
        this.datosDeContacto = datosDeContacto;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public DueñoId getDueñoId() {
        return dueñoId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public DatosDeContacto getDatosDeContacto() {
        return datosDeContacto;
    }

    public Fecha getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
}
