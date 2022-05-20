package co.com.clinica_veterinaria.atencion_al_usuario.usuario.events;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.PacienteId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.FechaDeNacimiento;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class PacienteCreado extends DomainEvent {
    private final PacienteId pacienteId;
    private final NombreCompleto nombreCompleto;
    private final FechaDeNacimiento fechaDeNacimiento;

    public PacienteCreado(PacienteId pacienteId, NombreCompleto nombreCompleto, FechaDeNacimiento fechaDeNacimiento) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.PacienteCreado");
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
