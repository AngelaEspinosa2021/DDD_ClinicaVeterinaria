package co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.PacienteId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.FechaDeNacimiento;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.Command;

public class AgregarPaciente extends Command {
    private PacienteId pacienteId;
    private NombreCompleto nombreCompleto;
    private FechaDeNacimiento fechaDeNacimiento;

    public AgregarPaciente(PacienteId pacienteId, NombreCompleto nombreCompleto, FechaDeNacimiento fechaDeNacimiento) {
        this.pacienteId = pacienteId;
        this.nombreCompleto = nombreCompleto;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public PacienteId getPacienteId() {
        return pacienteId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public FechaDeNacimiento getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
}
