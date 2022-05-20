package co.com.clinica_veterinaria.atencion_al_usuario.usuario.commands;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.PacienteId;
import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.UsuarioId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.Fecha;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.Command;

public class AgregarPaciente extends Command {
    private final UsuarioId usuarioId;
    private final PacienteId pacienteId;
    private final NombreCompleto nombreCompleto;
    private final Fecha fechaDeNacimiento;

    public AgregarPaciente(UsuarioId usuarioId, PacienteId pacienteId, NombreCompleto nombreCompleto, Fecha fechaDeNacimiento) {
        this.usuarioId = usuarioId;
        this.pacienteId = pacienteId;
        this.nombreCompleto = nombreCompleto;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }

    public PacienteId getPacienteId() {
        return pacienteId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public Fecha getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
}
