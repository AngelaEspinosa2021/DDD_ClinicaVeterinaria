package co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.atencion_medica.values.MedicoId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.DatosDeContacto;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.Command;

public class AgregarMedico extends Command {
    private final MedicoId medicoId;
    private final NombreCompleto nombreCompleto;
    private final DatosDeContacto datosDeContacto;
    private final Fecha fechaDeNacimiento;

    public AgregarMedico(MedicoId medicoId, NombreCompleto nombreCompleto, DatosDeContacto datosDeContacto, Fecha fechaDeNacimiento) {
        this.medicoId = medicoId;
        this.nombreCompleto = nombreCompleto;
        this.datosDeContacto = datosDeContacto;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public MedicoId getMedicoId() {
        return medicoId;
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
