package co.com.clinica_veterinaria.atencion_al_usuario.usuario.events;

import co.com.clinica_veterinaria.atencion_al_usuario.usuario.values.PacienteId;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.FechaDeNacimiento;
import co.com.clinica_veterinaria.atencion_al_usuario.values_generic.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class PacienteCreado extends DomainEvent {
    public PacienteCreado(PacienteId pacienteId, NombreCompleto nombreCompleto, FechaDeNacimiento fechaDeNacimiento) {
        super("co.com.clinica_veterinaria.atencion_al_usuario.PacienteCreado");
    }
}
